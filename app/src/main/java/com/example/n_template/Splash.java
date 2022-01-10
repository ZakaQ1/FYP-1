package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n_template.ui.home.DashboardFragment;

public class Splash extends AppCompatActivity {

    TextView txt1, txt2;
    private  static int Splash_time = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        getSupportActionBar().hide();

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences(Login.PREFS_NAME,0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);

                if(hasLoggedIn)
                {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent = new Intent(Splash.this, Login.class);
                    startActivity(intent);
                    finish();
                }

            }
        },Splash_time);

        Animation myanimation = AnimationUtils.loadAnimation(Splash.this,R.anim.animation2);
        txt1.startAnimation(myanimation);

        Animation myanimation1 = AnimationUtils.loadAnimation(Splash.this,R.anim.animation1);
        txt2.startAnimation(myanimation1);


    }
}