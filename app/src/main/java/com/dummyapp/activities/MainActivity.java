package com.dummyapp.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dummyapp.R;
import com.dummyapp.applications.BaseApplication;
import com.framework.cache.commands.PushCommand;
import com.framework.cache.queries.GetByFilterQuery;
import com.framework.domain.doctors.Doctor;
import com.framework.domain.doctors.DoctorFilter;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) this.getApplication()).getBaseComponent().inject(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inicialmente precisamos criar os maps
                PushCommand<Doctor> pushDoctorCommand = new PushCommand<>(new Doctor());
                MainActivity.this.doctorCacheService.processCommand(pushDoctorCommand);

                //Criamos e enviamos o Comando de Query
                DoctorFilter filter = new DoctorFilter();
                GetByFilterQuery<Doctor> query = new GetByFilterQuery<>(filter);
                List<Doctor> result = MainActivity.this.doctorCacheService.processQuery(query);

                for (Doctor doctor : result) {
                    Log.d("CQRS-App", doctor.getName());
                }

            }
        });
    }
}
