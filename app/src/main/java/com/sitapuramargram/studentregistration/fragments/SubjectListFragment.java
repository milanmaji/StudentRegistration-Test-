package com.sitapuramargram.studentregistration.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sitapuramargram.studentregistration.R;
import com.sitapuramargram.studentregistration.adapters.RecyclerExamAdapter;
import com.sitapuramargram.studentregistration.adapters.RecyclerSubjectAdapter;
import com.sitapuramargram.studentregistration.models.ExamLocation;
import com.sitapuramargram.studentregistration.models.SubjectVideos;

import java.util.ArrayList;
import java.util.List;


public class SubjectListFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager packLayoutManager;
    private List<SubjectVideos> examLocationList = new ArrayList<>();
    private RecyclerSubjectAdapter subjectAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_subject_list, container, false);


        examLocationList.add(new SubjectVideos("Subject","WJ-UaAaumNA"));
        examLocationList.add(new SubjectVideos("Subject","WJ-UaAaumNA"));
        examLocationList.add(new SubjectVideos("Subject","WJ-UaAaumNA"));


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

        subjectAdapter = new RecyclerSubjectAdapter(examLocationList,getContext(),getViewLifecycleOwner());
        recyclerView.setAdapter(subjectAdapter);
        subjectAdapter.notifyDataSetChanged();
    }
}