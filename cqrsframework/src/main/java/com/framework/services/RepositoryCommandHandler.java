package com.framework.services;

import com.framework.data.repositories.IRepository;

public abstract class RepositoryCommandHandler<TYPE> implements ICommandHandler<Command<TYPE>> {

    private IRepository<TYPE> repository;

    public RepositoryCommandHandler(IRepository<TYPE> repository) {
        this.repository = repository;
    }

    @Override
    public void handle(Command<TYPE> command) {
        execute(repository, command.getMessage());
    }

    protected abstract void execute(IRepository<TYPE> repository, TYPE entity);
}
