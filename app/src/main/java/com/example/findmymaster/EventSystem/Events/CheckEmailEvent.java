package com.example.findmymaster.EventSystem.Events;

import com.example.findmymaster.EventSystem.EventBase;

public class CheckEmailEvent extends EventBase {
    String email;

    public CheckEmailEvent(String email)
    {
        super(EventType.CHECK_EMAIL_EVENT);
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    @Override
    public String toString() {
        return null;
    }
}
