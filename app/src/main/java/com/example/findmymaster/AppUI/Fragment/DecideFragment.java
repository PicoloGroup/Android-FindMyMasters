package com.example.findmymaster.AppUI.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import com.example.findmymaster.AppUI.Adapter.RecyclerDecideAdapter;
import com.example.findmymaster.AppUI.MasterProgramDecideUIBox;
import com.example.findmymaster.AppUI.UIPages.ProgramDetailsPageActivity;
import com.example.findmymaster.R;

import java.util.ArrayList;

public class DecideFragment extends Fragment implements RecyclerDecideAdapter.OnMasterProgramListener {
    
    private ArrayList<MasterProgramDecideUIBox> MasterProgramDecideUIBoxList;
    private RecyclerView recyclerView;
    private Context mainPageContext;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.DecideFragment_recyclerView);
        MasterProgramDecideUIBoxList = new ArrayList<>();
        mainPageContext = view.getContext();
        setMasterProgramInfo();
        setAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_decide_fragment,container,false);
        return rootView;

    }

    private void setAdapter() {
        RecyclerDecideAdapter adapter = new RecyclerDecideAdapter(MasterProgramDecideUIBoxList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainPageContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setMasterProgramInfo() {
        MasterProgramDecideUIBoxList.add(new MasterProgramDecideUIBox("USA", "Yale University", "Robotics",
                "#12","45000$","2 years","English"));

        MasterProgramDecideUIBoxList.add(new MasterProgramDecideUIBox("Turkey", "Koc University", "Robotics",
                "#74","27850$","2 years","English"));
    }

    @Override
    public void onMasterProgramClick(int position) {
        MasterProgramDecideUIBox element = MasterProgramDecideUIBoxList.get(position);
        ProgramDetailsPageActivity.setUniversityNameString(element.getUniversityName());
        ProgramDetailsPageActivity.setProgramNameString(element.getFieldOfStudy());
        switchIntent(mainPageContext,ProgramDetailsPageActivity.class);
    }

    public void switchIntent(android.content.Context context, Class<?> target){
        Intent intent = new Intent(context, target);
        startActivity(intent);
    }
}