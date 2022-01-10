package com.example.n_template;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.LauncherActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.ui.Models.addplayer_model;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Create_player extends AppCompatActivity {

    Button done, seeplayer, back;
    EditText name, phone, address, age, role;
    ImageView profile_img;
    //    DatabaseReference database_Teams;
    Firebase_database_operations database_operation;
    FirebaseStorage storage;
    FirebaseDatabase database;
    //    StorageReference storageReference;
    //ProgressDialog progressDialog;
    FloatingActionButton btn_upload;
    //    ActivityResultLauncher<String> launcher;
    public Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_player);
        getSupportActionBar().hide();

        profile_img = findViewById(R.id.profile_image_createplayer);
//        storageReference = storage.getReference();

        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

        //ProDialogs
//        progressDialog = new ProgressDialog(Create_player.this);
//        progressDialog.setTitle("Uploading Image");
//        progressDialog.setMessage("Your Image is adding into your profile");

        //buttons
        done = findViewById(R.id.btn_edit_sample_addplayer);
        seeplayer = findViewById(R.id.btn_seeplayer_crateplayer);
        back = findViewById(R.id.btn_remove_sample_addplayer);
        btn_upload = findViewById(R.id.btn_floating_action_createplayer);
        //textview
        role = findViewById(R.id.edttxt_role_createplayer);
        name = findViewById(R.id.edttxt_name_createplayer);
        phone = findViewById(R.id.edttxt_phone_createplayer);
        address = findViewById(R.id.edttxt_address_createplayer);
        age = findViewById(R.id.edttxt_age_createplayer);


        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {

                        if (result != null) {

                            profile_img.setImageURI(result);
                            imageUri = result;
                        }
                    }
                });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mGetContent.launch("image/*");

            }
        });

        seeplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Create_player.this, Add_player.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Create_player.this, Create_Team.class);
                startActivity(intent);
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                addplayer_model player = new addplayer_model(name.getText().toString(), phone.getText().toString(), age.getText().toString(), address.getText().toString(), role.getText().toString());
//                database_operation = new Firebase_database_operations();
//                database_operation.Add_player(player);
                if (imageUri != null) {
                    StorageReference reference = storage.getReference().child("image/" + UUID.randomUUID().toString());
                    reference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()) {

                                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        addplayer_model player = new addplayer_model(name.getText().toString(), phone.getText().toString(), Integer.parseInt(age.getText().toString()), address.getText().toString(), role.getText().toString(), uri.toString());
                                        database_operation = new Firebase_database_operations();
                                        database_operation.Add_player(player);

                                    }
                                });
                            }
                            else {
                                Toast.makeText(Create_player.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{

                    addplayer_model player2 = new addplayer_model(name.getText().toString(), phone.getText().toString(),Integer.parseInt(age.getText().toString()), address.getText().toString(), role.getText().toString());
                    database_operation = new Firebase_database_operations();
                    database_operation.Add_player(player2);
                }



            }
        });



    }
}

