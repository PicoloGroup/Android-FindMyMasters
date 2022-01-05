package com.example.findmymaster.AppUI.UIPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class ProgramDetailsPageActivity extends UIBase {

    private TextView universityName;
    private TextView programName;
    private Button seeCityDetailsButton;
    private Button applyButton;
    private Button selectButton;
    private static String universityNameString;
    private static String programNameString;
    private static String durationString;
    private static String priceString;
    private static String dateString;
    private static String languageString;
    private static String cityString;
    private static String countryString;


    public ProgramDetailsPageActivity() {
        super(EventDispatcher.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_details_page);

        //Hooks
        universityName = findViewById(R.id.ProgramDetailsPage_universityNameText);
        programName = findViewById(R.id.ProgramDetailsPage_programNameText);
        durationString = findViewById(R.id.ProgramDe)

        seeCityDetailsButton = findViewById(R.id.ProgramDetailsPage_cityDetailsButton);
        applyButton = findViewById(R.id.ProgramDetailsPage_applyButton);
        selectButton = findViewById(R.id.ProgramDetailsPage_selectButton);
        universityName.setText(universityNameString);
        programName.setText(programNameString);


        //Action Listeners

        seeCityDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIntent(ProgramDetailsPageActivity.this,CityDetailsPageActivity.class);
            }
        });

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //        switchIntent(ProgramDetailsPageActivity.this,ApplyPageActivity.class);
            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchIntent(ProgramDetailsPageActivity.this,MainPageActivity.class);
            }
        });




    }

    public static void setUniversityNameString(String s){
        universityNameString = s;
    }

    public static void setProgramNameString(String s) {
        programNameString = s;
    }
}