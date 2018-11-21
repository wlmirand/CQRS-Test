package com.framework.cache.queries;

import com.framework.domain.core.filters.Filter;
import com.framework.services.Query;

public class GetByFilterQuery<T> extends Query<T> {

    public GetByFilterQuery(Filter<T> filter) {
        super(filter);
    }
}
