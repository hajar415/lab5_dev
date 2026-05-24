package com.example.convertisseurunites;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabsPagerAdapter extends FragmentStateAdapter {

    public TabsPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0)
            return new TemperatureTab();
        else
            return new DistanceTab();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}