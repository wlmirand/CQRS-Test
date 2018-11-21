package com.dummyapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dummyapp.applications.BaseApplication;
import com.framework.cache.commandhandlers.PushCommandHandler;
import com.framework.cache.commandhandlers.RemoveCommandHandler;
import com.framework.cache.commands.PushCommand;
import com.framework.cache.commands.RemoveCommand;
import com.framework.cache.queries.GetByFilterQuery;
import com.framework.cache.queryhandlers.GetByFilterQueryHandler;
import com.framework.cache.services.CacheService;
import com.framework.domain.doctors.Doctor;
import com.framework.domain.doctors.DoctorFilter;
import com.framework.services.Command;
import com.framework.services.ICommandHandler;
import com.framework.services.IQueryHandler;
import com.framework.services.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                Map<Class, ICommandHandler<Command<Doctor>>> mapaComandos = new HashMap<>();
                mapaComandos.put(PushCommand.class, new PushCommandHandler<>(doctorRepository));
                mapaComandos.put(RemoveCommand.class, new RemoveCommandHandler<>(doctorRepository));

                Map<Class, IQueryHandler<Query<Doctor>, Doctor>> mapaQueries = new HashMap<>();
                mapaQueries.put(GetByFilterQuery.class, new GetByFilterQueryHandler<>(doctorRepository));

                //Usamos os maps para criar o servico
                CacheService<Doctor> doctorCacheService = new CacheService<>(mapaComandos, mapaQueries);

                //Criamos e enviamos o Comando de Push
                PushCommand<Doctor> pushDoctorCommand = new PushCommand<>(new Doctor());
                doctorCacheService.processCommand(pushDoctorCommand);

                //Criamos e enviamos o Comando de Query
                DoctorFilter filter = new DoctorFilter();
                GetByFilterQuery<Doctor> query = new GetByFilterQuery<>(filter);
                List<Doctor> result = doctorCacheService.processQuery(query);

                for (Doctor doctor : result) {
                    Log.d("CQRS-App", doctor.getName());
                }

            }
        });
    }
}
