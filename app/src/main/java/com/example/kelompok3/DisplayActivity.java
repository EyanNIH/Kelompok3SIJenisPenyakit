package com.example.kelompok3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.kelompok3.databinding.ActivityDisplayBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DisplayActivity extends AppCompatActivity {
    private ActivityDisplayBinding binding;
    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {
                        case R.id.navigation_home: fragment = new HomeFragment();
                            switchFragment(fragment);
                            return true;
                        case R.id.navigation_list: fragment = new ListFragment();
                            switchFragment(fragment);
                            return true;
                        case R.id.navigation_information: fragment = new InformationFragment();
                            switchFragment(fragment);
                            return true;
                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if(savedInstanceState == null) {
            binding.navigation.setSelectedItemId(R.id.navigation_home);
        }
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}