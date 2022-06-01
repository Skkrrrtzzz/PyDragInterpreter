package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonLists extends AppCompatActivity {

    Button buttonListsPrev;
    Button buttonListsNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_lists);


        buttonListsPrev = findViewById(R.id.btnListPrev);
        buttonListsNext = findViewById(R.id.btnListNext);

        buttonListsNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonLists.this, ExerLists.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonListsPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonLists.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}