package com.example.findmymaster.EventSystem.Events;

public class UpdateUserEvent {
    String firstName;
    String lastName;
    String image;

    public UpdateUserEvent(String firstName,
                           String lastName,
                           String image)
    {
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
}
