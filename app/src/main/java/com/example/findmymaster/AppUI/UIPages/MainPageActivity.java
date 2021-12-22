package com.example.findmymaster.AppUI.UIPages;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class MainPageActivity extends UIBase {


    public MainPageActivity() {
        super(EventDispatcher.getInstance());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //hooks


    }
}