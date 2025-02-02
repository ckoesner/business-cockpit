package io.vanillabp.cockpit.adapter.camunda7.workflow.events;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import io.vanillabp.cockpit.adapter.common.workflow.EventWrapper;
import io.vanillabp.cockpit.bpms.api.v1.WorkflowCreatedOrUpdatedEvent;
import io.vanillabp.spi.cockpit.usertask.DetailCharacteristics;
import io.vanillabp.spi.cockpit.workflow.PrefilledWorkflowDetails;

public class WorkflowCreated
        implements PrefilledWorkflowDetails, EventWrapper {

    private final WorkflowCreatedOrUpdatedEvent event;
    
    private List<String> i18nLanguages;

    private Map<String, ? extends DetailCharacteristics> detailsCharacteristics;

    private Object templateContext;
    
    private String uiUriPath;
    
    private String apiVersion;
    
    public WorkflowCreated(
            final WorkflowCreatedOrUpdatedEvent event,
            final String workflowModuleId,
            final List<String> i18nLanguages,
            final String apiVersion) {
        
        this.event = event;
        this.i18nLanguages = i18nLanguages;
        this.apiVersion = apiVersion;
        event.setUpdated(Boolean.FALSE);
        event.setWorkflowModule(workflowModuleId);
        
    }
    
    @Override
    public String getApiVersion() {
        return apiVersion;
    }
    
    @Override
    public void setId(String id) {
        event.setId(id);
    }

    @Override
    public String getEventId() {

        return event.getId();
        
    }
    
    @Override
    public OffsetDateTime getEventTimestamp() {
        
        return event.getTimestamp();
        
    }
    
    @Override
    public String getBpmnProcessVersion() {
        
        return event.getBpmnProcessVersion();
        
    }
    
    public void setWorkflowId(String workflowId) {
        event.setWorkflowId(workflowId);
    }

    public void setBusinessId(String businessId) {
        event.setBusinessId(businessId);
    }

    public void setBpmnProcessId(String bpmnProcessId) {
        event.setBpmnProcessId(bpmnProcessId);
    }

    public void setBpmnProcessVersion(String bpmnProcessVersion) {
        event.setBpmnProcessVersion(bpmnProcessVersion);
    }

    public String getBpmnProcessId() {
        return event.getBpmnProcessId();
    }

    @Override
    public void setI18nLanguages(
            final List<String> i18nLanguages) {
        
        this.i18nLanguages = i18nLanguages;
        
    }

    @Override
    public List<String> getI18nLanguages() {

        return i18nLanguages;
        
    }

    @Override
    public Map<String, ? extends DetailCharacteristics> getDetailsCharacteristics() {
        return detailsCharacteristics;
    }

    public void setDetailsCharacteristics(Map<String, ? extends DetailCharacteristics> detailsCharacteristics) {
        this.detailsCharacteristics = detailsCharacteristics;
    }

    public WorkflowCreatedOrUpdatedEvent getEvent() {
        return event;
    }

    public String getWorkflowId() {
        return event.getWorkflowId();
    }
    
    public String getInitiator() {
        return event.getInitiator();
    }

    public void setInitiator(String initiator) {
        event.setInitiator(initiator);
    }

    public OffsetDateTime getTimestamp() {
        return event.getTimestamp();
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        event.setTimestamp(timestamp);
    }

    public String getComment() {
        return event.getComment();
    }

    public void setComment(String comment) {
        event.setComment(comment);
    }

    public Map<String, String> getTitle() {
        return event.getTitle();
    }

    public void setTitle(Map<String, String> title) {
        event.setTitle(title);
    }

    public Map<String, Object> getDetails() {
        return event.getDetails();
    }

    public void setDetails(Map<String, Object> details) {
        event.setDetails(details);
    }

    public String getDetailsFulltextSearch() {
        return event.getDetailsFulltextSearch();
    }

    public void setDetailsFulltextSearch(String detailsFulltextSearch) {
        event.setDetailsFulltextSearch(detailsFulltextSearch);
    }
    
    public void setTemplateContext(Object templateContext) {
        
        this.templateContext = templateContext;
        
    }
    
    @Override
    public Object getTemplateContext() {
        
        return templateContext;
        
    }
    
    @Override
    public String getUiUriPath() {
        return uiUriPath;
    }
    
    public void setUiUriPath(String uiUriPath) {
        this.uiUriPath = uiUriPath;
    }
    
}
