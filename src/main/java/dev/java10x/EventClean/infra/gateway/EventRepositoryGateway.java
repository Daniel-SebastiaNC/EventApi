package dev.java10x.EventClean.infra.gateway;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infra.exceptions.DataNotFoundException;
import dev.java10x.EventClean.infra.mapper.EventEntityMapper;
import dev.java10x.EventClean.infra.persistence.EventEntity;
import dev.java10x.EventClean.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {
        EventEntity saveEvent = eventRepository.save(eventEntityMapper.toEventEntity(event));
        return eventEntityMapper.toDomain(saveEvent);
    }

    @Override
    public List<Event> findEvent() {
        return eventRepository.findAll().stream().map(eventEntityMapper::toDomain).toList();
    }

    @Override
    public boolean isExistByIdentifier(Event event) {
        return  eventRepository.findEventByIdentifier(event.identifier()).isPresent();
    }

    @Override
    public Optional<Event> findEventByIdentifier(String identifier) {
        return eventRepository.findEventByIdentifier(identifier).map(eventEntityMapper::toDomain);
    }
}
