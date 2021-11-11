package com.example.findmymaster.AppDomain;

import android.app.Service;
import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.example.findmymaster.AppDomain.FastNetworkRequestHandler.FastNetworkRequestHandler;
import com.example.findmymaster.EventSystem.EventBase;
import com.example.findmymaster.LayerSystem.LayerStack;
import com.example.findmymaster.LayerSystem.Layers.WebAPILayer;
import com.example.findmymaster.ObserverSystem.ObserverBase;
import com.example.findmymaster.ObserverSystem.ObserverStack;
import com.example.findmymaster.ObserverSystem.Observers.LoginObserver;
import com.example.findmymaster.ObserverSystem.Observers.RegisterObserver;

public class AppDomain{

    private class LoginState{
        private boolean loginSuccessful = false;

        public boolean isLoginSuccessful() { return loginSuccessful;}
        public void setLoginState(boolean state) {this.loginSuccessful = state;}
    }

    private class RegisterState{
        private boolean registerSuccessful = false;

        private  boolean isRegisterSuccessful() { return registerSuccessful; }
        public void setRegisterState(boolean state) {this.registerSuccessful = state;}
    }

    private static AppDomain instance = null;
    private LayerStack layerStack;
    private ObserverStack observerStack;
    private WebAPIHandler webAPIHandler;

    private LoginState loginstate;
    private RegisterState registerState;

    private AppDomain()
    {
        loginstate = new LoginState();
        registerState = new RegisterState();
    }

    public static synchronized AppDomain getInstance()
    {
        if(instance == null)
        {
            instance = new AppDomain();
        }

        return instance;
    }

    public void initialize(Context context)
    {
        webAPIHandler = new FastNetworkRequestHandler("local:3000/", context);

        layerStack = new LayerStack();
        layerStack.insertLayer(new WebAPILayer(webAPIHandler));

        observerStack = new ObserverStack();
        observerStack.insertObserver(new LoginObserver());
        observerStack.insertObserver(new RegisterObserver());
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

    public void handleLoginResult(boolean result)
    {
        loginstate.setLoginState(result);
        notifyObservers(ObserverBase.ObserverType.LOGIN_OBSERVER);

    }

    public void handleregisterResult(boolean result)
    {
        registerState.setRegisterState(result);
        notifyObservers(ObserverBase.ObserverType.REGISTARTION_OBSERVER);

    }



}
