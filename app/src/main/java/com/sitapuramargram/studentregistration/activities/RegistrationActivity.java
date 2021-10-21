package com.sitapuramargram.studentregistration.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.sitapuramargram.studentregistration.R;

import java.util.Arrays;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    private AutoCompleteTextView spYear,spDepartment;
    private Button btNext;

    private List<String> years = Arrays.asList("2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010");
    private List<String> departments =Arrays.asList("Computer","English","Mathematics");
    private String year,department;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        spYear = findViewById(R.id.act_year);
        spDepartment = findViewById(R.id.act_department);
        btNext = findViewById(R.id.bt_next);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkInput();

            }
        });

        //spinner
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, R.layout.dropdown_item, years);
        spYear.setAdapter(arrayAdapter1);

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.dropdown_item, departments);
        spDepartment.setAdapter(arrayAdapter2);

        spYear.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RegistrationActivity.this,"Select:"+ years.get(i),Toast.LENGTH_LONG).show();
                year = years.get(i);

            }
        });

        spDepartment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RegistrationActivity.this,"Select:"+ departments.get(i),Toast.LENGTH_LONG).show();

                department =departments.get(i);
            }
        });

    }

    private void checkInput() {
        if(TextUtils.isEmpty(year)){

            Toast.makeText(RegistrationActivity.this,"Please select year",Toast.LENGTH_LONG).show();

        }
        else if(TextUtils.isEmpty(department)) {

            Toast.makeText(RegistrationActivity.this,"Please select department",Toast.LENGTH_LONG).show();

        } else {

            startActivity(new Intent(RegistrationActivity.this,PersonalInformationActivity.class));
        }
    }
}