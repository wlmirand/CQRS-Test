package com.framework.cache.services;

import com.framework.services.Command;
import com.framework.services.ICommandHandler;
import com.framework.services.IQueryHandler;
import com.framework.services.Query;
import com.framework.services.Service;

import java.util.Map;

/**
 * O CacheService ira processar Commands e Queries
 * Então ele precisa passar os Commands para os respectivos Handlers
 */
public class CacheService<T> extends Service<T> {

    public CacheService(
            Map<Class, ICommandHandler<Command<T>>> mapCommands,
            Map<Class, IQueryHandler<Query<T>, T>> mapQueries) {
        super(mapCommands, mapQueries);
    }
}
