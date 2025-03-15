package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;


public class CreateEventCaseImpl implements CreateEventCase {

    private final EventGateway eventGateway;

    public CreateEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        return eventGateway.createEvent(event);
    }
}
