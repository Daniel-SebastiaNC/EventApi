package dev.java10x.EventClean.infra.beans;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUsecase createEventCase(EventGateway eventGateway){
        return new CreateEventUsecaseImpl(eventGateway);
    }

    @Bean
    public FindEventUsecase findEventCase(EventGateway eventGateway){
        return new FindEventUsecaseImpl(eventGateway);
    }

    @Bean
    public FindEventByIdentifierUsecase findEventByIdentifierUsecase(EventGateway eventGateway){
        return new FindEventByIdentifierUsecaseImpl(eventGateway);
    }
}
