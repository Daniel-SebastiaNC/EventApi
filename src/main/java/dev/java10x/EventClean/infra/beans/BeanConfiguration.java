package dev.java10x.EventClean.infra.beans;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.usecases.CreateEventUsecase;
import dev.java10x.EventClean.core.usecases.CreateEventUsecaseImpl;
import dev.java10x.EventClean.core.usecases.FindEventUsecase;
import dev.java10x.EventClean.core.usecases.FindEventUsecaseImpl;
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
}
