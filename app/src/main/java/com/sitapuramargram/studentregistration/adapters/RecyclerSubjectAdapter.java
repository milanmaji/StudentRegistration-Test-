package com.sitapuramargram.studentregistration.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.sitapuramargram.studentregistration.R;
import com.sitapuramargram.studentregistration.models.SubjectVideos;

import java.util.List;

public class RecyclerSubjectAdapter extends RecyclerView.Adapter<RecyclerSubjectAdapter.MyViewHolder>{


    private List<SubjectVideos> subjectVideosList;
    private Context context;
    private OnListClickListener mListener;
    private LifecycleOwner lifecycleOwner;

    public RecyclerSubjectAdapter(List<SubjectVideos> subjectVideosList, Context context, LifecycleOwner lifecycleOwner) {
        this.subjectVideosList = subjectVideosList;
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.subject_list_item, parent, false);
        return new MyViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        SubjectVideos subjectVideos = subjectVideosList.get(position);
        holder.tvSubjectName.setText(subjectVideos.getSujectName());
        lifecycleOwner.getLifecycle().addObserver(holder.youTubePlayer);
        holder.youTubePlayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                youTubePlayer.cueVideo(subjectVideos.getVideoId(),0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectVideosList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvSubjectName;
        YouTubePlayerView youTubePlayer;
        public MyViewHolder(@NonNull View itemView, final OnListClickListener onListClickListener) {
            super(itemView);
            tvSubjectName = itemView.findViewById(R.id.tv_subject_name);
            youTubePlayer = itemView.findViewById(R.id.youtubePlayer);

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
