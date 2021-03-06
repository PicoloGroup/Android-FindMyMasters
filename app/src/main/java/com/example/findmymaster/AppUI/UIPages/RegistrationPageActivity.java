package com.example.findmymaster.AppUI.UIPages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.EventSystem.Events.RegisterEvent;
import com.example.findmymaster.ObserverSystem.Observers.RegisterObserver;
import com.example.findmymaster.R;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPageActivity extends UIBase {

    private List<TextView> actors;

    private UIBase registrationPage;
    private UIBase mainPage;

    public RegistrationPageActivity() {
        super(EventDispatcher.getInstance());

        actors = new ArrayList<android.widget.TextView>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RegisterObserver.activateObserver(this);

        setContentView(R.layout.activity_registration_page);

        //Creating Actors
        //Username EditText
        final EditText userNameField = findViewById(R.id.RegistrationPage_usernameField);

        //........

        actors.add(userNameField);

        //Email EditText
        final EditText emailField = findViewById((R.id.RegistrationPage_EmailField));

        //........

        actors.add(emailField);

        //Password EditText
        final EditText passwordField = findViewById(R.id.RegistrationPage_passwordField);

        //........

        actors.add(passwordField);

        //Confirm Password EditText
        final EditText confirmPasswordField = findViewById(R.id.RegistrationPage_confirmPasswordField);

        //........

        actors.add(confirmPasswordField);

        //Register Button
        final Button registerButton = findViewById(R.id.RegistrationPage_registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText emailField = findViewById(R.id.RegistrationPage_EmailField);
                EditText passwordField = findViewById(R.id.RegistrationPage_passwordField);

                EventDispatcher.getInstance().dispatchEvent(
                        new RegisterEvent(
                                emailField.getText().toString(),
                                passwordField.getText().toString()
                                )
                        );
                switchIntent(RegistrationPageActivity.this,LoginPageActivity.class);
            }
        });

        actors.add(registerButton);

        //Sign in Link TextView
        final TextView signInLink = findViewById(R.id.RegistrationPage_signInLink);

        signInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIntent(RegistrationPageActivity.this, LoginPageActivity.class);
            }

        });

        //........

        actors.add(signInLink);

    }

    public void onDestroy() {

        super.onDestroy();

        RegisterObserver.resetObserver();
    }

}