package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.core.domains.Event;
import dev.java10x.EventClean.core.usecases.CreateEventUsecase;
import dev.java10x.EventClean.core.usecases.FindEventByIdentifierUsecase;
import dev.java10x.EventClean.core.usecases.FindEventUsecase;
import dev.java10x.EventClean.core.usecases.RandomIdentifierUsecase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUsecase createEventUsecase;
    private final FindEventUsecase findEventUsecase;
    private final FindEventByIdentifierUsecase findEventByIdentifierUsecase;
    private final RandomIdentifierUsecase randomIdentifierUsecase;
    private final EventDtoMapper eventDtoMapper;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventDto){

        String identifier = randomIdentifierUsecase.execute();

        Event newEvent = createEventUsecase.execute(eventDtoMapper.toDomain(eventDto, identifier));

        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Event Created");
        response.put("Data: ", eventDtoMapper.toEventDto(newEvent));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> findEvent(){

        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Events Found");
        response.put("Data: ", findEventUsecase.execute().stream().map(eventDtoMapper::toEventDto).toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/identifier/{identifier}")
    public ResponseEntity<Map<String, Object>> findEventByIdentifier(@PathVariable String identifier){

        Event eventByIdentifier = findEventByIdentifierUsecase.execute(identifier);

        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Event Found");
        response.put("Data: ", eventDtoMapper.toEventDto(eventByIdentifier));

        return ResponseEntity.ok(response);
    }
}
