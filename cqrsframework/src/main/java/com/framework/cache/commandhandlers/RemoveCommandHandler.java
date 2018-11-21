package com.framework.cache.commandhandlers;

import com.framework.data.repositories.IRepository;
import com.framework.services.RepositoryCommandHandler;

/**
 * In Java, we cannot implement the same interface twice (even with different generics)
 * So, we have to implement only a generic version of the method and then differ
 */
public class RemoveCommandHandler<T> extends RepositoryCommandHandler<T> {

    public RemoveCommandHandler(IRepository<T> repository) {
        super(repository);
    }

    @Override
    protected void execute(IRepository<T> repository, T entity) {
        //repository.remove(entity);
    }
}
