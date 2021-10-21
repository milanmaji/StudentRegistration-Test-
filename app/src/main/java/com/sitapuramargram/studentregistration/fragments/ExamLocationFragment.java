package com.sitapuramargram.studentregistration.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sitapuramargram.studentregistration.R;
import com.sitapuramargram.studentregistration.activities.MapsActivity;
import com.sitapuramargram.studentregistration.adapters.RecyclerExamAdapter;
import com.sitapuramargram.studentregistration.models.ExamLocation;

import java.util.ArrayList;
import java.util.List;


public class ExamLocationFragment extends Fragment {


    private List<ExamLocation> examLocationList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager packLayoutManager;
    private RecyclerExamAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_exam_location, container, false);

        examLocationList.add(new ExamLocation("Computer","Airport,Kolkata","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("English","Dharmatala,Kolkata","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("Mathematics","Tala,Kolkata","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("Computer","Tiljala,Kolkata","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("Computer","Madhyamgram,WB","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("English","Barasat,WB","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("Mathematics","Saltlake City","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("Mathematics","Newtown Rajarhat","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("Mathematics","Kolkata","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("Computer","Webel IT Park","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("English","Ultadanga,Kolkata","22.6531,88.4449"));
        examLocationList.add(new ExamLocation("Mathematics","Howrah,Kolkata","22.6531,88.4449"));

        recyclerView = view.findViewById(R.id.recylerview);
        packLayoutManager = new LinearLayoutManager(getContext());
        packLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(packLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        loadData();



        return view;
    }

    private void loadData() {

        adapter = new RecyclerExamAdapter(examLocationList,getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        adapter.setmListener(new RecyclerExamAdapter.OnListClickListener() {
            @Override
            public void onIteamClick(int position) {

                Intent intent = new Intent(getContext(), MapsActivity.class);
                intent.putExtra("LatLong",examLocationList.get(position).getLatLong());
                startActivity(intent);
            }
        });
    }
}