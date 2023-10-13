package com.example.firstWebBE.config.exceptionHandler;

public class CustomException extends IllegalArgumentException{
    public CustomException(String msg){
        super(msg);
    }
}
