package com.dummyapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dummyapp.applications.BaseApplication;
import com.dummyapp.controllers.BaseController;
import com.dummyapp.dagger.ApplicationComponent;
import com.dummyapp.dagger.DaggerApplicationComponent;

import javax.inject.Inject;

import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.commandhandlers.CommandBus;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.dependencies.dagger.TurbuPlusFwkComponent;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.queryhandlers.QueryBus;

/***
 * This class aims to be the base activity which will be inherited by each activity in the project and
 * provide the common methods which should be consumed by each of the available activities
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ApplicationComponent injector;

    @Inject
    public BaseController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injector = DaggerApplicationComponent.create();
        this.injector.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.injector = null;
    }
}
