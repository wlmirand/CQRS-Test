package com.framework.services;

import com.framework.data.repositories.IRepository;

public abstract class PreferenceCommandHandler<TYPE> implements ICommandHandler<Command<TYPE>> {

    //private IRepository<TYPE> repository;

    public PreferenceCommandHandler(/*...*/) {
        //this.repository = repository;
    }

    @Override
    public void handle(Command<TYPE> command) {
        //execute(repository, command.getMessage());
    }

    protected abstract void execute(IRepository<TYPE> repository, TYPE entity);
}
