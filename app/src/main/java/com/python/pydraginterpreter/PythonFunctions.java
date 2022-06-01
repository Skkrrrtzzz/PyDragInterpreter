package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonFunctions extends AppCompatActivity {

    Button buttonFunctionsPrev;
    Button buttonFunctionsNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_functions);

        buttonFunctionsPrev = findViewById(R.id.btnFunctionPrev);
        buttonFunctionsNext = findViewById(R.id.btnFunctionNext);

        buttonFunctionsNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonFunctions.this, ExerFunctions.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonFunctionsPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonFunctions.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}