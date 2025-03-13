package dev.java10x.EventClean.core.domains;

import dev.java10x.EventClean.core.enuns.TypeEvent;

import java.time.LocalDateTime;

public record Event(Long id,
                    String name,
                    String description,
                    String identifier,
                    LocalDateTime startDate,
                    LocalDateTime endDate,
                    String location,
                    String organizer,
                    Integer capacity,
                    TypeEvent type) {
}
