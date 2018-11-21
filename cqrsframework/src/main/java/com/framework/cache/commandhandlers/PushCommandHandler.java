package com.framework.cache.commandhandlers;

import com.framework.data.repositories.IRepository;
import com.framework.services.RepositoryCommandHandler;

public class PushCommandHandler<T> extends RepositoryCommandHandler<T> {

    public PushCommandHandler(IRepository<T> repository) {
        super(repository);
    }

    @Override
    protected void execute(IRepository<T> repository, T entity) {
        repository.save(entity);
    }
}
