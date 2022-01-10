package com.example.n_template.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.R;
import com.example.n_template.Team;
import com.example.n_template.databinding.FragmentSendChallengeBinding;
import com.example.n_template.ui.Adapters.Add_player_adapter;
import com.example.n_template.ui.Adapters.My_Teams_adapter;
import com.example.n_template.ui.Adapters.Send_Challenges_adapter;
import com.example.n_template.ui.Models.Join_team_model;
import com.example.n_template.ui.Models.My_Teams_model;
import com.example.n_template.ui.Models.Send_Challenges_model;
import com.example.n_template.ui.Models.addplayer_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;

public class Send_ChallengeFragment extends Fragment {

    //    Context context;

    public Send_ChallengeFragment() {
        // Required empty public constructor
    }

    FragmentSendChallengeBinding binding;
    //    ArrayList<Team> list = new ArrayList<>();
    ArrayList<Send_Challenges_model> list2 = new ArrayList<>();
    //    FirebaseDatabase database;
    FirebaseAuth auth;
    Send_Challenges_adapter adapter_chellenges;
    //    Team team = new Team();
//    Send_Challenges_model send_challenges_model = new Send_Challenges_model();
    Firebase_database_operations opt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSendChallengeBinding.inflate(inflater, container, false);

        //getting instances of authentications and realtime database
        auth = FirebaseAuth.getInstance();

        Query query2 = FirebaseDatabase.getInstance().getReference("Challenges")
                .orderByChild("Senderid")
                .equalTo(auth.getUid().toString());

        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Send_Challenges_model user2 = dataSnapshot1.getValue(Send_Challenges_model.class);
                    list2.add(user2);

                }
                adapter_chellenges.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // providing list to adapter
        adapter_chellenges = new Send_Challenges_adapter(list2, getContext());
        binding.rcSendChallenges.setAdapter(adapter_chellenges);

        //providing linear layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rcSendChallenges.setLayoutManager(layoutManager);
//            //2:57
        return binding.getRoot();
    }
}