package com.framework.cache.commands;

import com.framework.services.Command;

public class RemoveCommand<T> extends Command<T> {

    public RemoveCommand(T message) {
        super(message);
    }
}
