package com.dummyapp.dagger;

import com.dummyapp.activities.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;


/***
 * This interface provides the inject method used to initialize the components in the
 * specified user interface element
 */
@Singleton
@Component(modules = { DoctorModule.class })
public interface IBaseComponent {

    /***
     * Injects the component in the base activity context required
     * to enable the module injection functionality
     *
     * @param activity base activity instance
     */
    void inject(BaseActivity activity);
}
