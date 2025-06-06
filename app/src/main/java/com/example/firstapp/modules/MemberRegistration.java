package com.example.firstapp.modules;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firstapp.R;

public class MemberRegistration extends Fragment {
    private View view;

    public MemberRegistration() {
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
        return inflater.inflate(R.layout.fragment_member_registration, container, false);
//        Toast.makeText(getContext(), "Roshu", Toast.LENGTH_SHORT).show();
    }
}