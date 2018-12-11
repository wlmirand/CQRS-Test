package com.dummyapp.applications;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/***
 * This class was created to in order to provide a single point of access to all the components
 * used for injection purposes and to assure that all modules are initialized only once in the entire application
 * lifespan
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //CHANGE SCHEMA VERSION AND MIGRATION IF FIELDS OR NEW TABLES ARE ADDED TO DB
        Realm.init(this.getApplicationContext());

        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(5)
                .build();

        Realm realm = Realm.getInstance(config);
        Realm.setDefaultConfiguration(config);

        realm.close();
    }
}
