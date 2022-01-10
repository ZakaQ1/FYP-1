package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.ui.Adapters.View_team_adapter;
import com.example.n_template.ui.Models.View_team_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class View_team_for_joiners extends AppCompatActivity {

    RecyclerView Rc;
    ArrayList<View_team_model> list = new ArrayList<>();
    FirebaseDatabase database;
    FirebaseAuth auth;
    View_team_adapter adp;
    Firebase_database_operations opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_team_for_joiners);

        Rc = findViewById(R.id.View_team_for_joiners_recyclerview);
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        opt = new Firebase_database_operations();

        String capt_id = getIntent().getStringExtra("team_id");

        Query query = opt.Retreive_Player_Data(capt_id);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    View_team_model model = dataSnapshot1.getValue(View_team_model.class);
                    list.add(model);

                }
                adp.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        adp = new View_team_adapter(this, list,false);
        LinearLayoutManager mng = new LinearLayoutManager(this);
        Rc.setAdapter(adp);
        Rc.setLayoutManager(mng);
    }
}
