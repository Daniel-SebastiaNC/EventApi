package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infra.exceptions.IdentifierBadRequest;


public class CreateEventUsecaseImpl implements CreateEventUsecase {

    private final EventGateway eventGateway;

    public CreateEventUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        if (eventGateway.isExistByIdentifier(event.identifier())) {
            throw new IdentifierBadRequest(event.identifier() + " is Already Used");
        }
        return eventGateway.createEvent(event);
    }
}
