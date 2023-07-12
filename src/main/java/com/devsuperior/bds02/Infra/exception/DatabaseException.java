package com.devsuperior.bds02.Infra.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg){
        super(msg);
    }
}
