package com.framework.cache.queryhandlers;

import com.framework.services.Query;
import com.framework.services.QueryHandler;

import java.util.List;

public class GetByFilterQueryHandler<TYPE, QUERY extends Query<TYPE>> extends QueryHandler<QUERY, TYPE> {

    @Override
    public List<TYPE> handle(QUERY query) {
        return repository.find(query.getFilter());
    }
}
