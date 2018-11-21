package com.dummyapp.dagger.modules;

import com.framework.data.repositories.DoctorRepository;
import com.framework.data.repositories.IRepository;
import com.framework.domain.doctors.Doctor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DoctorModule extends BaseModule<Doctor> {

    @Provides
    @Singleton
    public IRepository<Doctor> provideDoctorRepository() {
        return new DoctorRepository();
    }
}
