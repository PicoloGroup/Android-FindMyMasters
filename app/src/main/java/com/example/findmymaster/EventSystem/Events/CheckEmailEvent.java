package com.example.findmymaster.EventSystem.Events;

public class CheckEmailEvent {
    String email;

    public CheckEmailEvent(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
}
