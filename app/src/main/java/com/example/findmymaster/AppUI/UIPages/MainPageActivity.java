package com.example.findmymaster.AppUI.UIPages;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class MainPageActivity extends UIBase {

    private ImageButton exploreIcon;
    private ImageButton findIcon;
    private ImageButton decideIcon;
    private ImageButton applyIcon;

    public MainPageActivity() {
        super(EventDispatcher.getInstance());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //hooks
        exploreIcon = findViewById(R.id.MainPage_exploreButton);
        findIcon = findViewById(R.id.MainPage_findButton);
        decideIcon = findViewById(R.id.MainPage_decideButton);
        applyIcon = findViewById(R.id.MainPage_applyButton);
        initialize();


    }
    private void initialize(){

        exploreIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // switchIntent();
            }
        });

        findIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIntent(MainPageActivity.this,FindPageActivity.class);
            }
        });
        decideIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switchIntent();
            }
        });
        applyIcon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switchIntent();
            }
        });
    }
}