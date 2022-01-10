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
import com.example.n_template.databinding.FragmentReceiveRequestBinding;
import com.example.n_template.databinding.FragmentSendChallengeBinding;
import com.example.n_template.databinding.FragmentSendRequestBinding;
import com.example.n_template.ui.Adapters.Receive_Request_adapter;
import com.example.n_template.ui.Adapters.Send_Request_adapter;
import com.example.n_template.ui.Models.Join_Request_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ReceiveRequestFragment extends Fragment {
    Context context;
    ArrayList<Join_Request_model> list = new ArrayList<>();
    FirebaseAuth auth;
    Firebase_database_operations opt;
    Receive_Request_adapter receive_request_adapter;

    public ReceiveRequestFragment() {
        // Required empty public constructor
    }
    FragmentReceiveRequestBinding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReceiveRequestBinding.inflate(inflater, container, false);
        auth = FirebaseAuth.getInstance();

        Query query = FirebaseDatabase.getInstance().getReference("Requests")
                .orderByChild("Reciever_id")
                .equalTo(auth.getUid());

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Join_Request_model join_request_model = dataSnapshot1.getValue(Join_Request_model.class);
                    list.add(join_request_model);
                }
                receive_request_adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        receive_request_adapter = new Receive_Request_adapter(list, getContext());
        binding.rcReceiveRequest.setAdapter(receive_request_adapter);

        //providing linear layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rcReceiveRequest.setLayoutManager(layoutManager);


        return binding.getRoot();


    }
}