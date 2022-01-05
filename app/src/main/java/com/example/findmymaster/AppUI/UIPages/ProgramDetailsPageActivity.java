package com.example.findmymaster.AppUI.UIPages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findmymaster.AppUI.Fragment.DecideFragment;
import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class ProgramDetailsPageActivity extends UIBase {

    private TextView universityName;
    private TextView programName;
    private TextView durationField;
    private TextView tuitionField;
    private TextView deadlineField;
    private TextView languageField;
    private TextView cityName;
    private TextView countryName;

    private Button seeCityDetailsButton;
    private Button applyButton;
    private Button selectButton;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private static String universityNameString;
    private static String programNameString;
    private static String durationString;
    private static String priceString;
    private static String dateString;
    private static String languageString;
    private static String cityString;
    private static String countryString;

    private static int counter = 0;


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
        durationField = findViewById(R.id.programDetailsPage_durationField);
        tuitionField = findViewById(R.id.programDetailsPage_tuitionField);
        deadlineField = findViewById(R.id.programDetailsPage_deadlineField);
        languageField = findViewById(R.id.programDetailsPage_languageField);
        cityName = findViewById(R.id.programDetailsPage_cityNameText);
        countryName = findViewById(R.id.programDetailsPage_countryNameText);
        seeCityDetailsButton = findViewById(R.id.ProgramDetailsPage_cityDetailsButton);
        applyButton = findViewById(R.id.ProgramDetailsPage_applyButton);
        selectButton = findViewById(R.id.ProgramDetailsPage_selectButton);

        //Set Text
        universityName.setText(universityNameString);
        programName.setText(programNameString);
        durationField.setText(durationString);
        tuitionField.setText(priceString);
        deadlineField.setText(dateString);
        languageField.setText(languageString);
        cityName.setText(cityString);
        countryName.setText(countryString);
        CityDetailsPageActivity.setCityNameString(cityString);
        CityDetailsPageActivity.setCountryNameString(countryString);



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
                displayToast(v);
            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectProgram();
                MainPageActivity.requestDecideFragment();
                switchIntent(ProgramDetailsPageActivity.this,MainPageActivity.class);
            }
        });
    }

    public void displayToast(View v){
        Toast.makeText(ProgramDetailsPageActivity.this, "Your application request has been sent", Toast.LENGTH_SHORT).show();
    }

    public static void setUniversityNameString(String s){
        universityNameString = s;
    }

    public static void setProgramNameString(String s) {
        programNameString = s;
    }

    public static void setDurationString(String durationString) {
        ProgramDetailsPageActivity.durationString = durationString;
    }

    public static void setPriceString(String priceString) {
        ProgramDetailsPageActivity.priceString = priceString;
    }

    public static void setDateString(String dateString) {
        ProgramDetailsPageActivity.dateString = dateString;
    }

    public static void setLanguageString(String languageString) {
        ProgramDetailsPageActivity.languageString = languageString;
    }

    public static void setCityString(String cityString) {
        ProgramDetailsPageActivity.cityString = cityString;
    }

    public static void setCountryString(String countryString) {
        ProgramDetailsPageActivity.countryString = countryString;
    }
    public void selectProgram(){
            DecideFragment.addDecideElement(countryString, cityString, universityNameString, programNameString, "123", priceString, durationString, dateString, languageString, R.drawable.logo_yale_university);
    }
}