package com.dummyapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dummyapp.applications.BaseApplication;
import com.dummyapp.dagger.DaggerIBaseComponent;
import com.framework.cache.services.CacheService;
import com.framework.domain.doctors.Doctor;

import javax.inject.Inject;

/***
 * This class aims to be the base activity which will be inherited by each activity in the project and
 * provide the common methods which should be consumed by each of the available activities
 */
public abstract class BaseActivity extends AppCompatActivity {


    /**
     * Since we might need this on several Activities,
     * we may declare all injections in a BaseActivity and have all others inherit from this
     * So Dagger may correctly Inject the required dependencies for all the activities.
     */
    @Inject
    public CacheService<Doctor> doctorCacheService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getApplication()).getBaseComponent().inject(this);
    }
}
