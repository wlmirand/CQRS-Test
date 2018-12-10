package com.dummyapp.activities;

import android.os.Bundle;
import android.view.View;

import com.dummyapp.R;
import com.dummyapp.applications.BaseApplication;

import java.util.ArrayList;

import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.commandhandlers.CommandBus;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.exceptions.TurbuPlusFwkException;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.smartchatlog.commands.SmartChatLogDeleteCommand;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.controller.coisas();
            }
        });
    }
}
