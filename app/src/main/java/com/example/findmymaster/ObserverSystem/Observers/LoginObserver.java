package com.example.findmymaster.ObserverSystem.Observers;

import com.example.findmymaster.AppDomain.AppDomain;
import com.example.findmymaster.AppUI.UIPages.LoginPageActivity;
import com.example.findmymaster.ObserverSystem.ObserverBase;

public class LoginObserver extends ObserverBase {

    private static LoginPageActivity loginPage = null;


    public LoginObserver()
    {
        super(ObserverType.LOGIN_OBSERVER);
    }

    @Override
    public void update()
    {
        if(loginPage != null)
        {

        }
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDetach() {

    }

    public static void SetLoginPageReference(LoginPageActivity reference)
    {
        loginPage = reference;
    }

    public static void ResetLoginPageReference()
    {
        loginPage = null;
    }
}
