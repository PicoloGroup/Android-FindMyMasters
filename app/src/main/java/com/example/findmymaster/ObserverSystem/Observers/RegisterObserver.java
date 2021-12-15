package com.example.findmymaster.ObserverSystem.Observers;

import com.example.findmymaster.AppDomain.AppDomain;
import com.example.findmymaster.AppUI.UIPages.RegistrationPageActivity;
import com.example.findmymaster.ObserverSystem.ObserverBase;

public class RegisterObserver extends ObserverBase {

    private static RegistrationPageActivity registrationPage = null;
    private AppDomain.RegisterState registerState;

    public RegisterObserver() {
        super(ObserverType.REGISTARTION_OBSERVER);

        registerState = AppDomain.getInstance().getRegisterState();
    }

    @Override
    public void update() {
        if(registrationPage != null)
        {
            if(registerState.getRegisterState() == true)
            {
                //Call success method on the registration page
            }
            else
            {
               //switch depending on the error code
            }
        }
    }

    @Override
    public void onAttach() {
    }

    @Override
    public void onDetach() {

    }

    public static void activateObserver(RegistrationPageActivity reference)
    {
        registrationPage = reference;
    }

    public static void resetObserver()
    {
        registrationPage = null;
    }
}
