package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class DateTime extends AppCompatActivity {
    Button btn1;
    TextView t1, txt,t2;
    Spinner s1;
    DatePickerDialog.OnDateSetListener OnDateSetListener;
    Spinner s2, s3;
    ArrayAdapter adapter;
    String[] dataS1 = {"select One", "Silver: Rs.120.00 ", "Gold: Rs.150.00"};
    String[] data1 = {"How Many Seats ?","1", "2", "3","4","5","6","7","8","9","10"};
    String[] data2 = {"How Many Seats ?","1", "2", "3","4","5","6","7","8","9","10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        btn1=findViewById(R.id.btn);
        t1 = findViewById(R.id.Da);
        t2=findViewById(R.id.select1);
        txt = findViewById(R.id.select);
        s1 = findViewById(R.id.sp1);
        s2=findViewById(R.id.sp2);
        s3=findViewById(R.id.sp3);
        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, dataS1);
        s2.setAdapter(adapter);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s2.getSelectedItem().toString().equals("Silver: Rs.120.00 ")) {
                    adapter = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, data1);
                    s3.setAdapter(adapter);

                } else if (s2.getSelectedItem().toString().equals("Gold: Rs.150.00")) {
                    adapter = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, data2);
                    s3.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s2.getSelectedItem().toString().equals("Silver: Rs.120.00 ")) {
                    switch (position) {
                        case 0:
                            txt.setText("Total Rs." + 120);
                            break;
                        case 1:
                            txt.setText("Total Rs." + (1 * 120));
                            break;
                        case 2:
                            txt.setText("Total Rs." + (2 * 120));
                            break;
                        case 3:
                            txt.setText("Total Rs." + (3 * 120));
                            break;

                        case 4:
                            txt.setText("Total Rs." + (4 * 120));
                            break;
                        case 5:
                            txt.setText("Total Rs." + (5 * 120));
                            break;
                        case 6:
                            txt.setText("Total Rs." + (6 * 120));
                            break;
                        case 7:
                            txt.setText("Total Rs." + (7 * 120));
                            break;
                        case 8:
                            txt.setText("Total Rs." + (8 * 120));
                            break;
                        case 9:
                            txt.setText("Total Rs." + (9 * 120));
                            break;
                        case 10:
                            txt.setText("Total Rs." + (10 * 120));
                            break;
                    }
                } else if (s2.getSelectedItem().toString().equals("Gold: Rs.150.00")) {
                    switch (position) {
                        case 0:
                            txt.setText("Total Rs." + 150);
                            break;
                        case 1:
                            txt.setText("Total Rs." + (1 * 150));
                            break;
                        case 2:
                            txt.setText("Total Rs." + (2 * 150));
                            break;
                        case 3:
                            txt.setText("Total Rs." + (3 * 150));
                            break;
                        case 4:
                            txt.setText("Total Rs." + (4 * 150));
                            break;
                        case 5:
                            txt.setText("Total Rs." + (5 * 150));
                            break;
                        case 6:
                            txt.setText("Total Rs." + (6 * 150));
                            break;
                        case 7:
                            txt.setText("Total Rs." + (7 * 150));
                            break;
                        case 8:
                            txt.setText("Total Rs." + (8 * 150));
                            break;
                        case 9:
                            txt.setText("Total Rs." + (9 * 150));
                            break;
                        case 10:
                            txt.setText("Total Rs." + (10 * 150));
                            break;

                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Pay.class));
            }
        });

        List<String> catagories = new ArrayList<>();
        catagories.add(0, "Select Time");
        catagories.add("12:30am");
        catagories.add("3:00pm");
        catagories.add("7:00pm");
        catagories.add("9:30pm");
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, catagories);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Select Time")) {

                } else {
                    String item = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog  dialog=new DatePickerDialog(DateTime.this,android.R.style.Theme_Holo_Dialog_MinWidth,
                        OnDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        OnDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;
                t1.setText(date);
            }
        };

    }
}
