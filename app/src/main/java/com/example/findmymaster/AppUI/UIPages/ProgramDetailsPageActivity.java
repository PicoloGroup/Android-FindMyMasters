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
    private static String universityNameString;
    private static String programNameString;

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
        seeCityDetailsButton = findViewById(R.id.ProgramDetailsPage_cityDetailsButton);
        applyButton = findViewById(R.id.ProgramDetailsPage_applyButton);

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
                switchIntent(ProgramDetailsPageActivity.this,ApplyPageActivity.class);
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