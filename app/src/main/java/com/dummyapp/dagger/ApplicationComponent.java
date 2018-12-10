package com.dummyapp.dagger;

import com.dummyapp.activities.BaseActivity;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class, TurbuPlusFwkModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity activity);
}

