package com.balsani.user.domain.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(Long id) {
        super("Não foi possiúvel econtrar");
    }
}
