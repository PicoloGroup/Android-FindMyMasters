package com.example.findmymaster.EventSystem.Events;

import com.example.findmymaster.EventSystem.EventBase;

public class LoginEvent extends EventBase {

    private String email;
    private String password;

    public LoginEvent(String userName, String password)
    {
        super(EventType.LOGIN_EVENT);

        this.email = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login Event: " + email + " " + password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}
