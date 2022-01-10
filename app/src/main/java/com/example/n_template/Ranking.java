package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Ranking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        getSupportActionBar().hide();
    }
}