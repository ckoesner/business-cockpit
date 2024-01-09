package io.vanillabp.cockpit.adapter.common.usertask;

import io.vanillabp.cockpit.adapter.common.usertask.events.UserTaskEvent;

import java.util.List;

public interface UserTaskPublishing {

    void publish(final List<UserTaskEvent> events);
}
