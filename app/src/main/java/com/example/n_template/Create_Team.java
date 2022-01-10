package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.n_template.Database.Firebase_database_operations;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Arrays;

public class Create_Team extends AppCompatActivity {
    Button create,back;
    Spinner spn_strength, spn_type;
    EditText team_name;
    Firebase_database_operations database_operation;
    DatabaseReference database_teams;
   // ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
        getSupportActionBar().hide();

        //ProDialogs
//        progressDialog = new ProgressDialog(Create_Team.this);
//        progressDialog.setTitle("Creating Team");
//        progressDialog.setMessage("Please wait while your team create");

        create = findViewById(R.id.btn_create_createteam);
        back = findViewById(R.id.btn_back_createteam);
        spn_strength = findViewById(R.id.spinner_strength_createteam);
        spn_type = findViewById(R.id.spinner_type_createteam);
        team_name= findViewById(R.id.team_name_create_team);

        String[] value = {"Select Strength","1","2","3","4","5","6","7","8","9","10","11"};
        ArrayList<String> arraylist = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.style_spinner,arraylist);
        spn_strength.setAdapter(arrayAdapter);

        String[] value1 = {"Select Type", "Tape Ball", "Hard Ball"};
        ArrayList<String> arraylist1 = new ArrayList<>(Arrays.asList(value1));
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,R.layout.style_spinner,arraylist1);
        spn_type.setAdapter(arrayAdapter1);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Team team = new Team(team_name.getText().toString(),spn_strength.getSelectedItem().toString(),spn_type.getSelectedItem().toString());
                database_operation = new Firebase_database_operations();
                database_operation.create_team(team);

                // move
                Intent intent = new Intent(Create_Team.this, Create_player.class);
                startActivity(intent);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Create_Team.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}