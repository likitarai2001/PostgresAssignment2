package com.example.onlineShopping.exception;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(String msg){
        super(msg);
    }
}
