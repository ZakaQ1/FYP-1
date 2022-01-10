package com.example.n_template.Fragments;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.n_template.R;
import com.example.n_template.Team;
import com.example.n_template.databinding.FragmentReceivedChallengeFragmentsBinding;
import com.example.n_template.ui.Adapters.Receive_Challenges_adapter;
import com.example.n_template.ui.Models.Send_Challenges_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Received_ChallengeFragments extends Fragment {



    public Received_ChallengeFragments() {
        // Required empty public constructor
    }
    FragmentReceivedChallengeFragmentsBinding binding;
    ArrayList<Send_Challenges_model> list2 = new ArrayList<>();
    FirebaseAuth auth;
    Team team;
    Receive_Challenges_adapter receive_challenges_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReceivedChallengeFragmentsBinding.inflate(inflater, container,false);

        auth = FirebaseAuth.getInstance();

        team = new Team();
        String receiver ;
        Query query = FirebaseDatabase.getInstance().getReference().child("Challenges")
                .orderByChild("Receiverid")
                .equalTo(auth.getUid().toString());

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list2.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Send_Challenges_model user = dataSnapshot1.getValue(Send_Challenges_model.class);
                                 list2.add(user);
                            }
                            receive_challenges_adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });










        receive_challenges_adapter = new Receive_Challenges_adapter(list2,getContext());
        binding.rcReceiveChallenges.setAdapter(receive_challenges_adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rcReceiveChallenges.setLayoutManager(layoutManager);

        return binding.getRoot();
    }
}