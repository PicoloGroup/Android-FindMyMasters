package com.example.findmymaster.AppUI.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findmymaster.AppUI.MasterProgramUIBox;
import com.example.findmymaster.AppUI.UIPages.ProgramDetailsPageActivity;
import com.example.findmymaster.AppUI.recyclerAdapter;
import com.example.findmymaster.R;

import java.util.ArrayList;

public class FindFragment extends Fragment implements recyclerAdapter.OnMasterProgramListener {

    private ArrayList<MasterProgramUIBox> masterProgramUIBoxList;
    private RecyclerView recyclerView;
    private Context mainPageContext;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.findPage_RecyclerView);
        masterProgramUIBoxList = new ArrayList<>();
        mainPageContext = view.getContext();

        setMasterProgramInfo();
        setAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_find_fragment,container,false);
        return rootView;

    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(masterProgramUIBoxList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainPageContext);
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
        switchIntent(mainPageContext,ProgramDetailsPageActivity.class);
    }

    public void switchIntent(android.content.Context context, Class<?> target){
        Intent intent = new Intent(context, target);
        startActivity(intent);
    }
}