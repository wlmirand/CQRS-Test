package com.framework.data.repositories;

import com.framework.domain.core.filters.Filter;

import java.util.List;

public interface IRepository<T> {

    void save(T entity);
    List<T> find(Filter<T> filter);

}
