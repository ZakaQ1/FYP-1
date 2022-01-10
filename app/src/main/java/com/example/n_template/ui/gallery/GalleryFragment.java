package com.example.n_template.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.R;
import com.example.n_template.databinding.FragmentGalleryBinding;
import com.example.n_template.ui.Models.addplayer_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    Button back;
    Firebase_database_operations opt;
    FirebaseAuth auth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        back = root.findViewById(R.id.btn_remove_sample_addplayer);

        auth = FirebaseAuth.getInstance();
        String capt_id = auth.getUid();
        opt = new Firebase_database_operations();
        Query query = opt.Retreive_Player_Data(capt_id);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    addplayer_model model = dataSnapshot1.getValue(addplayer_model.class);
                    binding.fragGalryAddress.setText(model.getAddress());
                    binding.fragGalryAge.setText(model.getAge());
                    binding.fragGalryName.setText(model.getPlayername());
                    binding.fragGalryRole.setText(model.getRole_of_player());
                    binding.fragGalryPhone.setText(model.getPhone_number());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        binding.btnEditGalleryFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DashboardFragment.class);
//                startActivity(intent);
//            }
//        });

//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}