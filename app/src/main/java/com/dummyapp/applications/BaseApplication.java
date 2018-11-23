package com.dummyapp.applications;

import android.app.Application;

import com.dummyapp.dagger.DaggerIBaseComponent;
import com.dummyapp.dagger.IBaseComponent;
import com.framework.dagger.modules.DoctorModule;

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
        baseComponent = DaggerIBaseComponent.builder().build();
    }

    /***
     * Retrieves the BaseComponent initialized
     * during the application startup
     *
     * @return baseComponent required to enable the module injection in the respective UI
     * elements
     */
    public IBaseComponent getBaseComponent() {
        return this.baseComponent;
    }
}
