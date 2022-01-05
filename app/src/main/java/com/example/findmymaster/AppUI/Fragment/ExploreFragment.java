package com.example.findmymaster.AppUI.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.findmymaster.AppUI.Adapter.RecyclerExploreAdapter;
import com.example.findmymaster.AppUI.MasterProgramExploreUIBox;
import com.example.findmymaster.AppUI.UIPages.ProgramDetailsPageActivity;
import com.example.findmymaster.R;

import java.util.ArrayList;

public class ExploreFragment extends Fragment implements RecyclerExploreAdapter.OnMasterProgramListener {
    
    private ArrayList<MasterProgramExploreUIBox> masterProgramExploreUIBoxList;
    private RecyclerView recyclerView;
    private Context mainPageContext;
    private LinearLayoutManager layoutManager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.ExploreFragment_featuredRecyclerView);
        masterProgramExploreUIBoxList = new ArrayList<>();
        mainPageContext = view.getContext();

        setMasterProgramInfo();
        setAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_explore_fragment,container,false);
        return rootView;

    }

    private void setAdapter() {
        RecyclerExploreAdapter adapter = new RecyclerExploreAdapter(masterProgramExploreUIBoxList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainPageContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setMasterProgramInfo() {
        masterProgramExploreUIBoxList.add(new MasterProgramExploreUIBox("Koc University","Robotics",R.drawable.study_group3));
        masterProgramExploreUIBoxList.add(new MasterProgramExploreUIBox("Yale University","Data Science",R.drawable.study_group2));
        masterProgramExploreUIBoxList.add(new MasterProgramExploreUIBox("Harvard University","Data Analytics",R.drawable.study_group));
    }

    @Override
    public void onMasterProgramClick(int position) {
        MasterProgramExploreUIBox element = masterProgramExploreUIBoxList.get(position);
        ProgramDetailsPageActivity.setUniversityNameString(element.getUniversityName());
        ProgramDetailsPageActivity.setProgramNameString(element.getFieldOfStudy());
        switchIntent(mainPageContext,ProgramDetailsPageActivity.class);
    }

    public void switchIntent(android.content.Context context, Class<?> target){
        Intent intent = new Intent(context, target);
        startActivity(intent);
    }
}