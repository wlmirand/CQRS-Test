package com.framework.cache.queryhandlers;

import com.framework.data.repositories.IRepository;
import com.framework.services.Query;
import com.framework.services.RepositoryQueryHandler;

import java.util.List;

public class GetByFilterQueryHandler<QUERY extends Query<TYPE>, TYPE> extends RepositoryQueryHandler<QUERY, TYPE> {

    public GetByFilterQueryHandler(IRepository<TYPE> repository) {
        super(repository);
    }

    @Override
    public List<TYPE> handle(QUERY query) {
        return repository.find(query.getFilter());
    }
}
