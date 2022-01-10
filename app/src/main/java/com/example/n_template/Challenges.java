package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.n_template.ui.Adapters.FragmentsAdapter;
import com.google.android.material.tabs.TabLayout;

public class Challenges extends AppCompatActivity {

    ViewPager vpsend1;
    TabLayout tbsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        getSupportActionBar().hide();

        vpsend1 = findViewById(R.id.vp_challenges);
        tbsend = findViewById(R.id.tablyt_challenges);
        vpsend1.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        tbsend.setupWithViewPager(vpsend1);


    }
}