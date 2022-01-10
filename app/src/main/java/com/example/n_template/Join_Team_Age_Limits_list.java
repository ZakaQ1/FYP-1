package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.ui.Adapters.join_team_list_adapter;
import com.example.n_template.ui.Models.Join_team_model;
import com.example.n_template.ui.Models.addplayer_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Join_Team_Age_Limits_list extends AppCompatActivity {

    RecyclerView Rc;
    Firebase_database_operations opt ;
    join_team_list_adapter adp;
    Join_team_model team ;
    addplayer_model player_info_model2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_team_age_limits_list);
        getSupportActionBar().hide();

        team = new Join_team_model();
        opt = new Firebase_database_operations();
        Rc = findViewById(R.id.join_team_list_by_age_limit_recyclerview);

        ArrayList<Join_team_model> list = new ArrayList<>();
        String limits = getIntent().getStringExtra("limit");

        if (limits=="18_to_24"){

            player_info_model2 = new addplayer_model();
            Query query = FirebaseDatabase.getInstance().getReference().child("Players")
                    .orderByChild("age")
                    .endAt(24);
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        player_info_model2 = dataSnapshot1.getValue(addplayer_model.class);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            Query query2 = FirebaseDatabase.getInstance().getReference().child("Teams");
            query2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        team = dataSnapshot1.getValue(Join_team_model.class);
                        list.add(team);
                    }
                    adp.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }
        else if (limits=="24_to_32")
        {

            Query query = opt.Find_by_age_24_to_32();
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        team = dataSnapshot1.getValue(Join_team_model.class);
                        list.add(team);
                    }
                    adp.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else{

            Query query = opt.Find_by_age_24_to_32();
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        team = dataSnapshot1.getValue(Join_team_model.class);
                        list.add(team);
                    }
                    adp.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        adp = new join_team_list_adapter(this, list);
        LinearLayoutManager mng = new LinearLayoutManager(this);
        Rc.setAdapter(adp);
        Rc.setLayoutManager(mng);


    }
}