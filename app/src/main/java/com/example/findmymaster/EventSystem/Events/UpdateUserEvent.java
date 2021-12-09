package com.example.findmymaster.EventSystem.Events;

import com.example.findmymaster.EventSystem.EventBase;

public class UpdateUserEvent extends EventBase {
    String firstName;
    String lastName;
    String image;

    public UpdateUserEvent(String firstName,
                           String lastName,
                           String image)
    {
        super(EventType.UPDATE_USER_EVENT);
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return null;
    }
}
