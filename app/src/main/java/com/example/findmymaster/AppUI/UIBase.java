package com.example.findmymaster.AppUI;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findmymaster.EventSystem.EventDispatcher;

public abstract class UIBase extends AppCompatActivity {

    EventDispatcher eventDispatcher;

    public UIBase(EventDispatcher dispatcher)
    {
        eventDispatcher = dispatcher;
    }
}
