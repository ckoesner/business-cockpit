package io.vanillabp.cockpit.adapter.camunda7.workflow.events;

import java.time.OffsetDateTime;

import io.vanillabp.cockpit.adapter.common.workflow.EventWrapper;
import io.vanillabp.cockpit.bpms.api.v1.WorkflowCompletedEvent;

public class WorkflowCompleted implements EventWrapper {

    private final WorkflowCompletedEvent event;
    
    private final String apiVersion;
    
    public WorkflowCompleted(
            final WorkflowCompletedEvent event,
            final String apiVersion) {
        
        this.event = event;
        this.apiVersion = apiVersion;
        
    }
    
    @Override
    public String getApiVersion() {
        return apiVersion;
    }

    @Override
    public Object getEvent() {
        
        return event;
        
    }

    public void setId(String id) {
        event.setId(id);
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        event.setTimestamp(timestamp);
    }

    public void setComment(String comment) {
        event.setComment(comment);
    }
    
}
