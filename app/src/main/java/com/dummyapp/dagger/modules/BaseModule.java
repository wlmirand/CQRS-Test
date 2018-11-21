package com.dummyapp.dagger.modules;

import com.framework.cache.commandhandlers.PushCommandHandler;
import com.framework.cache.commandhandlers.RemoveCommandHandler;
import com.framework.cache.commands.PushCommand;
import com.framework.cache.commands.RemoveCommand;
import com.framework.cache.queries.GetByFilterQuery;
import com.framework.cache.queryhandlers.GetByFilterQueryHandler;
import com.framework.cache.services.CacheService;
import com.framework.data.repositories.IRepository;
import com.framework.services.Command;
import com.framework.services.ICommandHandler;
import com.framework.services.IQueryHandler;
import com.framework.services.Query;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseModule<T> {

    @Provides
    @Singleton
    public CacheService<T> provideCacheService(IRepository<T> repository) {
        Map<Class, ICommandHandler<Command<T>>> mapCommands = new HashMap<>();
        mapCommands.put(PushCommand.class, new PushCommandHandler<>(repository));
        mapCommands.put(RemoveCommand.class, new RemoveCommandHandler<>(repository));

        Map<Class, IQueryHandler<Query<T>, T>> mapQueries = new HashMap<>();
        mapQueries.put(GetByFilterQuery.class, new GetByFilterQueryHandler<>(repository));

        return new CacheService<>(mapCommands, mapQueries);
    }
}
