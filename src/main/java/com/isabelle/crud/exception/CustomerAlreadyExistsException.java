package com.isabelle.crud.exception;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException (String message){
        super(message);
    }
}
