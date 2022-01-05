package com.example.findmymaster.AppUI.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findmymaster.AppUI.MasterProgramDecideUIBox;
import com.example.findmymaster.AppUI.MasterProgramFindUIBox;
import com.example.findmymaster.R;

import java.security.SecureRandom;
import java.util.ArrayList;

public class RecyclerDecideAdapter extends RecyclerView.Adapter<RecyclerDecideAdapter.MyViewHolder>  {
    private final ArrayList<MasterProgramDecideUIBox> masterProgramDecideUIBoxList;
    private OnMasterProgramListener mOnmasterProgramListener;

    public RecyclerDecideAdapter(ArrayList<MasterProgramDecideUIBox> masterProgramDecideUIBoxList, OnMasterProgramListener mOnmasterProgramListener){
        this.masterProgramDecideUIBoxList = masterProgramDecideUIBoxList;
        this.mOnmasterProgramListener = mOnmasterProgramListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView countryName;
        private final TextView universityName;
        private final TextView universityProgramName;
        private final TextView programRank;
        private final TextView programDuration;
        private final TextView programCost;
        private final TextView programLanguage;
        private final ImageView universityImage;

        private OnMasterProgramListener onMasterProgramListener;


        public MyViewHolder(final View view, OnMasterProgramListener onMasterProgramListener) {
            super(view);
            countryName = view.findViewById(R.id.DecideCardView_programCountryNameValue);
            universityName = view.findViewById(R.id.DecideCardView_universityNameValue);
            universityProgramName = view.findViewById((R.id.DecideCardView_programNameValue));
            programRank = view.findViewById(R.id.DecideCardView_programRankingValue);
            programDuration = view.findViewById(R.id.DecideCardView_programDurationValue);
            programCost = view.findViewById(R.id.DecideCardView_programCostValue);
            programLanguage = view.findViewById(R.id.DecideCardView_programLanguageValue);
            universityImage = view.findViewById((R.id.DecideCardView_universityImage));

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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.decide_program_properties_cardview,parent,false);
        return new MyViewHolder(itemView,mOnmasterProgramListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String countryName = masterProgramDecideUIBoxList.get(position).getCountryName();
        String universityName = masterProgramDecideUIBoxList.get(position).getUniversityName();
        String universityProgramName = masterProgramDecideUIBoxList.get(position).getFieldOfStudy();
        String programRank = masterProgramDecideUIBoxList.get(position).getProgramRank();
        String programDuration = masterProgramDecideUIBoxList.get(position).getProgramDuration();
        String programCost = masterProgramDecideUIBoxList.get(position).getProgramCost();
        String programLanguage = masterProgramDecideUIBoxList.get(position).getProgramLanguage();
        int universityImage = masterProgramDecideUIBoxList.get(position).getUniversityImage();

        holder.countryName.setText(countryName);
        holder.universityName.setText(universityName);
        holder.universityProgramName.setText(universityProgramName);
        holder.programRank.setText(programRank);
        holder.programDuration.setText(programDuration);
        holder.programCost.setText(programCost);
        holder.programLanguage.setText(programLanguage);
        holder.universityImage.setImageResource(universityImage);

    }

    @Override
    public int getItemCount() {
        return masterProgramDecideUIBoxList.size();
    }
}
