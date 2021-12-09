package com.example.findmymaster.EventSystem.Events;

import com.example.findmymaster.EventSystem.EventBase;

public class ChangeEmailEvent extends EventBase {
    String newEmail;

    public ChangeEmailEvent(String newEmail)
    {
        super(EventType.CHANGE_EMAIL_EVENT);
        this.newEmail = newEmail;
    }

    public String getNewEmail()
    {
        return this.newEmail;
    }

    @Override
    public String toString() {
        return null;
    }
}
