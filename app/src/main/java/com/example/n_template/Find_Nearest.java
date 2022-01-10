package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.n_template.ui.Models.locations;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.n_template.databinding.ActivityFindNearestBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Find_Nearest extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityFindNearestBinding binding;
    private int FINE_LOCATION_ACCESS_REQUEST_CODE = 1001;
    private DatabaseReference reference;
    Marker currentMarker;
    Context context;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Location");
    locations loc = new locations();
    LatLng latLng;
    FirebaseAuth auth;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseReference = FirebaseDatabase.getInstance().getReference("Location");

        binding = ActivityFindNearestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Location");
        mMap = googleMap;
        enableUserLocation();

        // Add a marker in Sydney and move the camera
        LatLng pakistan = new LatLng(24.8607, 67.0011);
        mMap.addMarker(new MarkerOptions().position(pakistan).title("Marker in Pakistan"));

//



        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pakistan, 22), 5000, null);
        pakistan = new LatLng(24.864375, 67.350002);
        MarkerOptions marker = new MarkerOptions().position(pakistan).title("match");
//        marker.icon(smallMarkerIcon);
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pakistan, 15f));
        currentMarker = mMap.addMarker(marker.position(pakistan));

        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {

                currentMarker.remove();
                LatLng center = mMap.getCameraPosition().target;
                MarkerOptions m2 = new MarkerOptions();
                m2.position(center);
//                m2.icon(smallMarkerIcon);
                m2.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
                currentMarker = mMap.addMarker(m2);
                latLng = currentMarker.getPosition();
                findViewById(R.id.imageView4).setVisibility(View.INVISIBLE);

            }
        });

        mMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                currentMarker.remove();
                findViewById(R.id.imageView4).setVisibility(View.VISIBLE);
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Find_Nearest.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_send = findViewById(R.id.btn_send);
        auth = FirebaseAuth.getInstance();
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap map = new HashMap();
                map.put("ID" , auth.getUid());
                map.put("longitude" ,latLng.longitude);
                map.put("Latitude",latLng.latitude);
                String key = databaseReference.push().getKey().toString();
                FirebaseDatabase.getInstance().getReference("Location")
                        .child(auth.getUid())
                        .setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Find_Nearest.this, "Your Location is Set", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Find_Nearest.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

    private void enableUserLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION_ACCESS_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == FINE_LOCATION_ACCESS_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);

            } else {

                // do something if permission is not gr
            }
        }
    }
}