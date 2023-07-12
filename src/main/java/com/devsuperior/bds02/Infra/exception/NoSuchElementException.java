package com.devsuperior.bds02.Infra.exception;

public class NoSuchElementException extends RuntimeException {
    public NoSuchElementException(String msg){
        super(msg);
    }
}
