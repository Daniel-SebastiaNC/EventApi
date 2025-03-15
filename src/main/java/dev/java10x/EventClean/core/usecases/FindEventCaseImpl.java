package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;

import java.util.List;

public class FindEventCaseImpl implements FindEventCase{

    private final EventGateway eventGateway;

    public FindEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.findEvent();
    }
}
