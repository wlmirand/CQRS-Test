package com.dummyapp.dagger;

import dagger.Module;
import dagger.Provides;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.dependencies.TurbuPlusFwkResolver;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.dependencies.dagger.TurbuPlusFwkComponent;

@Module
public class TurbuPlusFwkModule {

    @Provides
    TurbuPlusFwkComponent providesTurbuPlusFwkComponent() {
        return new TurbuPlusFwkResolver().create();
    }
}
