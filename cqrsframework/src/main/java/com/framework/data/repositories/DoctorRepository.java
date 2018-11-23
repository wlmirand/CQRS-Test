package com.framework.data.repositories;

import android.util.Log;

import com.framework.domain.core.filters.Filter;
import com.framework.domain.doctors.Doctor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;

public class DoctorRepository extends BaseRepository<Doctor> {

    public long timestamp;

    public DoctorRepository() {
        timestamp = new Date().getTime();
    }

    public void save(Doctor item) {
        Log.d("CRQS-FW", "Saving a Doctor");

//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//
//            }
//        });
    }

    @Override
    public List<Doctor> find(Filter<Doctor> filter) {
        List<Doctor> result = new ArrayList<>();
        Doctor doctor = new Doctor();
        result.add(doctor);
        return result;
    }

}
