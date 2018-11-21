package com.framework.data.repositories;

import android.util.Log;

import com.framework.domain.Doctor;
import com.framework.domain.core.filters.Filter;

import java.util.List;

public class DoctorRepository implements IRepository<Doctor> {

    public void save(Doctor item) {
        Log.d("CRQS-FW", "Saving a Doctor");
    }

    @Override
    public List<Doctor> find(Filter<Doctor> filter) {
        return null;
    }

}
