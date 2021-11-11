package com.example.findmymaster.ObserverSystem;

import com.example.findmymaster.LayerSystem.LayerBase;

import java.util.ArrayList;
import java.util.List;

public class ObserverStack {
    List<ObserverBase> observerStack;

    public ObserverStack()
    {
        observerStack = new ArrayList<ObserverBase>();
    }

    public void insertObserver(ObserverBase observer)
    {
        observerStack.add(observer);
        observer.onAttach();
    }

    public void notifyObservers(ObserverBase.ObserverType type)
    {
        for (ObserverBase observer : observerStack)
        {
            if(type == observer.getObserverType())
            {
                observer.update();
                break;
            }
        }
    }
}
