package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class Select_player extends AppCompatActivity {

    Button start;
    Spinner bowler,batsmanA,batsmanB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);
        getSupportActionBar().hide();

        start=findViewById(R.id.btn_start_selectplayer);
        bowler=findViewById(R.id.spinner_bowler_selectplayer);
        batsmanA=findViewById(R.id.spinner_batsmanA_selectplayer);
        batsmanB=findViewById(R.id.spinner_batsmanB_selectplayer);

        String[] value = {"Select Bowler","Tuaha", "Zaka", "Nadeem", "Zulfiqar"};
        ArrayList<String> arraylist = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.style_spinner,arraylist);
        bowler.setAdapter(arrayAdapter);

        String[] value1 = {"Select BatsmanA","Zaka","Aqib","Ikram","Ejaz"};
        ArrayList<String> arraylist1 = new ArrayList<>(Arrays.asList(value1));
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,R.layout.style_spinner,arraylist1);
        batsmanA.setAdapter(arrayAdapter1);

        String[] value2 = {"Select BatsmanB","A","B","C","D"};
        ArrayList<String> arraylist2 = new ArrayList<>(Arrays.asList(value2));
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,R.layout.style_spinner,arraylist2);
        batsmanB.setAdapter(arrayAdapter2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Select_player.this, Umpiring.class);
                startActivity(intent);
            }
        });
    }
}