package com.example.findmymaster.AppUI;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.findmymaster.AppUI.UIPages.LoginPageActivity;
import com.example.findmymaster.AppUI.UIPages.RegistrationPageActivity;
import com.example.findmymaster.EventSystem.EventDispatcher;

public abstract class UIBase extends AppCompatActivity {

    EventDispatcher eventDispatcher;

    public UIBase(EventDispatcher dispatcher)
    {
        eventDispatcher = dispatcher;
    }

    public void switchIntent(android.content.Context context, Class<?> target){
        Intent intent = new Intent(context, target);
        startActivity(intent);
    }
}