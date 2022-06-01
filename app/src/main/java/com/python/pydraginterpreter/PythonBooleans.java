package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class PythonBooleans extends AppCompatActivity {


    Button buttonPrev;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_booleans);

        buttonPrev = findViewById(R.id.btnBooleansPrev);
        buttonNext = findViewById(R.id.btnBooleansNext);

        buttonNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonBooleans.this, PythonBasicOperators.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonBooleans.this, PythonStrings.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}