package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;

public interface FindEventByIdentifierUsecase {
    public Event execute(String identifier);
}
