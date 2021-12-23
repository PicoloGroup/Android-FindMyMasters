package com.example.findmymaster.AppUI.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.findmymaster.AppUI.Adapter.RecyclerFindAdapter;
import com.example.findmymaster.R;

public class ExploreFragment extends Fragment implements RecyclerFindAdapter.OnMasterProgramListener {

    RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_explore_fragment,container,false);
        return rootView;
    }

    @Override
    public void onMasterProgramClick(int position) {

    }
}