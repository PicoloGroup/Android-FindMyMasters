package com.example.findmymaster.AppDomain.LayerSystem;
import com.example.findmymaster.AppDomain.EventSystem.EventBase;

import java.util.List;
import java.util.ArrayList;

public class LayerStack {

    List<LayerBase> layerStack;

    public LayerStack()
    {
        layerStack = new ArrayList<LayerBase>();
    }

    public void InsertLayer(LayerBase layer)
    {
        layerStack.add(layer);
    }

    public void ProcessEvent(EventBase event)
    {
        for (LayerBase layer : layerStack)
        {
            if(!event.IsHandled()) break;
            layer.ProcessEvent(event);
        }
    }
}
