package com.example.findmymaster.EventSystem.Events;

import com.example.findmymaster.EventSystem.EventBase;

public class LoginEvent extends EventBase {

    private String userName;
    private String password;

    public LoginEvent(String userName, String password)
    {
        super(EventType.LOGIN_EVENT);

        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return userName + " " + password;
    }

    public String getUserName()
    {
        return  userName;
    }

    public String getPassword()
    {
        return password;
    }
}
