package com.example.movie.exception;

public class GeneralException extends RuntimeException{
    private String errorMessage;

    public GeneralException() {
        super();
    }

    public GeneralException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
