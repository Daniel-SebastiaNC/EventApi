package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;

public interface CreateEventCase {
    public Event execute(Event event);
}
