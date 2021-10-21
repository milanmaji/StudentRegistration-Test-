package com.sitapuramargram.studentregistration.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sitapuramargram.studentregistration.R;
import com.sitapuramargram.studentregistration.models.ExamLocation;

import java.util.List;

public class RecyclerExamAdapter extends RecyclerView.Adapter<RecyclerExamAdapter.MyViewHolder>{


    private List<ExamLocation> examLocationList;
    private Context context;
    private OnListClickListener mListener;

    public RecyclerExamAdapter(List<ExamLocation> examLocationList, Context context) {
        this.examLocationList = examLocationList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.exam_location_list_item, parent, false);
        return new MyViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ExamLocation examLocation = examLocationList.get(position);
        holder.tvSubject.setText(examLocation.getExam());
        holder.tvLocation.setText(examLocation.getLocation());
    }

    @Override
    public int getItemCount() {
        return examLocationList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvSubject,tvLocation;
        public MyViewHolder(@NonNull View itemView, final OnListClickListener onListClickListener) {
            super(itemView);
            tvSubject = itemView.findViewById(R.id.tv_subject);
            tvLocation = itemView.findViewById(R.id.tv_location);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onListClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {

                            onListClickListener.onIteamClick(position);
                        }

                    }
                }
            });
        }
    }

    public void setmListener(OnListClickListener mListener) {
        this.mListener = mListener;
    }

    public interface OnListClickListener {
        void onIteamClick(int position);


    }
}
