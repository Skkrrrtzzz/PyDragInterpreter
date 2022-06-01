package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonTuples extends AppCompatActivity {

    Button buttonTuplesPrev;
    Button buttonTuplesNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_tuples);

        buttonTuplesPrev = findViewById(R.id.btnTuplePrev);
        buttonTuplesNext = findViewById(R.id.btnTupleNext);

        buttonTuplesNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonTuples.this, ExerTuples.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonTuplesPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonTuples.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}