package com.framework.services;

import com.framework.domain.core.filters.Filter;

public abstract class Query<T> implements IQuery {

    private Filter<T> filter;

    protected Query(Filter<T> filter) {
        this.filter = filter;
    }

    public Filter<T> getFilter() {
        return filter;
    }
}
