package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.n_template.ui.Adapters.Add_player_adapter;
import com.example.n_template.ui.Models.addplayer_model;

public class Add_player extends AppCompatActivity {

    RecyclerView Rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        getSupportActionBar().hide();

        Rc = findViewById(R.id.addplayer_rc);

        java.util.ArrayList<addplayer_model> list = new java.util.ArrayList<addplayer_model>();

        list.add(new addplayer_model());
        list.add(new addplayer_model());
        list.add(new addplayer_model());
        list.add(new addplayer_model());
        list.add(new addplayer_model());

        Add_player_adapter adp = new Add_player_adapter(this, list);
        LinearLayoutManager mng = new LinearLayoutManager(this);
        Rc.setAdapter(adp);
        Rc.setLayoutManager(mng);
    }
}