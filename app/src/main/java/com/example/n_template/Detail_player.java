package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.ui.Models.addplayer_model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Detail_player extends AppCompatActivity {

    Button back;
    //    FirebaseDatabase database;
//    FirebaseAuth auth;
    TextView name , role , age ,address , phone;
    Firebase_database_operations opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_player);
        getSupportActionBar().hide();

        name = findViewById(R.id.name_dtl_player);
        role = findViewById(R.id.role_dtl_player);
        age = findViewById(R.id.age_dtl_player);
        address = findViewById(R.id.address_dtl_player);
        phone = findViewById(R.id.phone_dtl_player);
        opt = new Firebase_database_operations();
//        auth = FirebaseAuth.getInstance();
//        database = FirebaseDatabase.getInstance();
        String playerid = getIntent().getStringExtra("playerid");

        Query query =opt.Retreive_Player_Detail(playerid);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    addplayer_model model = dataSnapshot1.getValue(addplayer_model.class);

                    name.setText(model.getPlayername());
                    role.setText(model.getRole_of_player());
                    age.setText(model.getAge());
                    phone.setText(model.getPhone_number());
                    address.setText(model.getAddress());
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        back = findViewById(R.id.btn_remove_sample_addplayer);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detail_player.this, View_team.class);
                startActivity(intent);
            }
        });
    }
}