package com.example.firstapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.models.HomeGridList;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView welcomeText;
    private RecyclerView gridView;
    private List<HomeGridList> gridList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridView = findViewById(R.id.recyclerView);

        gridView.setHasFixedSize(true);
        gridView.setLayoutManager(new GridLayoutManager(this, 2));


        gridList.add(new HomeGridList(R.drawable.person,"Registration"));
        gridList.add(new HomeGridList(R.drawable.ruppess,"Maintenance"));
        gridList.add(new HomeGridList(R.drawable.investment,"Expenses"));
        gridList.add(new HomeGridList(R.drawable.vendor,"Vendors"));
        gridList.add(new HomeGridList(R.drawable.letter,"Letters"));
        gridList.add(new HomeGridList(R.drawable.document,"Documents"));
        HomeRecyclerAdapter homeGridAdapter = new HomeRecyclerAdapter(getApplication(),gridList);
        gridView.setAdapter(homeGridAdapter);


        // Logout functionality
//        logoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.clear();
//                editor.apply();
//
//                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

}
