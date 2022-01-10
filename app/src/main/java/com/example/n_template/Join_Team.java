package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Join_Team extends AppCompatActivity {

    Button joinnearest, joinage, showall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_team);
        getSupportActionBar().hide();

        joinnearest = findViewById(R.id.btn_join_nearest);
        joinage = findViewById(R.id.btn_join_by_age);
        showall = findViewById(R.id.btn_show_all);
        /// checl

        joinnearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Join_Team.this, Join_Team_req_list.class);
                startActivity(intent);
            }
        });
        joinage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Join_Team.this, Join_by_Age.class);
                startActivity(intent);
            }
        });
        showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Join_Team.this, Join_Team_req_list.class);
                startActivity(intent);
            }
        });




    }
}