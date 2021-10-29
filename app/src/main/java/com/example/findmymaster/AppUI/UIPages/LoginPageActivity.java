package com.example.findmymaster.AppUI.UIPages;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

import java.util.List;


public class LoginPageActivity extends UIBase {

    //a list of listenable actors
    private List<android.widget.TextView> actors;

    private UIBase registrationPage;
    private UIBase mainPage;

    public LoginPageActivity(EventDispatcher dispatcher)
    {

        //Setting the event dispatcher reference
        super(dispatcher);

        //Creating actors
        //Username EditText
        final EditText userNameField = findViewById(R.id.LoginPage_usernameField);

        //........

        actors.add(userNameField);

        //Password EditText
        final EditText passwordField = findViewById(R.id.LoginPage_loginPasswordField);

        //........

        actors.add(passwordField);

        //Remember me Checkbox
        final CheckBox checkBox = findViewById(R.id.LoginPage_rememberMeCheckbox);

        //........

        actors.add(checkBox);

        //Login button
        final Button loginButton = findViewById(R.id.LoginPage_loginButton);

        //........

        actors.add(loginButton);

        //Forgot Password Link
        final TextView forgotPasswordLink = findViewById(R.id.LoginPage_forgotPasswordLink);

        //........

        actors.add(forgotPasswordLink);

        //Sign up link
        final TextView signUpLink = findViewById(R.id.LoginPage_signUpLink);

        //........

        actors.add(signUpLink);

    }
}
