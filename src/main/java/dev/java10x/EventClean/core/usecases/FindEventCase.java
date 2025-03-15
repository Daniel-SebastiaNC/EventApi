package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.domains.Event;

import java.util.List;

public interface FindEventCase {
    public List<Event> execute();
}
