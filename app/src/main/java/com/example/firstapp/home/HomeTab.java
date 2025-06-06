package com.example.firstapp.home;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.firstapp.R;
import com.example.firstapp.modules.MemberRegistration;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class HomeTab extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        TabViewPagerAdapter tabViewPagerAdapter =new TabViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.POSITION_NONE);
        tabViewPagerAdapter.addFragment(new HomeFragment(),"HOME");
        tabViewPagerAdapter.addFragment(new MasterFragment(),"MASTER");
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(tabViewPagerAdapter);
        tabViewPagerAdapter.notifyDataSetChanged();

    }

    public class TabViewPagerAdapter extends FragmentPagerAdapter{
        int tabCount ;
        private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        private final ArrayList<String> titleArrayList = new ArrayList<>();
        public TabViewPagerAdapter(@NonNull FragmentManager fm, int count) {
            super(fm, count);
            this.tabCount = count;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 :
                    HomeFragment homeFragment = new HomeFragment();
                    return homeFragment;
                case 1:
                    MasterFragment masterFragment = new MasterFragment();
                    return masterFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }
        public void addFragment(Fragment fragment, String string){
            fragmentArrayList.add(fragment);
            titleArrayList.add(string);
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleArrayList.get(position);
        }

    }
}