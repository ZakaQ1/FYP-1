package com.example.n_template.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.R;
import com.example.n_template.databinding.FragmentSendChallengeBinding;
import com.example.n_template.databinding.FragmentSendRequestBinding;
import com.example.n_template.ui.Adapters.Send_Challenges_adapter;
import com.example.n_template.ui.Adapters.Send_Request_adapter;
import com.example.n_template.ui.Models.Join_Request_model;
import com.example.n_template.ui.Models.Send_Challenges_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SendRequestFragment extends Fragment {


    public SendRequestFragment() {
        // Required empty public constructor
    }

    Firebase_database_operations opt ;
    FragmentSendRequestBinding binding;
    FirebaseAuth auth;
    Send_Request_adapter send_request_adapter;
    ArrayList<Join_Request_model> list = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentSendRequestBinding.inflate(inflater, container, false);

        auth = FirebaseAuth.getInstance();


        Query query = FirebaseDatabase.getInstance().getReference("Requests")
                .orderByChild("Sender_phone_number")
                .equalTo(auth.getCurrentUser().getPhoneNumber());

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Join_Request_model join_request_model = dataSnapshot1.getValue(Join_Request_model.class);
                    list.add(join_request_model);
                }
                send_request_adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        String receiver_team_name = getActivity().getIntent().getStringExtra("receiver_team_name");
//        String receiver_team_type = getActivity().getIntent().getStringExtra("receiver_team_type");
//        String reciever_team_id = getActivity().getIntent().getStringExtra("receiver_team_id");
//
//
//        opt = new Firebase_database_operations();
//        opt.send_request(reciever_team_id,receiver_team_type,receiver_team_name);



        send_request_adapter = new Send_Request_adapter(list, getContext());
        binding.rcSendRequest.setAdapter(send_request_adapter);
//
//        //providing linear layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rcSendRequest.setLayoutManager(layoutManager);

        return binding.getRoot();
    }
}