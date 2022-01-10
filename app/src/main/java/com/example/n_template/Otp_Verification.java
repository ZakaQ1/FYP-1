package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Otp_Verification extends AppCompatActivity {
    Button btn_verify;
    EditText edtxt_code, edtinput1, edtinput2, edtinput3, edtinput4, edtinput5, edtinput6;
    TextView view_number, resendcode;
    String codeotp;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        getSupportActionBar().hide();

        btn_verify = findViewById(R.id.btn_verify_verifyotp);
        view_number = findViewById(R.id.txtv_usernumber_otpverifcation);
        resendcode = findViewById(R.id.resendcode_otpverification);

        edtinput1 = findViewById(R.id.inputotp1);
        edtinput2 = findViewById(R.id.inputotp2);
        edtinput3 = findViewById(R.id.inputotp3);
        edtinput4 = findViewById(R.id.inputotp4);
        edtinput5 = findViewById(R.id.inputotp5);
        edtinput6 = findViewById(R.id.inputotp6);

        view_number.setText(String.format("+92-%s", getIntent().getStringExtra("mobile")));
        codeotp = getIntent().getStringExtra("backendotp");
        ProgressBar progressBar = findViewById(R.id.progress_otp_verification);

        mAuth=FirebaseAuth.getInstance();



        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!edtinput1.getText().toString().trim().isEmpty() &&
                        !edtinput2.getText().toString().trim().isEmpty() &&
                        !edtinput3.getText().toString().trim().isEmpty() &&
                        !edtinput4.getText().toString().trim().isEmpty()&&
                        !edtinput5.getText().toString().trim().isEmpty()&&
                        !edtinput6.getText().toString().trim().isEmpty())
                {
                    String entercodeotp =   edtinput1.getText().toString() +
                                            edtinput2.getText().toString() +
                                            edtinput3.getText().toString() +
                                            edtinput4.getText().toString() +
                                            edtinput5.getText().toString() +
                                            edtinput6.getText().toString();
                    if(codeotp!=null)
                    {
                        progressBar.setVisibility(View.VISIBLE);
                        btn_verify.setVisibility(View.INVISIBLE);

                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                                codeotp, entercodeotp
                        );
                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressBar.setVisibility(View.GONE);
                                        btn_verify.setVisibility(View.VISIBLE);

                                        if(task.isSuccessful())
                                        {
                                            Intent intent = new Intent(Otp_Verification.this,MainActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        }
                                        else
                                        {
                                            Toast.makeText(Otp_Verification.this, "Enter Correct Code", Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                });
                    }
                    else
                        {
                            Toast.makeText(Otp_Verification.this, "Check Internet Connection", Toast.LENGTH_SHORT).show();
                        }

                }
                else {
                    Toast.makeText(Otp_Verification.this, "Enter All Numbers", Toast.LENGTH_SHORT).show();
                }


            }
        });

        numberotpmove();
        resendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+92" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        Otp_Verification.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(Otp_Verification.this,e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String new_s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                codeotp = new_s;
                                Toast.makeText(Otp_Verification.this, "Code Send Again Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }

                );
            }
        });


    }

    private void numberotpmove() {

        edtinput1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    edtinput2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtinput2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    edtinput3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtinput3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    edtinput4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtinput4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    edtinput5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtinput5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    edtinput6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}