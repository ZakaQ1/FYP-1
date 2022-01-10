package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Virtual_Umpiring extends AppCompatActivity {
    Button next;
    EditText edttxt_virtualump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_umpiring);
        getSupportActionBar().hide();

        next = findViewById(R.id.btn_next_virtualump);
        edttxt_virtualump = findViewById(R.id.edttxt_over_virtual_umpiring);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Virtual_Umpiring.this, Select_player.class);
                startActivity(intent);
            }
        });
    }
}