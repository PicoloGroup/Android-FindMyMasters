package com.example.findmymaster.AppUI;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findmymaster.R;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.myViewHolder> {
    private final ArrayList<MasterProgramUIBox> masterProgramUIBoxList;

    public recyclerAdapter(ArrayList<MasterProgramUIBox> masterProgramUIBoxList){
        this.masterProgramUIBoxList = masterProgramUIBoxList;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        private final TextView universityName;
        private final TextView universityMajor;

        public  myViewHolder (final View view) {
            super(view);
            universityName = view.findViewById(R.id.Find_List_Item_University_Name);
            universityMajor = view.findViewById((R.id.Find_List_Item_University_Major));
        }

    }


    @NonNull
    @Override
    public recyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_list_items,parent,false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.myViewHolder holder, int position) {

        String universityName = masterProgramUIBoxList.get(position).getUniversityName();
        String majorName = masterProgramUIBoxList.get(position).getFieldOfStudy();

        holder.universityName.setText(universityName);
        holder.universityMajor.setText(majorName);

    }

    @Override
    public int getItemCount() {
        return masterProgramUIBoxList.size();
    }
}
