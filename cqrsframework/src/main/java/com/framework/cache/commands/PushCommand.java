package com.framework.cache.commands;

import com.framework.services.Command;

public class PushCommand<T> extends Command<T> {

    public PushCommand(T message) {
        super(message);
    }
}
