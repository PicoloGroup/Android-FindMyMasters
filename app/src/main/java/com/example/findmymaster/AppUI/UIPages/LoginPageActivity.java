package com.example.findmymaster.AppUI.UIPages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findmymaster.AppDomain.AppDomain;
import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.EventSystem.Events.LoginEvent;
import com.example.findmymaster.ObserverSystem.Observers.LoginObserver;
import com.example.findmymaster.R;

import java.util.ArrayList;
import java.util.List;


public class LoginPageActivity extends UIBase {

    //a list of listenable actors
    private List<android.widget.TextView> actors;

    private UIBase registrationPage;
    private UIBase mainPage;


    public LoginPageActivity()
    {
        super(EventDispatcher.getInstance());

        actors = new ArrayList<android.widget.TextView>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //Initializing the domain
        AppDomain.getInstance().initialize(getApplicationContext());

        //Setting observer reference
        LoginObserver.activateObserver(this);

        //Creating actors
        //Username EditText
        final EditText userNameField = findViewById(R.id.LoginPage_usernameField);

        //........

        actors.add(userNameField);

        //Password EditText
        final EditText passwordField = findViewById(R.id.LoginPage_loginPasswordField);

        //........

        actors.add(passwordField);



        //Login button
        final Button loginButton = findViewById(R.id.LoginPage_loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchIntent(LoginPageActivity.this, MainPageActivity.class);

            /*
                EditText emailField = findViewById(R.id.LoginPage_usernameField);
                EditText passwordField = findViewById(R.id.LoginPage_loginPasswordField);

                EventDispatcher.getInstance().dispatchEvent(
                        new LoginEvent(
                                emailField.toString(),
                                passwordField.toString()
                                )
                );

             */
            }
        });

        //........

        actors.add(loginButton);

        //Forgot Password Link TextView
        final TextView forgotPasswordLink = findViewById(R.id.LoginPage_forgotPasswordLink);

        //........

        actors.add(forgotPasswordLink);

        //Sign up link TextView
        final TextView signUpLink = findViewById(R.id.LoginPage_signUpLink);

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIntent(LoginPageActivity.this, RegistrationPageActivity.class);
            }
        });

        //........

        actors.add(signUpLink);

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

        LoginObserver.resetObserver();
    }
}
