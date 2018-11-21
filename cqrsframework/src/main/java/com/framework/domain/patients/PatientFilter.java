package com.framework.domain.patients;

import com.framework.domain.core.filters.Filter;

public class PatientFilter extends Filter<Patient> {

    int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
