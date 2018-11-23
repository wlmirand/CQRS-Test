package com.dummyapp.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dummyapp.R;
import com.framework.cache.commands.PushCommand;
import com.framework.cache.queries.GetByFilterQuery;
import com.framework.domain.doctors.Doctor;
import com.framework.domain.doctors.DoctorFilter;

import java.util.List;

public class AnotherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
