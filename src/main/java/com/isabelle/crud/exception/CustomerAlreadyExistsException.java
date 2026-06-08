package com.isabelle.crud.exception;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException (String message){
        super(message);
    }
}
// todo: Alterar ela pra 422.
// todo: Usar Try-Catch
