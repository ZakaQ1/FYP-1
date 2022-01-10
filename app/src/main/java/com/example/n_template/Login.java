package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {

    Button login;
    EditText edttxt_number;
    public static String PREFS_NAME="MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        login = findViewById(R.id.btn_login_loginactivity);
        edttxt_number = findViewById(R.id.edtxt_number_login_activity);

        ProgressBar progressBar = findViewById(R.id.progress_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!edttxt_number.getText().toString().trim().isEmpty()) {
                    if((edttxt_number.getText().toString().trim()).length()==10) {

                        progressBar.setVisibility(View.VISIBLE);
                        login.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+92" + edttxt_number.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                Login.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                        progressBar.setVisibility(View.GONE);
                                        login.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        login.setVisibility(View.VISIBLE);
                                        Toast.makeText(Login.this,e.getMessage(), Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.GONE);
                                        login.setVisibility(View.VISIBLE);

                                        // Login Maintaining
                                        SharedPreferences sharedPreferences = getSharedPreferences(Login.PREFS_NAME,0);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putBoolean("hasLoggedIn",true);
                                        editor.commit();

                                        Intent intent = new Intent(Login.this, Otp_Verification.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.putExtra("mobile", edttxt_number.getText().toString());
                                        intent.putExtra("backendotp",s);
                                        startActivity(intent);

                                    }
                                }
                        );

                    }
                    else{
                        Toast.makeText(Login.this, "Please Enter Correct Number", Toast.LENGTH_SHORT).show();
                    }
                } 
                else{
                    Toast.makeText(Login.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}