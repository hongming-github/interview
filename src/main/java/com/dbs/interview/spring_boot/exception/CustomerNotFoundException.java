package com.dbs.interview.spring_boot.exception;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(UUID id) {
        super("Could not find customer " + id);
    }
}
