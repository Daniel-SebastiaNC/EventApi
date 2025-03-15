package dev.java10x.EventClean.infra.dtos;

import dev.java10x.EventClean.core.enuns.TypeEvent;
import lombok.Builder;

import java.time.LocalDateTime;

public record EventDto(Long id,
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
