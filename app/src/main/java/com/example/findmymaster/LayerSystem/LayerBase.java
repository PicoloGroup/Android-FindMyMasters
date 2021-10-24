package com.example.findmymaster.LayerSystem;

import com.example.findmymaster.EventSystem.EventBase;

public abstract class LayerBase {

    public LayerBase()
    {
    }

    public abstract void processEvent(EventBase event);
}
