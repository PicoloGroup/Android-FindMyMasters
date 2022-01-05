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
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Koc University","Computer Science","27850 USD","24 months","English","11 Dec 2022","Istanbul","Turkey"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("University of Oxford","Economics","48250 USD","12 months","English","31 Sep 2022","Oxfordshire","England"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("London Business School","Financial Economics","44550 USD","24 months","English","21 Oct 2022","London","England"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Istanbul Technical University","Computer Vision","11850 USD","24 months","English","18 Sep 2022","Istanbul","Turkey"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Bogazici University","Artificial Intelligence","13850 USD","24 months","English","22 Aug 2022","Istanbul","Turkey"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Middle East Technical University","Cyber Security","12850 USD","24 months","English","14 Sep 2022","Ankara","Turkey"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Stanford University","Data Science for Decision Making","55850 USD","24 months","English","04 Dec 2022","Stanford","United States"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Yale University","Digital Business","53350 USD","24 months","English","24 Dec 2022","New Haven","United States"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Harvard University","Big Data Management","63450 USD","24 months","English","31 Sep 2022","Cambridge","United States"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Stanford University","Machine Learning","65450 USD","24 months","English","01 Oct 2022","Stanford","United States"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Yale University","Data Analytics","57150 USD","24 months","English","11 Sep 2022","New Haven","United States"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Harvard University","Game Design","66950 USD","24 months","English","18 Oct 2022","Cambridge","United States"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Princeton University","Data Engineering","69990 USD","24 months","English","13 Dec 2022","Princeton","United States"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("Koc University","Data Analytics","31550 USD","24 months","English","21 Jan 2022","Istanbul","Turkey"));
        masterProgramFindUIBoxList.add(new MasterProgramFindUIBox("University of California","Signal Processing","70850 USD","24 months","English","21 Aug 2022","Oakland","United States"));
    }

    @Override
    public void onMasterProgramClick(int position) {
        MasterProgramFindUIBox element = masterProgramFindUIBoxList.get(position);
        ProgramDetailsPageActivity.setUniversityNameString(element.getUniversityName());
        ProgramDetailsPageActivity.setProgramNameString(element.getFieldOfStudy());
        ProgramDetailsPageActivity.setCityString(element.getCity());
        ProgramDetailsPageActivity.setCountryString(element.getCountry());
        ProgramDetailsPageActivity.setDateString(element.getDuration());
        ProgramDetailsPageActivity.setPriceString(element.getPrice());
        ProgramDetailsPageActivity.setLanguageString(element.getLanguage());
        ProgramDetailsPageActivity.setDateString(element.getDate());
        switchIntent(mainPageContext,ProgramDetailsPageActivity.class);
    }

    public void switchIntent(android.content.Context context, Class<?> target){
        Intent intent = new Intent(context, target);
        startActivity(intent);
    }
}