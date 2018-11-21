package com.dummyapp;

import com.framework.data.repositories.DoctorRepository;

import javax.inject.Inject;

public class Teste {

    private DoctorRepository repo;

    @Inject
    public Teste(DoctorRepository repo) {
        this.repo = repo;
    }

}
