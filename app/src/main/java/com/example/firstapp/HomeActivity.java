package com.example.firstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView welcomeText;
    //private Button logoutButton;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize Views
        welcomeText = findViewById(R.id.textView3);
        gridView = findViewById(R.id.gridView);

        // Fetch user name dynamically
        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String username = preferences.getString("username", "User");
        welcomeText.setText("Welcome, " + username + "!");

        ImageAdapter imageAdapter = new ImageAdapter(getApplication());
        gridView.setAdapter(imageAdapter);


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
