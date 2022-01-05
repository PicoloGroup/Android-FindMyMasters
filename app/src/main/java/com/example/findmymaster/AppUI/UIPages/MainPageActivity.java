package com.example.findmymaster.AppUI.UIPages;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.findmymaster.AppUI.Fragment.DecideFragment;
import com.example.findmymaster.AppUI.Fragment.ExploreFragment;
import com.example.findmymaster.AppUI.Fragment.FindFragment;
import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class MainPageActivity extends UIBase {

    private DecideFragment decideFragment;
    private ExploreFragment exploreFragment;
    private FindFragment findFragment;

    private Button findButton;
    private Button exploreButton;
    private Button decideButton;
    private Button profileButton;


    public MainPageActivity() {
        super(EventDispatcher.getInstance());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //Fragments

        decideFragment = new DecideFragment();
        exploreFragment = new ExploreFragment();
        findFragment = new FindFragment();

        //hooks
        findButton = findViewById(R.id.MainPage_findButton);
        exploreButton = findViewById(R.id.MainPage_exploreButton);
        decideButton = findViewById(R.id.MainPage_decideButton);
        profileButton = findViewById(R.id.MainPage_profileButton);

        getSupportFragmentManager().beginTransaction().replace(R.id.MainPage_fragmentContainer,exploreFragment).commit();

        //Listeners

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateFind();
            }
        });

        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateExplore();
            }
        });

        decideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateDecide();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateProfile();
            }
        });
    }

    //Activating Button Functions

    private void activateFind(){
/*        lightUpButton(findButton);
        lightDownButton(exploreButton);
        lightDownButton(decideButton);
        lightDownButton(profileButton);*/
        getSupportFragmentManager().beginTransaction().replace(R.id.MainPage_fragmentContainer,findFragment).commit();
    }

    private void activateExplore(){
//        lightUpButton(exploreButton);
//        lightDownButton(findButton);
//        lightDownButton(decideButton);
//        lightDownButton(profileButton);
        getSupportFragmentManager().beginTransaction().replace(R.id.MainPage_fragmentContainer,exploreFragment).commit();
    }

    private void activateDecide(){
/*        lightUpButton(decideButton);
        lightDownButton(findButton);
        lightDownButton(exploreButton);
        lightDownButton(profileButton);*/
        getSupportFragmentManager().beginTransaction().replace(R.id.MainPage_fragmentContainer,decideFragment).commit();
    }

    private void activateProfile(){
/*        lightUpButton(profileButton);
        lightDownButton(findButton);
        lightDownButton(exploreButton);
        lightDownButton(decideButton);*/
        switchIntent(MainPageActivity.this,ProfilePageActivity.class);
    }

    private void lightUpButton(Button b){
        b.setTextColor(0xFFC31D1D);
    }

    private void lightDownButton(Button b) {
        b.setTextColor(0x818181);
    }
}