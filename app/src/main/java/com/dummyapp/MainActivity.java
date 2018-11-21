package com.dummyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dummyapp.applications.BaseApplication;
import com.framework.cache.commandhandlers.PushCommandHandler;
import com.framework.cache.commandhandlers.RemoveCommandHandler;
import com.framework.cache.commands.PushCommand;
import com.framework.cache.commands.RemoveCommand;
import com.framework.cache.services.CacheService;
import com.framework.data.repositories.DoctorRepository;
import com.framework.domain.Doctor;
import com.framework.services.Command;
import com.framework.services.ICommandHandler;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public DoctorRepository doctorRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) this.getApplication()).getBaseComponent().inject(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inicialmente precisamos criar os maps
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
