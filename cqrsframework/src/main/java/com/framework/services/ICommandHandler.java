package com.framework.services;

public interface ICommandHandler<IN extends Command> {
    void handle(IN command);
}
