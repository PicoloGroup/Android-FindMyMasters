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

import com.example.findmymaster.AppUI.MasterProgramFindUIBox;
import com.example.findmymaster.AppUI.UIPages.ProgramDetailsPageActivity;
import com.example.findmymaster.AppUI.Adapter.RecyclerFindAdapter;
import com.example.findmymaster.R;

import java.util.ArrayList;

public class FindFragment extends Fragment implements RecyclerFindAdapter.OnMasterProgramListener {

    private ArrayList<MasterProgramFindUIBox> masterProgramFindUIBoxList;
    private RecyclerView recyclerView;
    private Context mainPageContext;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.findFragment_RecyclerView);
        masterProgramFindUIBoxList = new ArrayList<>();
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
        RecyclerFindAdapter adapter = new RecyclerFindAdapter(masterProgramFindUIBoxList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainPageContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setMasterProgramInfo() {
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Koc University","Computer Science"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("University of Oxford","Economics"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("London Business School","Financial Economics"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Istanbul Technical University","Computer Vision"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Bogazici University","Artificial Intelligence"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Middle East Technical University","Cyber Security"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Stanford University","Data Science for Decision Making"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Yale University","Digital Business"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Harvard University","Big Data Management"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Stanford University","Machine Learning"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Yale University","Data Analytics"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Harvard University","Game Design"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Princeton University","Data Engineering"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Koc University","Data Analytics"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("University of California","Signal Processing"));
    }

    @Override
    public void onMasterProgramClick(int position) {
        MasterProgramFindUIBox element = masterProgramFindUIBoxList.get(position);
        ProgramDetailsPageActivity.setUniversityNameString(element.getUniversityName());
        ProgramDetailsPageActivity.setProgramNameString(element.getFieldOfStudy());
        switchIntent(mainPageContext,ProgramDetailsPageActivity.class);
    }

    public void switchIntent(android.content.Context context, Class<?> target){
        Intent intent = new Intent(context, target);
        startActivity(intent);
    }
}