package com.example.findmymaster.AppUI.UIPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class ProfilePageActivity extends UIBase {

    private Button updateButton;

    public ProfilePageActivity() {
        super(EventDispatcher.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        updateButton = findViewById(R.id.ProfilePage_updateButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(v);
            }
        });
    }

    public void displayToast(View v){
        Toast.makeText(ProfilePageActivity.this, "Your profile has been updated", Toast.LENGTH_SHORT).show();
    }
}