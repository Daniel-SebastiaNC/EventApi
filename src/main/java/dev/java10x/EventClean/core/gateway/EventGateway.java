package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.domains.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {
    Event createEvent(Event event);
    List<Event> findEvent();
    boolean isExistByIdentifier(String identifier);
    Optional<Event> findEventByIdentifier(String identifier);
}
