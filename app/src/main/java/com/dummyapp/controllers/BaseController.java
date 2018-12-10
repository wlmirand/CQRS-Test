package com.dummyapp.controllers;

import java.util.ArrayList;

import javax.inject.Inject;

import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.commandhandlers.CommandBus;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.dependencies.dagger.TurbuPlusFwkComponent;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.exceptions.TurbuPlusFwkException;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.core.queryhandlers.QueryBus;
import three.appbase.turbuplus.astrazeneca.com.turbuplusfwk.smartchatlog.commands.SmartChatLogDeleteCommand;

public class BaseController {

    private CommandBus commandBus;

    private QueryBus queryBus;

    @Inject
    public BaseController(TurbuPlusFwkComponent injector) {
        this.commandBus = injector.getCommandBus();
        this.queryBus = injector.getQueryBus();
    }

    public void coisas() {
        SmartChatLogDeleteCommand deleteCommand = new SmartChatLogDeleteCommand(new ArrayList<>());
        try {
            this.commandBus.dispatch(deleteCommand);
        } catch (TurbuPlusFwkException e) {
            e.printStackTrace();
        }
    }


}
