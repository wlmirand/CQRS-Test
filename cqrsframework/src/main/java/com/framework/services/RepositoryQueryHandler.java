package com.framework.services;

import com.framework.data.repositories.IRepository;

public abstract class RepositoryQueryHandler<IN extends Query, OUT> implements IQueryHandler<IN, OUT> {

    protected IRepository<OUT> repository;

    public RepositoryQueryHandler(IRepository<OUT> repository) {
        this.repository = repository;
    }
}
