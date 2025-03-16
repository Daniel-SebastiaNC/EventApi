package dev.java10x.EventClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IdentifierBadRequest.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handlerIdentifierBadRequest(IdentifierBadRequest ex){
        Map<String, String> error = new HashMap<>();
        error.put("Error: ", ex.getMessage());
        error.put("Message: ", "Please, insert a valid HashIdentifier for your event and try again");
        return error;
    }
}
