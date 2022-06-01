package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonIfElse extends AppCompatActivity {

    Button buttonIfElsePrev;
    Button buttonIfElseNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_if_else);

        buttonIfElsePrev = findViewById(R.id.btnIfElsePrev);
        buttonIfElseNext = findViewById(R.id.btnIfElseNext);

        buttonIfElseNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonIfElse.this, ExerIfElse.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonIfElsePrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonIfElse.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

    }
}