package com.itb.mif3an.pizzariabomgosto.exceptions;


public class BadRequest extends RuntimeException {

    public BadRequest(String message) {
        // super: acessando o construtor da classe pai
        super(message);
    }
}