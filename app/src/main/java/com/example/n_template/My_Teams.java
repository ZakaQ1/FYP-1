package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.ui.Adapters.My_Teams_adapter;
import com.example.n_template.ui.Models.My_Teams_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Queue;

public class My_Teams extends AppCompatActivity {


    RecyclerView rc;
    ArrayList<Team> list = new ArrayList<>();
    FirebaseDatabase database;
    FirebaseAuth auth;
    My_Teams_adapter adp;
    Firebase_database_operations opt;
    Team team = new Team();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_teams);
        getSupportActionBar().hide();

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        rc = findViewById(R.id.my_teams_recyclerview);
        opt = new Firebase_database_operations();


        String userid = auth.getUid().toString();
        Query query = opt.Retreive_Team_Data();

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Team team = dataSnapshot1.getValue(Team.class);
                    list.add(team);

                }
                adp.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(My_Teams.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        adp = new My_Teams_adapter(My_Teams.this, list);
        LinearLayoutManager mng = new LinearLayoutManager(this);
        rc.setAdapter(adp);
        rc.setLayoutManager(mng);
    }
}