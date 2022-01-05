package com.example.findmymaster.AppUI.UIPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class ApplyPageActivity extends UIBase {

    private EditText studentNameValue;
    private EditText studentGender;
    private EditText studentBirthday;
    private EditText studentSSN;
    private EditText universityName;
    private EditText programName;
    private Button submitButton;

    public ApplyPageActivity() {
        super(EventDispatcher.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_page);

        //Hooks
        studentNameValue = findViewById(R.id.ApplyPage_studentNameEditText);
        studentGender = findViewById(R.id.ApplyPage_studentGenderEditText);
        studentBirthday = findViewById(R.id.ApplyPage_studentBirthdayEditText);
        studentSSN = findViewById(R.id.ApplyPage_studentSocialSecurityNumberEditText);
        universityName = findViewById(R.id.ApplyPage_universityEditText);
        programName = findViewById(R.id.ApplyPage_programEditText);
        submitButton = findViewById(R.id.ApplyPage_submitButton);


    }
}