package com.example.findmymaster.EventSystem.Events;

import com.example.findmymaster.EventSystem.EventBase;

public class RegisterEvent extends EventBase {

    private String email;
    private String password;

    public RegisterEvent(String email, String password)
    {
        super(EventType.REGISTRATION_EVENT);

        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Registration Event: " + email + " " + password;
    }
}
