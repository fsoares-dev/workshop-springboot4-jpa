package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    //se nao achar o id ai lança a exceção
    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
