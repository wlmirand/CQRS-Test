package com.dummyapp.dagger.components;

import android.app.Activity;

import com.dummyapp.BaseActivity;
import com.dummyapp.MainActivity;
import com.dummyapp.dagger.modules.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;


/***
 * This interface provides the inject method used
 */
@Singleton
@Component(modules = {MainActivityModule.class})
public interface IBaseComponent {
    void inject(BaseActivity activity);
}
