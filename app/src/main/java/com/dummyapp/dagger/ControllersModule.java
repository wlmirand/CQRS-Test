package com.dummyapp.dagger;

import com.dummyapp.controllers.BaseController;

import dagger.Module;
import dagger.Provides;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.dependencies.dagger.TurbuPlusFwkComponent;

@Module
public class ControllersModule {

    @Provides
    BaseController provideBaseController(TurbuPlusFwkComponent injector) {
        return new BaseController(injector);
    }
}
