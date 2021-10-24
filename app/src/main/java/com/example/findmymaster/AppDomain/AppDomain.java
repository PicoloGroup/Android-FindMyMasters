package com.example.findmymaster.AppDomain;

import com.example.findmymaster.EventSystem.EventBase;
import com.example.findmymaster.LayerSystem.LayerStack;

public class AppDomain {

    private static AppDomain instance = null;
    LayerStack layerStack;

    private AppDomain()
    {
    }

    public static AppDomain getInstance()
    {
        if(instance == null)
        {
            instance = new AppDomain();
        }

        return instance;
    }

    public void processEvent(EventBase event)
    {
        layerStack.processEvent(event);
    }
}
