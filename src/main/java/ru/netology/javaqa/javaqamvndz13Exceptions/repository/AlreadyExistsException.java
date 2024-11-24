package ru.netology.javaqa.javaqamvndz13Exceptions.repository;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String s) {
        super(s);
    }
}
