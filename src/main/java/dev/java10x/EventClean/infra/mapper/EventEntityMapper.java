package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {
    public Event toDomain(EventEntity eventEntity){
        return new Event(
                eventEntity.getId(),
                eventEntity.getName(),
                eventEntity.getDescription(),
                eventEntity.getIdentifier(),
                eventEntity.getStartDate(),
                eventEntity.getEndDate(),
                eventEntity.getLocation(),
                eventEntity.getOrganizer(),
                eventEntity.getCapacity(),
                eventEntity.getType()
        );
    }

    public EventEntity toEventEntity(Event event){
        return new EventEntity(
                event.id(),
                event.name(),
                event.description(),
                event.identifier(),
                event.startDate(),
                event.endDate(),
                event.location(),
                event.organizer(),
                event.capacity(),
                event.type()
        );
    }
}
