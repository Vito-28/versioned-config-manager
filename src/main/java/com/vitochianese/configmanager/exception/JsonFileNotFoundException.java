package com.vitochianese.configmanager.exception;

public class JsonFileNotFoundException extends RuntimeException {
    public JsonFileNotFoundException(String message) {
        super(message);
    }
}
