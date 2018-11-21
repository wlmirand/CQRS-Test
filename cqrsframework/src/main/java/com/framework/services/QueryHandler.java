package com.framework.services;

import com.framework.data.repositories.IRepository;

public abstract class QueryHandler<IN extends Query, OUT> implements IQueryHandler<IN, OUT> {

    protected IRepository<OUT> repository;
}
