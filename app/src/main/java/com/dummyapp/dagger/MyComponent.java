package com.dummyapp.dagger;

import com.framework.data.repositories.DoctorRepository;

import dagger.Component;

@Component(modules = DoctorRepositoryModule.class)
public interface MyComponent {
    DoctorRepository inject();
}
