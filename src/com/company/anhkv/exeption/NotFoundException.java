package com.company.anhkv.exeption;

public class NotFoundException extends Exception {
    public NotFoundException(int id) {
        super("Element not found: "+id);
    }

}
