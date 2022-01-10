package com.example.n_template.ui.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.n_template.Fragments.ReceiveRequestFragment;
import com.example.n_template.Fragments.Received_ChallengeFragments;
import com.example.n_template.Fragments.SendRequestFragment;
import com.example.n_template.Fragments.Send_ChallengeFragment;

public class Request_Fragments_Manager extends FragmentPagerAdapter {


    public Request_Fragments_Manager(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new SendRequestFragment();
            case 1: return new ReceiveRequestFragment();
            default: return new SendRequestFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        if(position==0)
        {
            title="Send";
        }
        if(position==1)
        {
            title="Received";
        }

        return title;
    }
}
