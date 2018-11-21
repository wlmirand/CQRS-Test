package com.dummyapp.applications;

import android.app.Application;

import com.dummyapp.dagger.components.DaggerIBaseComponent;
import com.dummyapp.dagger.components.IBaseComponent;
import com.dummyapp.dagger.modules.MainActivityModule;

/***
 * This class was created to in order to provide a single point of access to all the components
 * used for injection purposes and to assure that all modules are initialized only once in the entire application
 * lifespan
 */
public class BaseApplication extends Application {

    // Base component which holds the modules used for injection purposes in the main activity
    private IBaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.baseComponent = DaggerIBaseComponent.builder().mainActivityModule(new MainActivityModule()).build();
    }

    /***
     * Retrieves the BaseComponent initialized
     * during the application startup
     *
     * @return baseComponent
     */
    public IBaseComponent getBaseComponent() {
        return this.baseComponent;
    }
}
