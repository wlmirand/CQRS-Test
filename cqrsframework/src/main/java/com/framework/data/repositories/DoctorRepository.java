package com.framework.data.repositories;

import android.util.Log;

import com.framework.domain.doctors.Doctor;
import com.framework.domain.core.filters.Filter;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepository extends BaseRepository<Doctor> {

    public void save(Doctor item) {
        Log.d("CRQS-FW", "Saving a Doctor");
    }

    @Override
    public List<Doctor> find(Filter<Doctor> filter) {
        List<Doctor> result = new ArrayList<>();
        Doctor doctor = new Doctor();
        result.add(doctor);
        return result;
    }

}
