package com.example.findmymaster.EventSystem.Events;

import com.example.findmymaster.EventSystem.EventBase;

public class LoginEvent extends EventBase {

    private String userName;
    private String password;

    public LoginEvent() {
        super(EventType.LOGIN_EVENT);
    }

    @Override
    public String toString() {
        return userName + " " + password;
    }
}
