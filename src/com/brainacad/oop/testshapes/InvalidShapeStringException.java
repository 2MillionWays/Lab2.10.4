package com.brainacad.oop.testshapes;

//Lab 2.10.4

public class InvalidShapeStringException extends Exception {
    private String message;

    public InvalidShapeStringException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
    /* In case of this task you don't need here String message field. You can use it from Exception class
}
