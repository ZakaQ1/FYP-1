package com.example.n_template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.n_template.Fragments.ReceiveRequestFragment;
import com.example.n_template.Fragments.Received_ChallengeFragments;
import com.example.n_template.Fragments.SendRequestFragment;
import com.example.n_template.Fragments.Send_ChallengeFragment;
import com.example.n_template.ui.Adapters.FragmentsAdapter;
import com.example.n_template.ui.Adapters.Request_Fragments_Manager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Request extends AppCompatActivity {

    ViewPager2 viewPager2_request;
    TabLayout tbsend;
    private String title [] = {"Send", "Receive"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        getSupportActionBar().hide();

        viewPager2_request = findViewById(R.id.vp_request);
        viewPager2_request.setAdapter(
                new SampleAdapter(this)
        );

        tbsend = findViewById(R.id.tablyt_request);
        new TabLayoutMediator(
                tbsend,
                viewPager2_request,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(title[position]);
                    }
                }
        ).attach();

    }
    class SampleAdapter extends FragmentStateAdapter
    {

        public SampleAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        public SampleAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        public SampleAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new SendRequestFragment();
                case 1:
                    return new ReceiveRequestFragment();
                default: return new SendRequestFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

}