package com.example.findmymaster.AppDomain;

import android.content.Context;

import com.example.findmymaster.AppDomain.APIClasses.Token;
import com.example.findmymaster.AppDomain.FastNetworkRequestHandler.FastNetworkRequestHandler;
import com.example.findmymaster.EventSystem.EventBase;
import com.example.findmymaster.LayerSystem.LayerStack;
import com.example.findmymaster.LayerSystem.Layers.WebAPILayer;
import com.example.findmymaster.ObserverSystem.ObserverBase;
import com.example.findmymaster.ObserverSystem.ObserverStack;
import com.example.findmymaster.ObserverSystem.Observers.LoginObserver;
import com.example.findmymaster.ObserverSystem.Observers.RegisterObserver;

public class AppDomain{

    public class ErrorState
    {
        private Error lastError = null;

        public void logError(Error error) {this.lastError = error;}
        public Error getCurrentError() {return this.lastError;}
    }

    public class LoginState{
        private boolean loginSuccessful = false;

        public boolean getLoginState() { return loginSuccessful;}
        public void setLoginState(boolean state) {this.loginSuccessful = state;}
    }

    public class RegisterState{
        private boolean registerSuccessful = false;

        public boolean getRegisterState() { return registerSuccessful; }
        public void setRegisterState(boolean state) {this.registerSuccessful = state;}
    }

    private boolean initFlag = true;

    private static AppDomain instance = null;
    private LayerStack layerStack;
    private ObserverStack observerStack;
    private WebAPIHandler webAPIHandler;

    private ErrorState errorState;
    private LoginState loginstate;
    private RegisterState registerState;

    private AppDomain()
    {
    }

    public void initialize(Context context)
    {
        if (initFlag) {
            loginstate = new LoginState();
            registerState = new RegisterState();

            webAPIHandler = new FastNetworkRequestHandler("http://findmymasters-api.eu-central-1.elasticbeanstalk.com/", context);

            layerStack = new LayerStack();
            layerStack.insertLayer(new WebAPILayer(webAPIHandler));

            observerStack = new ObserverStack();
            observerStack.insertObserver(new LoginObserver());
            observerStack.insertObserver(new RegisterObserver());
            initFlag = false;
        }
    }

    public static synchronized AppDomain getInstance()
    {
        if(instance == null)
        {
            instance = new AppDomain();
        }

        return instance;
    }

    //State  reference getters

    public ErrorState getErrorState()
    {
        return  this.errorState;
    }

    public LoginState getLoginState()
    {
        return this.loginstate;
    }

    public RegisterState getRegisterState()
    {
        return this.registerState;
    }

    public Error getCurrentError()
    {
        return errorState.getCurrentError();
    }

    public void processEvent(EventBase event)
    {
        layerStack.processEvent(event);
    }

    //Domain change handling functions

    private void notifyObservers(ObserverBase.ObserverType type)
    {
        observerStack.notifyObservers(ObserverBase.ObserverType.LOGIN_OBSERVER);
    }

    public void handleLoginResult(Error error)
    {
        if(error == null) {
            loginstate.setLoginState(true);
        } else {
            errorState.logError(error);
            loginstate.setLoginState(false);
        }
        notifyObservers(ObserverBase.ObserverType.LOGIN_OBSERVER);

    }

    public void handleRegisterResult(Error error)
    {
        if(error == null) {
            registerState.setRegisterState(true);
        } else {
            errorState.logError(error);
            registerState.setRegisterState(false);
        }
        notifyObservers(ObserverBase.ObserverType.REGISTARTION_OBSERVER);
    }
}
