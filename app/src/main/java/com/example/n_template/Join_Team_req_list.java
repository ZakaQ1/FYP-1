package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.ui.Adapters.join_team_list_adapter;
import com.example.n_template.ui.Models.Join_team_model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Join_Team_req_list extends AppCompatActivity {

    RecyclerView Rc;
    Firebase_database_operations opt ;
    join_team_list_adapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_team_req_list);
        getSupportActionBar().hide();

        opt = new Firebase_database_operations();
        Rc = findViewById(R.id.join_team_list_recyclerview);

        ArrayList<Join_team_model> list = new ArrayList<>();

        Query query = opt.Retreive_Team_List();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Join_team_model join_team = dataSnapshot1.getValue(Join_team_model.class);
                    list.add(join_team);

                }
                adp.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        adp = new join_team_list_adapter(this, list);
        LinearLayoutManager mng = new LinearLayoutManager(this);
        Rc.setAdapter(adp);
        Rc.setLayoutManager(mng);
    }
}