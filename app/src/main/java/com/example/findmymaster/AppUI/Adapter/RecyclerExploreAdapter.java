package com.example.findmymaster.AppUI.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findmymaster.AppUI.MasterProgramExploreUIBox;
import com.example.findmymaster.R;

import java.util.ArrayList;

public class RecyclerExploreAdapter extends RecyclerView.Adapter<RecyclerExploreAdapter.MyViewHolder> {

    private final ArrayList<MasterProgramExploreUIBox> MasterProgramExploreUIBoxList;
    private RecyclerExploreAdapter.OnMasterProgramListener mOnmasterProgramListener;

    public RecyclerExploreAdapter(ArrayList<MasterProgramExploreUIBox> MasterProgramExploreUIBoxList, RecyclerExploreAdapter.OnMasterProgramListener mOnmasterProgramListener){
        this.MasterProgramExploreUIBoxList = MasterProgramExploreUIBoxList;
        this.mOnmasterProgramListener = mOnmasterProgramListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView universityName;
        private final TextView universityProgramName;
        private final ImageView universityImage;

        private RecyclerExploreAdapter.OnMasterProgramListener onMasterProgramListener;


        public MyViewHolder(final View view, RecyclerExploreAdapter.OnMasterProgramListener onMasterProgramListener) {
            super(view);
            universityName = view.findViewById(R.id.ExploreFragment_universityName);
            universityProgramName = view.findViewById((R.id.ExploreFragment_universityProgramName));
            universityImage = view.findViewById(R.id.ExploreFragment_studyGroup_1);

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
    public RecyclerExploreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_fragment_cardview,parent,false);
        return new RecyclerExploreAdapter.MyViewHolder(itemView,mOnmasterProgramListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerExploreAdapter.MyViewHolder holder, int position) {

        String universityName = MasterProgramExploreUIBoxList.get(position).getUniversityName();
        String universityProgramName = MasterProgramExploreUIBoxList.get(position).getFieldOfStudy();
        int universityImage = MasterProgramExploreUIBoxList.get(position).getUniversityImage();

        holder.universityName.setText(universityName);
        holder.universityProgramName.setText(universityProgramName);
        holder.universityImage.setImageResource(universityImage);
    }
    
    @Override
    public int getItemCount() {
        return MasterProgramExploreUIBoxList.size();
    }
    
    
}
