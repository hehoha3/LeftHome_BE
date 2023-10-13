package com.example.firstWebBE.config.exceptionHandler;

public class ProductNotExistsException extends Throwable{
    public ProductNotExistsException(String msg){
        super(msg);
    }
}
