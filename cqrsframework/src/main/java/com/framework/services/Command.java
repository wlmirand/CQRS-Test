package com.framework.services;

public abstract class Command<T> implements ICommand {

    private T message;

    protected Command(T message) {
        this.message = message;
    }

    public T getMessage() {
        return message;
    }
}
