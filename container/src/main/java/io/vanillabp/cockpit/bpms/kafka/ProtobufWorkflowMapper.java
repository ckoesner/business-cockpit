package io.vanillabp.cockpit.bpms.kafka;

import com.google.protobuf.Timestamp;
import io.vanillabp.cockpit.bpms.api.protobuf.v1.DetailsMap;
import io.vanillabp.cockpit.bpms.api.protobuf.v1.WorkflowCreatedOrUpdatedEvent;
import io.vanillabp.cockpit.util.protobuf.ProtobufHelper;
import io.vanillabp.cockpit.workflowlist.model.Workflow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.time.OffsetDateTime;
import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.DEFAULT)
public abstract class ProtobufWorkflowMapper {

    private static final String DETAILS_MAPPING = "detailsMapping";

    @Mapping(target = "id", source = "workflowId")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", source = "timestamp")
    @Mapping(target = "updatedAt", source = "timestamp")
    @Mapping(target = "updatedBy", source = "initiator")
    @Mapping(target = "endedAt", ignore = true)
    @Mapping(target = "dangling", ignore = true)
    @Mapping(target = "targetRoles", ignore = true)
    @Mapping(target = "accessibleToUsers", source = "accessibleToUsersList")
    @Mapping(target = "accessibleToGroups", source = "accessibleToGroupsList")
    @Mapping(target = "details", source = "details", qualifiedByName = DETAILS_MAPPING)
    public abstract Workflow toNewWorkflow(WorkflowCreatedOrUpdatedEvent event);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", source = "timestamp")
    @Mapping(target = "updatedBy", source = "initiator")
    @Mapping(target = "endedAt", ignore = true)
    @Mapping(target = "dangling", ignore = true)
    @Mapping(target = "targetRoles", ignore = true)
    @Mapping(target = "accessibleToUsers", source = "accessibleToUsersList")
    @Mapping(target = "accessibleToGroups", source = "accessibleToGroupsList")
    @Mapping(target = "details", source = "details", qualifiedByName = DETAILS_MAPPING)
    public abstract Workflow toUpdatedWorkflow(WorkflowCreatedOrUpdatedEvent event, @MappingTarget Workflow result);

    public OffsetDateTime map(Timestamp value) {
        return ProtobufHelper.map(value);
    }

    @Named(DETAILS_MAPPING)
    protected Map<String, Object> map(
            final DetailsMap detailsMap) {
        return DetailsMapper.mapMapValue(detailsMap);
    }

}