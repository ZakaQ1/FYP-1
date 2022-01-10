package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Join_by_Age extends AppCompatActivity {

    Button limit, limit_24_32 , limit_32_onword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_by_age);
        getSupportActionBar().hide();

        limit = findViewById(R.id.btn_18_24);
        limit_24_32 = findViewById(R.id.btn_24_32);
        limit_32_onword = findViewById(R.id.btn_32_onword);

        limit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Join_by_Age.this ,Join_Team_req_list.class);
                intent.putExtra("limit","18_to_24");
                startActivity(intent);
            }
        });

        limit_24_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Join_by_Age.this ,Join_Team_req_list.class);
                intent.putExtra("limit","24_to_32");
                startActivity(intent);
            }
        });
        limit_32_onword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Join_by_Age.this ,Join_Team_req_list.class);
                intent.putExtra("limit","32_to_onword");
                startActivity(intent);
            }
        });
    }
}