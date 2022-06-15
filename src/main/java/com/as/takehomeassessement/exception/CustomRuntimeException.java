package com.as.takehomeassessement.exception;

public class CustomRuntimeException extends RuntimeException{

    public static final String DEFAULT_MESSAGE = "Not implemented method. This won't be used for this test";
    public CustomRuntimeException(String message){
        super(message);
    }

    public CustomRuntimeException(Exception exception){
        super(exception);
    }

}
