package com.example.findmymaster.LayerSystem;
import com.example.findmymaster.EventSystem.EventBase;

import java.util.List;
import java.util.ArrayList;

public class LayerStack {

    List<LayerBase> layerStack;

    public LayerStack()
    {
        layerStack = new ArrayList<LayerBase>();
    }

    public void insertLayer(LayerBase layer)
    {
        layerStack.add(layer);
        layer.onAttach();
    }

    public void processEvent(EventBase event)
    {
        for (LayerBase layer : layerStack)
        {
            if(!event.isHandled()) break;
            layer.processEvent(event);
        }
    }
}
