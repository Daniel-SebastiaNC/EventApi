package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.core.usecases.CreateEventUsecase;
import dev.java10x.EventClean.core.usecases.FindEventUsecase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUsecase createEventUsecase;
    private final FindEventUsecase findEventUsecase;
    private final EventDtoMapper eventDtoMapper;

    @PostMapping("/create")
    public EventDto createEvent(@RequestBody EventDto eventDto){
        Event newEvent = createEventUsecase.execute(eventDtoMapper.toDomain(eventDto));
        return eventDtoMapper.toEventDto(newEvent);
    }

    @GetMapping("/list")
    public List<EventDto> findEvent(){
        return findEventUsecase.execute().stream().map(eventDtoMapper::toEventDto).toList();
    }
}
