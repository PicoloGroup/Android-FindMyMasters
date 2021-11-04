package com.example.findmymaster.EventSystem;

import com.example.findmymaster.AppDomain.AppDomain;

public class EventDispatcher {

    private static EventDispatcher instance = null;
    private AppDomain appDomain;

    private EventDispatcher()
    {
        appDomain = AppDomain.getInstance();
    }

    public void setDomainReference(AppDomain domain)
    {
        appDomain = domain;
    }

    public static EventDispatcher getInstance()
    {
        if(instance == null)
        {
            instance = new EventDispatcher();
        }

        return instance;
    }

    public void dispatchEvent(EventBase event)
    {
        appDomain.processEvent(event);
    }


}
