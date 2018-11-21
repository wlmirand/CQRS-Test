package com.dummyapp.dagger.modules;

import com.framework.data.repositories.DoctorRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    public DoctorRepository provideDoctorRepository() {
        return new DoctorRepository();
    }
}
