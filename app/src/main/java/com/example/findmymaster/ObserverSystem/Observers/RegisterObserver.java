package com.example.findmymaster.ObserverSystem.Observers;

import com.example.findmymaster.AppUI.UIPages.RegistrationPageActivity;
import com.example.findmymaster.ObserverSystem.ObserverBase;

public class RegisterObserver extends ObserverBase {

    private static RegistrationPageActivity registrationPage = null;

    public RegisterObserver() {
        super(ObserverType.REGISTARTION_OBSERVER);
    }

    @Override
    public void update() {
        if(registrationPage != null)
        {

        }
    }

    @Override
    public void onAttach() {
    }

    @Override
    public void onDetach() {

    }

    public static void setRegistrationPageReference(RegistrationPageActivity reference)
    {
        registrationPage = reference;
    }

    public static void resetRegistrationPageReference()
    {
        registrationPage = null;
    }
}
