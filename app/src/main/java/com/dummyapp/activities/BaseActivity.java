package com.dummyapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dummyapp.R;

import javax.inject.Inject;

import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.appevent.commands.AppEventPushCommand;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.dispatchers.CommandsDispatcher;

public class MainActivity extends AppCompatActivity {

    @Inject
    CommandsDispatcher commandsDispatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cria um comando a ser enviado para o Dispatcher
                AppEventPushCommand pushCommand = new AppEventPushCommand();

                //Envia o comando
                commandsDispatcher.process(pushCommand);
            }
        });
    }
}
