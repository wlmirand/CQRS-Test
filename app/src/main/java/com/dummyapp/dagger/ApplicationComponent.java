package com.dummyapp.dagger;

import com.dummyapp.activities.BaseActivity;

import dagger.Component;

@ApplicationScope
@Component(modules = {ControllersModule.class, TurbuPlusFwkModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity activity);
}

