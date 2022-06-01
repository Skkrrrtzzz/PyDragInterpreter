package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonNumbers extends AppCompatActivity {

    Button buttonNumbersPrev;
    Button buttonNumbersNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_numbers);

        buttonNumbersPrev = findViewById(R.id.btnNumbersPrev);
        buttonNumbersNext = findViewById(R.id.btnNumbersNext);

        buttonNumbersNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating intent to navigate to the next activity
                //Next
                Intent intent = new Intent(PythonNumbers.this, ExerNumbers.class);
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });

        buttonNumbersPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating intent to navigate to the next activity
                //Previous
                Intent intent = new Intent(PythonNumbers.this, MainDesign.class);
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });
    }
}