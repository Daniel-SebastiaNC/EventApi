package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infra.exceptions.DataNotFoundException;

public class FindEventByIdentifierUsecaseImpl implements FindEventByIdentifierUsecase {

    private final EventGateway eventGateway;

    public FindEventByIdentifierUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.findEventByIdentifier(identifier)
                .orElseThrow(() -> new DataNotFoundException("Event with identifier '" + identifier +"' Not Found"));
    }
}
