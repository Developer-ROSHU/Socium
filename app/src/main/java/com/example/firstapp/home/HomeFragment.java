package com.example.firstapp.home;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.firstapp.adapter.HomeRecyclerAdapter;
import com.example.firstapp.R;
import com.example.firstapp.core.OnItemClickListener;
import com.example.firstapp.modules.ContainerFragment;
import com.example.firstapp.modules.MemberRegistration;
import com.example.firstapp.viewmodel.HomeGridList;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView gridView;
    private List<HomeGridList> gridList = new ArrayList<>();

    public HomeFragment() {
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
        view = inflater.inflate(R.layout.fragment_home, container, false);
        gridView = view.findViewById(R.id.recyclerView);

        gridView.setHasFixedSize(true);
        gridView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        gridList.clear();
        gridList.add(new HomeGridList(R.drawable.person,"Registration"));
        gridList.add(new HomeGridList(R.drawable.ruppess,"Maintenance"));
        gridList.add(new HomeGridList(R.drawable.investment,"Expenses"));
        gridList.add(new HomeGridList(R.drawable.vendor,"Vendors"));
        gridList.add(new HomeGridList(R.drawable.letter,"Letters"));
        gridList.add(new HomeGridList(R.drawable.document,"Documents"));
        HomeRecyclerAdapter adapter = new HomeRecyclerAdapter(getContext(), gridList);
        gridView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String value) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.viewPager, new MemberRegistration(),"hello" );
                fragmentTransaction.addToBackStack(null); //this will add it to back stack
                fragmentTransaction.commit();
                Toast.makeText(getContext(), "Hello", LENGTH_SHORT).show();
            }
        });

        return view;
    }

}