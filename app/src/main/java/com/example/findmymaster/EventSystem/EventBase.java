package com.example.findmymaster.EventSystem;

public abstract class EventBase {

    public enum EventType
    {
        LOGIN_EVENT,
        REGISTRATION_EVENT,
        UPDATE_USER_EVENT,
        CHANGE_EMAIL_EVENT,
        CHANGE_PASSWORD_EVENT,
        CHECK_EMAIL_EVENT
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
