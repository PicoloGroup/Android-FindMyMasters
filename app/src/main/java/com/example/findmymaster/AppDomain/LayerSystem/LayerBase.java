package com.example.findmymaster.AppDomain.LayerSystem;

import com.example.findmymaster.AppDomain.EventSystem.EventBase;

public abstract class LayerBase {

    public LayerBase()
    {
    }

    public abstract void ProcessEvent(EventBase event);
}
