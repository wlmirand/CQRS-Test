package com.dummyapp.dagger.modules;

import com.framework.cache.commandhandlers.PushCommandHandler;
import com.framework.cache.commandhandlers.RemoveCommandHandler;
import com.framework.cache.commands.PushCommand;
import com.framework.cache.commands.RemoveCommand;
import com.framework.cache.queries.GetByFilterQuery;
import com.framework.cache.queryhandlers.GetByFilterQueryHandler;
import com.framework.cache.services.CacheService;
import com.framework.data.repositories.DoctorRepository;
import com.framework.domain.doctors.Doctor;
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
public class MainActivityModule {
    @Provides
    @Singleton
    public DoctorRepository provideDoctorRepository() {
        return new DoctorRepository();
    }

    @Provides
    @Singleton
    public CacheService<Doctor> provideCacheService(DoctorRepository doctorRepository) {
        Map<Class, ICommandHandler<Command<Doctor>>> mapCommands = new HashMap<>();
        mapCommands.put(PushCommand.class, new PushCommandHandler<>(doctorRepository));
        mapCommands.put(RemoveCommand.class, new RemoveCommandHandler<>(doctorRepository));

        Map<Class, IQueryHandler<Query<Doctor>, Doctor>> mapQueries = new HashMap<>();
        mapQueries.put(GetByFilterQuery.class, new GetByFilterQueryHandler<>(doctorRepository));

        return new CacheService<>(mapCommands, mapQueries);
    }
}
