package com.example.findmymaster.AppUI.UIPages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;
import com.example.findmymaster.RegistrationPageActivity;

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

        final CheckBox rememberMeCheckBox = findViewById(R.id.LoginPage_rememberMeCheckbox);


        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = preferences.getString("RememberMeCheckBox","");
        if (checkbox.equals("true")) {
            Intent intent = new Intent(LoginPageActivity.this, RegistrationPageActivity.class);
            startActivity(intent);
        }
        else if (checkbox.equals("false")){
            Toast.makeText(this, "Please Sign in", Toast.LENGTH_SHORT).show();
    }


        rememberMeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("RememberMeCheckBox","true");
                    editor.apply();

                }
                else if (!buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("RememberMeCheckBox","false");
                    editor.apply();
                }
            // Must be before OnCreate
            }
        });


        //........

        actors.add(rememberMeCheckBox);

        //Login button
        final Button loginButton = findViewById(R.id.LoginPage_loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPageActivity.this, RegistrationPageActivity.class);
                startActivity(intent);
            }
        });



        //........

        actors.add(loginButton);

        //Forgot Password Link
        final TextView forgotPasswordLink = findViewById(R.id.LoginPage_forgotPasswordLink);

        //........

        actors.add(forgotPasswordLink);

        //Sign up link
        final TextView signUpLink = findViewById(R.id.LoginPage_signUpLink);

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPageActivity.this, RegistrationPageActivity.class);
                startActivity(intent);
            }
        });

        //........

        actors.add(signUpLink);

    }

}
