package com.example.findmymaster.ObserverSystem;

public abstract class ObserverBase {

    public enum ObserverType
    {
        LOGIN_OBSERVER,
        REGISTARTION_OBSERVER
    }

    private ObserverType observerType;

    protected ObserverBase(ObserverType type)
    {
        observerType = type;
    }

    public ObserverType getObserverType()
    {
        return this.observerType;
    }

    public abstract void update();

    public abstract void onAttach();
    public abstract void onDetach();
}
