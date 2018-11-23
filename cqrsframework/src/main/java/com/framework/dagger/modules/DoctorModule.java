package com.framework.dagger.modules;

import com.framework.data.repositories.DoctorRepository;
import com.framework.data.repositories.IRepository;
import com.framework.domain.doctors.Doctor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/***
 * This class is a specific module which aims to provide an example of how the base module
 * should be applied and used with the Doctor entity
 */
@Module
public class DoctorModule extends BaseModule<Doctor> {

    /***
     * Provides the repository related with the Doctor entity
     *
     * @return DoctorRepository doctor repository instance
     */
    @Provides
    @Singleton
    public IRepository<Doctor> provideDoctorRepository() {
        return new DoctorRepository();
    }
}
