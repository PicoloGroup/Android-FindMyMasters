package com.example.findmymaster.LayerSystem;

import com.example.findmymaster.EventSystem.EventBase;

public interface LayerBase {

    //Event processing method
    void processEvent(EventBase event);

    //Methods called respectively when attached or detached to a LayerStack object.
    void onAttach();

    void onDetach();
}
