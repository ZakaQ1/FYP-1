package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class Set_Match extends AppCompatActivity {

    Button fnearest, fbyage, viewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_match);
        getSupportActionBar().hide();

        fnearest = findViewById(R.id.btn_findnearest_setmatch);
        fbyage = findViewById(R.id.btn_findage_setmatch);
        viewall = findViewById(R.id.btn_showall_setmatch);

        fnearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Set_Match.this, Challenge_map.class);
                startActivity(intent);
            }
        });
        fbyage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Set_Match.this, Team_list.class);
                startActivity(intent);
            }
        });
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Set_Match.this, Team_list.class);
                startActivity(intent);
            }
        });
    }
}