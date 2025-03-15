package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.domains.Event;

import java.util.List;

public interface EventGateway {
    Event createEvent(Event event);
    List<Event> findEvent();
}
