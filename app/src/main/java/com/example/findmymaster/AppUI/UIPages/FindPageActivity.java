package com.example.findmymaster.AppUI.UIPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.findmymaster.AppUI.MasterProgramUIBox;
import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.AppUI.recyclerAdapter;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

import java.util.ArrayList;

public class FindPageActivity extends UIBase {

    public FindPageActivity() {
        super(EventDispatcher.getInstance());
    };

    private ArrayList<MasterProgramUIBox> masterProgramUIBoxList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_page);
        masterProgramUIBoxList = new ArrayList<>();
        recyclerView = findViewById(R.id.findPage_RecyclerView);
        setMasterProgramInfo();
        setAdapter();

    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(masterProgramUIBoxList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setMasterProgramInfo() {
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer Science"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer a"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer s"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer d"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer f"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer g"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer h"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer j"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer k"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer l"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer a"));

    }
}