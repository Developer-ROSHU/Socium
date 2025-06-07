package com.example.firstapp.core;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimePicker {
    public static void DatePicker(Context context, TextInputEditText editText){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        long now =c.getTimeInMillis();
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                view.setMinDate(now);
               String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
               editText.setText(DateTimePicker.ConvertDateTime("dd/MM/yyyy", "dd/MM/yyyy", date,context));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public static String ConvertDateTime(String dateFormatBefore, String dateFormatAfter, String value, Context context){
        try {
            SimpleDateFormat s1 = new SimpleDateFormat(dateFormatBefore, Locale.ENGLISH);
            Date date = s1.parse(value);
            SimpleDateFormat s2 = new SimpleDateFormat(dateFormatAfter, Locale.ENGLISH);
            String result = s2.format(date);
            return result;
        } catch (ParseException e) {
            Toast.makeText(context, "Error while converting Date", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
