const { parseVersion } = require('./utils');
const { DefinePlugin } = require("webpack");
const { ModuleFederationPlugin } = require('webpack').container;
const { dependencies } = require('./package.json');
const path = require("path");

const aliases = {
  '@bc/official-gui-client': path.join(path.resolve(__dirname, '.'), "node_modules", "@bc", "official-gui-client"),
  '@bc/dev-shell': path.join(path.resolve(__dirname, '.'), "node_modules", "@bc", "dev-shell"),
  '@bc/shared': path.join(path.resolve(__dirname, '.'), "node_modules", "@bc", "shared"),
  'styled-components': path.join(path.resolve(__dirname, '.'), "node_modules", "styled-components"),
  'react': path.join(path.resolve(__dirname, '.'), "node_modules", "react"),
  'react-dom': path.join(path.resolve(__dirname, '.'), "node_modules", "react-dom")
};

module.exports = {
  devServer: {
    historyApiFallback: true,
    proxy: {
      '/official-api': {
        target: 'http://0.0.0.0:8079',
        secure: false,
        changeOrigin: true,
        logLevel: "debug",
      },
    },
  },
  webpack: {
    alias: aliases,
    configure: {
      ...(process.env.NODE_ENV !== 'production'
         ? {
             entry: './test/index.tsx',
           }
         : {
             output: {
               publicPath: '/wm/TestModule/',
             }
           }),
      // this conf come from https://github.com/relative-ci/bundle-stats/tree/master/packages/cli#webpack-configuration
      //stats: {
      //  errorDetails: true,
      //}
    },
    plugins: {
      remove: process.env.NODE_ENV !== 'production'
          ? []
          : [ 'HtmlWebpackPlugin' , 'MiniCssExtractPlugin' ],
      add: [
        new DefinePlugin({
          'process.env.BUILD_TIMESTAMP': `'${new Date().toISOString()}'`,
          'process.env.BUILD_VERSION': `'${parseVersion()}'`,
        }),
        ...(process.env.NODE_ENV !== 'production'
            ? []
            : [
                new ModuleFederationPlugin({
                  name: "TestModule",
                  filename: 'remoteEntry.js',
                  exposes: {
                    List: './src/List',
                    Form: './src/Form',
                  },
                  shared: {
                    react: {
                      singleton: true,
                      requiredVersion: dependencies["react"],
                    },
                    "react-dom": {
                      singleton: true,
                      requiredVersion: dependencies["react-dom"],
                    },
                  },
                }),
              ])
      ]
    }
  },
  plugins: [
    {
      plugin: {
        overrideWebpackConfig: ({ webpackConfig, pluginOptions, context: { paths } }) => {
          const moduleScopePlugin = webpackConfig.resolve.plugins.find(plugin => plugin.appSrcs && plugin.allowedFiles);
          if (moduleScopePlugin) {
            Object
                .keys(aliases)
                .map(key => aliases[key])
                .forEach(path => moduleScopePlugin.appSrcs.push(path));
          }
          const ignoreWarnings = [
              { module: /@microsoft\/fetch-event-source/ }
            ];
          return {
              ...webpackConfig,
              ignoreWarnings,
              //stats: 'verbose'
            };
        }
      }
    }
  ]
};
