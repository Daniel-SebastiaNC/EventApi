package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.gateway.EventGateway;

import java.util.Random;

public class RandomIdentifierUsecaseImpl implements RandomIdentifierUsecase {

    private final EventGateway eventGateway;

    public RandomIdentifierUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public String execute() {
        while (true){
            Random generate = new Random();

            String identifier = "";

            while (identifier.length() < 3){
                char c = (char) ('a' + generate.nextInt(26));
                identifier += c;
            }

            identifier = identifier + generate.nextInt(1000);

            if (!eventGateway.isExistByIdentifier(identifier)) {
                return identifier;
            }
        }

    }
}
