package com.example.findmymaster.ObserverSystem.Observers;

import com.example.findmymaster.AppDomain.AppDomain;
import com.example.findmymaster.AppUI.UIPages.LoginPageActivity;
import com.example.findmymaster.ObserverSystem.ObserverBase;

public class LoginObserver extends ObserverBase {

    private static LoginPageActivity loginPage = null;

    private AppDomain.LoginState loginState;


    public LoginObserver()
    {
        super(ObserverType.LOGIN_OBSERVER);
        loginState = AppDomain.getInstance().getLoginState();
    }

    @Override
    public void update()
    {
        if(loginPage != null)
        {
            if(loginState.getLoginState() == true)
            {
                //Call success method on the login page
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

    public static void activateObserver(LoginPageActivity reference)
    {
        loginPage = reference;
    }

    public static void resetObserver()
    {
        loginPage = null;
    }


}
