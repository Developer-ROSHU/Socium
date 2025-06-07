package com.example.firstapp.modules;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.firstapp.R;
import com.example.firstapp.core.DateTimePicker;
import com.google.android.material.textfield.TextInputEditText;

public class MemberRegistration extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    private View view;
    private TextInputEditText FullName, FlatNo, BirthDate,  Occupation, Email, MobileNo, Address;
    private TextInputEditText famMemCount, dateOfJoining, dateOfPurchase,  buildArea, certNo, nomineeName, note;
    private Spinner Gender, type, propType, parkSpace;
    private String[] genderList = {"Male", "Female", "Other"};
    private String[] booleanList = {"Yes", "No"};
    private String[] propTypeList = {"1-RK", "1-BHK", "2-BHK", "3-BHK", "Villa"};
    private String[] TypeList = {"Single Owner", "Joint Owner"};

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
        view =  inflater.inflate(R.layout.fragment_member_registration, container, false);
        FullName = view.findViewById(R.id.etFullName);
        FlatNo = view.findViewById(R.id.etFlatNo);
        BirthDate = view.findViewById(R.id.etBirthDate);
        Gender = view.findViewById(R.id.etGender);
        Occupation = view.findViewById(R.id.etOccupation);
        Email = view.findViewById(R.id.etEmail);
        MobileNo = view.findViewById(R.id.etMobileNo);
        Address = view.findViewById(R.id.etAdress);
        famMemCount = view.findViewById(R.id.etFamMemCount);
        type = view.findViewById(R.id.etType);
        dateOfJoining = view.findViewById(R.id.etDateofJoinSoc);
        dateOfPurchase = view.findViewById(R.id.etPurchaseDate);
        propType = view.findViewById(R.id.etPropType);
        parkSpace = view.findViewById(R.id.etParkSpace);
        buildArea = view.findViewById(R.id.etBuiltArea);
        certNo = view.findViewById(R.id.etShareCertNo);
        nomineeName = view.findViewById(R.id.etNomineeName);
        note = view.findViewById(R.id.etNotes);

        BirthDate.setOnClickListener(this);
        dateOfPurchase.setOnClickListener(this);
        dateOfJoining.setOnClickListener(this);
        Gender.setOnItemSelectedListener(this);
        type.setOnItemSelectedListener(this);
        propType.setOnItemSelectedListener(this);
        parkSpace.setOnItemSelectedListener(this);

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, genderList);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Gender.setAdapter(genderAdapter);

        ArrayAdapter<String> propTypeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, propTypeList);
        propTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        propType.setAdapter(propTypeAdapter);

        ArrayAdapter<String> parkSpaceAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, booleanList);
        parkSpaceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parkSpace.setAdapter(parkSpaceAdapter);

        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, TypeList);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(typeAdapter);

        return  view;
    }

    @Override
    public void onClick(View v) {
        if (v.equals(BirthDate)) {
            DateTimePicker.DatePicker(getContext(),BirthDate);
        } else if (v.equals(dateOfJoining)) {
            DateTimePicker.DatePicker(getContext(),dateOfJoining);
        } else if (v.equals(dateOfPurchase)) {
            DateTimePicker.DatePicker(getContext(),dateOfPurchase);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(view.equals(Gender)) {
            Toast.makeText(getContext(), genderList[position], Toast.LENGTH_SHORT).show();
        } else if (view.equals(propType)) {
            Toast.makeText(getContext(), propTypeList[position], Toast.LENGTH_SHORT).show();
        } else if (view.equals(parkSpace)) {
            Toast.makeText(getContext(), booleanList[position], Toast.LENGTH_SHORT).show();
        } else if (view.equals(type)) {
            Toast.makeText(getContext(), TypeList[position], Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}