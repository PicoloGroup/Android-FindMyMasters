package com.example.findmymaster.EventSystem;

public abstract class EventBase {

    public enum EventType
    {
        LOGIN_EVENT,
        REGISTRATION_EVENT
    }

    private EventType eventType;
    private boolean isHandled = false;

    public EventBase(EventType type)
    {
        eventType = type;
    }

    public void handle()
    {
        isHandled = false;
    }

    public boolean isHandled()
    {
        return isHandled;
    }

    public EventType getEventType()
    {
        return eventType;
    }

    @Override
    public abstract String toString();
}
