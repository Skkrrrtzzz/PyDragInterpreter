package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class PythonSets extends AppCompatActivity {

    Button buttonSetsPrev;
    Button buttonSetsNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_sets);

        buttonSetsPrev = findViewById(R.id.btnSetPrev);
        buttonSetsNext = findViewById(R.id.btnSetNext);

        buttonSetsNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonSets.this, ExerSets.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonSetsPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonSets.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

    }
}