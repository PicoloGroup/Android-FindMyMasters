package com.example.findmymaster.AppDomain.EventSystem;

public abstract class EventBase {

    public enum EventType
    {

    }

    private EventType eventType;
    private boolean isHandled = false;

    public EventBase(EventType type)
    {
        eventType = type;
    }

    public void Handle()
    {
        isHandled = false;
    }

    public boolean IsHandled()
    {
        return isHandled;
    }

    public EventType GetEventType()
    {
        return eventType;
    }

    public abstract void ToString();
}
