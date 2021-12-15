package com.example.findmymaster.EventSystem.Events;

import androidx.annotation.NonNull;

import com.example.findmymaster.EventSystem.EventBase;

public class ChangePasswordEvent extends EventBase {
    String newEmail;

    public ChangePasswordEvent(String newEmail)
    {
        super(EventType.CHANGE_PASSWORD_EVENT);
        this.newEmail = newEmail;
    }

    public String getNewEmail()
    {
        return newEmail;
    }

    @Override
    public String toString() {
        return null;
    }
}
