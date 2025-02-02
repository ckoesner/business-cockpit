package io.vanillabp.cockpit.workflowlist.model;

import java.time.OffsetDateTime;
import java.util.Map;

import io.vanillabp.cockpit.commons.mongo.updateinfo.UpdateInformationAware;
import io.vanillabp.cockpit.tasklist.model.UiUriType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = Workflow.COLLECTION_NAME)
public class Workflow implements UpdateInformationAware {

    public static final String COLLECTION_NAME = "workflow";

    @Id
    private String id;

    @Version
    private long version;

    private String initiator;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private String updatedBy;

    private OffsetDateTime endedAt;

    private String source;

    private String workflowModule;

    private String comment;

    private String bpmnProcessId;

    private String bpmnProcessVersion;

    private String workflowId;

    private String businessId;

    private Map<String, String> title;

    private String workflowModuleUri;

    private String workflowProviderApiUriPath;

    private String uiUriPath;

    private UiUriType uiUriType;

    private Map<String, Object> details = null;

    private String detailsFulltextSearch;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public OffsetDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(OffsetDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWorkflowModule() {
        return workflowModule;
    }

    public void setWorkflowModule(String workflowModule) {
        this.workflowModule = workflowModule;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBpmnProcessId() {
        return bpmnProcessId;
    }

    public void setBpmnProcessId(String bpmnProcessId) {
        this.bpmnProcessId = bpmnProcessId;
    }

    public String getBpmnProcessVersion() {
        return bpmnProcessVersion;
    }

    public void setBpmnProcessVersion(String bpmnProcessVersion) {
        this.bpmnProcessVersion = bpmnProcessVersion;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Map<String, String> getTitle() {
        return title;
    }

    public void setTitle(Map<String, String> title) {
        this.title = title;
    }

    public String getWorkflowModuleUri() {
        return workflowModuleUri;
    }

    public void setWorkflowModuleUri(String workflowModuleUri) {
        this.workflowModuleUri = workflowModuleUri;
    }

    public String getWorkflowProviderApiUriPath() {
        return workflowProviderApiUriPath;
    }

    public void setWorkflowProviderApiUriPath(String workflowProviderApiUriPath) {
        this.workflowProviderApiUriPath = workflowProviderApiUriPath;
    }

    public String getUiUriPath() {
        return uiUriPath;
    }

    public void setUiUriPath(String uiUriPath) {
        this.uiUriPath = uiUriPath;
    }

    public UiUriType getUiUriType() {
        return uiUriType;
    }

    public void setUiUriType(UiUriType uiUriType) {
        this.uiUriType = uiUriType;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }

    public String getDetailsFulltextSearch() {
        return detailsFulltextSearch;
    }

    public void setDetailsFulltextSearch(String detailsFulltextSearch) {
        this.detailsFulltextSearch = detailsFulltextSearch;
    }
}
