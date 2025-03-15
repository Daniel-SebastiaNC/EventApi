package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.infra.dtos.EventDto;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {
    public Event toDomain(EventDto eventDto){
        return new Event(
                eventDto.id(),
                eventDto.name(),
                eventDto.description(),
                eventDto.identifier(),
                eventDto.startDate(),
                eventDto.endDate(),
                eventDto.location(),
                eventDto.organizer(),
                eventDto.capacity(),
                eventDto.type()
        );
    }

    public EventDto toEventDto(Event event){
        return new EventDto(
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
