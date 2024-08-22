package com.example.app.E_Learning_Application.exceptions;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String courseNotFound) {

        super(courseNotFound);
    }

    public ResourceNotFoundException() {
        super("course not found !");
    }
}
