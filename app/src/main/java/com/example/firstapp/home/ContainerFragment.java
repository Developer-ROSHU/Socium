package com.example.firstapp.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstapp.HomeActivity;
import com.example.firstapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ContainerFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public ContainerFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_container, container, false);
        tabLayout = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.viewPager);

        TabViewPagerAdapter tabViewPagerAdapter =new TabViewPagerAdapter(getParentFragmentManager(), FragmentPagerAdapter.POSITION_NONE);
        tabViewPagerAdapter.addFragment(new HomeFragment(),"HOME");
        tabViewPagerAdapter.addFragment(new MasterFragment(),"MASTER");
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(tabViewPagerAdapter);
        tabViewPagerAdapter.notifyDataSetChanged();

        return view;
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