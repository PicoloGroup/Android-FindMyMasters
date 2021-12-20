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

public class FindPageActivity extends UIBase implements recyclerAdapter.OnMasterProgramListener {

    public FindPageActivity() {
        super(EventDispatcher.getInstance());
    };

    private ArrayList<MasterProgramUIBox> masterProgramUIBoxList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_page);
        recyclerView = findViewById(R.id.findPage_RecyclerView);
        masterProgramUIBoxList = new ArrayList<>();

        setMasterProgramInfo();
        setAdapter();

    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(masterProgramUIBoxList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setMasterProgramInfo() {
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Computer Science"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Economics"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Electronic Engineering"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Finance"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Law"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Topology"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","History"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Astrophysics"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Literature"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Medicine"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Chemistry"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Physiology"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Data Engineering"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Artificial Intelligence"));
        masterProgramUIBoxList.add(new MasterProgramUIBox("Koc University","Signal Processing"));
    }

    @Override
    public void onMasterProgramClick(int position) {
        MasterProgramUIBox element = masterProgramUIBoxList.get(position);
        ProgramDetailsPageActivity.setUniversityNameString(element.getUniversityName());
        ProgramDetailsPageActivity.setProgramNameString(element.getFieldOfStudy());
        switchIntent(FindPageActivity.this,ProgramDetailsPageActivity.class);
    }
}