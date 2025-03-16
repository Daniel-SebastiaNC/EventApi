package dev.java10x.EventClean.infra.exceptions;

public class IdentifierBadRequest extends RuntimeException {
    public IdentifierBadRequest(String message) {
      super(message);
    }
}
