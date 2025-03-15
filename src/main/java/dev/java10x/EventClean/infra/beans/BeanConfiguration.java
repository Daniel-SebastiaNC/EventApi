package dev.java10x.EventClean.infra.beans;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.usecases.CreateEventCase;
import dev.java10x.EventClean.core.usecases.CreateEventCaseImpl;
import dev.java10x.EventClean.core.usecases.FindEventCase;
import dev.java10x.EventClean.core.usecases.FindEventCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventCase createEventCase(EventGateway eventGateway){
        return new CreateEventCaseImpl(eventGateway);
    }

    @Bean
    public FindEventCase findEventCase(EventGateway eventGateway){
        return new FindEventCaseImpl(eventGateway);
    }
}
