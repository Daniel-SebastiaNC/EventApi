package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;

import java.util.List;

public interface FindEventUsecase {
    public List<Event> execute();
}
