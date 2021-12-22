package com.example.findmymaster.AppUI.UIPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class ApplyPageActivity extends UIBase {

    public ApplyPageActivity() {
        super(EventDispatcher.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_page);
    }
}