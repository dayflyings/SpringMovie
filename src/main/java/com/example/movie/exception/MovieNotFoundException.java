package com.example.movie.exception;

public class MovieNotFoundException extends RuntimeException{
    private String errorMessage;

    public MovieNotFoundException() {
        super();
    }

    public MovieNotFoundException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
