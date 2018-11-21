package com.dummyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dummyapp.dagger.DaggerMyComponent;
import com.framework.cache.commandhandlers.PushCommandHandler;
import com.framework.cache.commandhandlers.RemoveCommandHandler;
import com.framework.cache.commands.PushCommand;
import com.framework.cache.commands.RemoveCommand;
import com.framework.cache.services.CacheService;
import com.framework.data.repositories.DoctorRepository;
import com.framework.domain.Doctor;
import com.framework.domain.patients.Patient;
import com.framework.services.Command;
import com.framework.services.ICommandHandler;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inicialmente precisamos criar os maps
                DoctorRepository doctorRepository = DaggerMyComponent.builder().build().inject();

                Map<Class, ICommandHandler<Command<Doctor>>> mapaComandos = new HashMap<>();

                mapaComandos.put(PushCommand.class, new PushCommandHandler<>(doctorRepository));
                mapaComandos.put(RemoveCommand.class, new RemoveCommandHandler<>(doctorRepository));

                CacheService<Doctor> doctorCacheService = new CacheService<>(mapaComandos, null);
                PushCommand<Doctor> pushDoctorCommand = new PushCommand<>(new Doctor());
                doctorCacheService.processCommand(pushDoctorCommand);

                /*
                PatientFilter filter = new PatientFilter();
                GetByFilterQuery query = new GetByFilterQuery(filter);
                List<Doctor> result = doctorCacheService.processQuery(query);
                */


            }
        });
    }
}
