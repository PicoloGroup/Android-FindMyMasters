package com.example.findmymaster.AppUI.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findmymaster.AppUI.MasterProgramFindUIBox;
import com.example.findmymaster.R;

import java.util.ArrayList;

public class RecyclerFindAdapter extends RecyclerView.Adapter<RecyclerFindAdapter.MyViewHolder>  {
    private final ArrayList<MasterProgramFindUIBox> masterProgramFindUIBoxList;
    private OnMasterProgramListener mOnmasterProgramListener;

    public RecyclerFindAdapter(ArrayList<MasterProgramFindUIBox> masterProgramFindUIBoxList, OnMasterProgramListener mOnmasterProgramListener){
        this.masterProgramFindUIBoxList = masterProgramFindUIBoxList;
        this.mOnmasterProgramListener = mOnmasterProgramListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView universityName;
        private final TextView universityMajor;

        private OnMasterProgramListener onMasterProgramListener;


        public MyViewHolder(final View view, OnMasterProgramListener onMasterProgramListener) {
            super(view);
            universityName = view.findViewById(R.id.Find_List_Item_University_Name);
            universityMajor = view.findViewById((R.id.Find_List_Item_University_Major));
            this.onMasterProgramListener = onMasterProgramListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onMasterProgramListener.onMasterProgramClick(getAdapterPosition());
        }
    }

    public interface OnMasterProgramListener{
        void onMasterProgramClick(int position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_list_items_cardview,parent,false);
        return new MyViewHolder(itemView,mOnmasterProgramListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String universityName = masterProgramFindUIBoxList.get(position).getUniversityName();
        String majorName = masterProgramFindUIBoxList.get(position).getFieldOfStudy();

        holder.universityName.setText(universityName);
        holder.universityMajor.setText(majorName);

    }

    @Override
    public int getItemCount() {
        return masterProgramFindUIBoxList.size();
    }
}
