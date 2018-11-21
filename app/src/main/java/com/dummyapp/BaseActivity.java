package com.dummyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framework.data.repositories.DoctorRepository;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Since we might need this on several Activities,
     * we may declare all injections in a BaseActivity and haver all others inherit from this
     * So Dagger may correctly Inject the dependencies for all Activities
     */
    @Inject
    public DoctorRepository doctorRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
