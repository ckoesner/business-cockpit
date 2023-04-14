import { Text, TextProps } from 'grommet';
import React, { PropsWithChildren } from 'react';
import styled from 'styled-components';

interface LinkProps extends PropsWithChildren<TextProps> {
  href?: string;
  target?: string;
};

const StyledLink = styled(Text)<LinkProps>`
  text-decoration: none;
  color: ${props => props.theme.global.colors['accent-3'] };
  cursor: pointer;

  &:hover {
    text-decoration: underline;
    color: black;
  }

  &:visited {
    color: ${props => props.theme.global.colors['accent-3'] };
  }
`;

const Link = ({ ...props }: LinkProps) => <StyledLink
    as="a"
    { ...props } />

export { Link };

