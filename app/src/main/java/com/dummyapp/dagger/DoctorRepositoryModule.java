package com.dummyapp.dagger;

import com.framework.data.repositories.DoctorRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DoctorRepositoryModule {

    @Provides
    public DoctorRepository provideDoctorRepository() {
        return new DoctorRepository();
    }
}
