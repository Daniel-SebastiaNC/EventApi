package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;

public interface CreateEventUsecase {
    public Event execute(Event event);
}
