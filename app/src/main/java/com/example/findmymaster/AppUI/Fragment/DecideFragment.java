package com.example.findmymaster.AppUI.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.findmymaster.AppUI.Adapter.RecyclerDecideAdapter;
import com.example.findmymaster.AppUI.MasterProgramDecideUIBox;
import com.example.findmymaster.AppUI.UIPages.ProgramDetailsPageActivity;
import com.example.findmymaster.R;

import java.util.ArrayList;

public class DecideFragment extends Fragment implements RecyclerDecideAdapter.OnMasterProgramListener  {
    
    private static final ArrayList<MasterProgramDecideUIBox> MasterProgramDecideUIBoxList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Context mainPageContext;
    private Button clearButton;
    private static int counter = 0;
    RecyclerDecideAdapter adapter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.DecideFragment_recyclerView);
        mainPageContext = view.getContext();
        setAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_decide_fragment,container,false);

        clearButton = rootView.findViewById(R.id.DecideFragment_clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DecideFragment.MasterProgramDecideUIBoxList.clear();
                DecideFragment.counter = 0;
                adapter.notifyItemRemoved(0);
                adapter.notifyItemRemoved(1);
            }
        });

        return rootView;
    }

    private void setAdapter() {
        adapter = new RecyclerDecideAdapter(MasterProgramDecideUIBoxList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainPageContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public static void addDecideElement(String countryName,String cityName, String universityName, String fieldOfStudy,
                                        String programRank, String programCost, String programDuration,String date, String programLanguage, int universityImage){
        if(MasterProgramDecideUIBoxList.size()<2) {
            if(counter == 0){
                MasterProgramDecideUIBoxList.add(new MasterProgramDecideUIBox(countryName, cityName, universityName, fieldOfStudy, "351", programCost, programDuration, date, programLanguage, R.drawable.logo_koc_university));
            }
            if (counter == 1){
                MasterProgramDecideUIBoxList.add(new MasterProgramDecideUIBox(countryName, cityName, universityName, fieldOfStudy,"16", programCost, programDuration, date, programLanguage, R.drawable.logo_yale_university));
            }
        }
        counter++;
    }



    @Override
    public void onMasterProgramClick(int position) {
        MasterProgramDecideUIBox element = MasterProgramDecideUIBoxList.get(position);
        ProgramDetailsPageActivity.setUniversityNameString(element.getUniversityName());
        ProgramDetailsPageActivity.setProgramNameString(element.getFieldOfStudy());
        ProgramDetailsPageActivity.setDurationString(element.getProgramDuration());
        ProgramDetailsPageActivity.setCityString(element.getCityName());
        ProgramDetailsPageActivity.setCountryString(element.getCountryName());
        ProgramDetailsPageActivity.setDateString(element.getDate());
        ProgramDetailsPageActivity.setPriceString(element.getProgramCost());
        ProgramDetailsPageActivity.setLanguageString(element.getProgramLanguage());

        switchIntent(mainPageContext,ProgramDetailsPageActivity.class);
    }

    public void switchIntent(android.content.Context context, Class<?> target){
        Intent intent = new Intent(context, target);
        startActivity(intent);
    }

}