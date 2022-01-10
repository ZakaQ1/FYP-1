package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.ui.Adapters.team_list_adapter;
import com.example.n_template.ui.Models.Join_team_model;
import com.example.n_template.ui.Models.Team_list_model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Team_list extends AppCompatActivity {

    RecyclerView Rc;
    Firebase_database_operations opt ;
    team_list_adapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        getSupportActionBar().hide();

        opt = new Firebase_database_operations();
        Rc = findViewById(R.id.team_list_recyclerview);

        ArrayList<Join_team_model> list = new ArrayList<>();

        Query query = opt.Retreive_Team_List();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Join_team_model set_match_team = dataSnapshot1.getValue(Join_team_model.class);
                    list.add(set_match_team);

                }
                adp.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        list.add(new Join_team_model("Team A"));
//        list.add(new Join_team_model("Team B"));
//        list.add(new Join_team_model("Team C"));
//        list.add(new Join_team_model("Team D"));


        adp = new team_list_adapter(this, list);
        LinearLayoutManager mng = new LinearLayoutManager(this);
        Rc.setAdapter(adp);
        Rc.setLayoutManager(mng);
    }
}