package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class PythonBasicOperators extends AppCompatActivity {



    Button buttonPrev;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_basic_operators);

        buttonPrev = findViewById(R.id.btnBasicOperatorsPrev);
        buttonNext = findViewById(R.id.btnBasicOperatorsNext);

        buttonNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonBasicOperators.this, PythonLists.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonBasicOperators.this, PythonBooleans.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}