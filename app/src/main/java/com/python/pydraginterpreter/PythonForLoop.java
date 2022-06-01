package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonForLoop extends AppCompatActivity {

    Button buttonPrev;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_for_loop);

        buttonPrev = findViewById(R.id.btnForLoopPrev);
        buttonNext = findViewById(R.id.btnForLoopNext);

        buttonNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonForLoop.this, ExerForLoop.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonForLoop.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}