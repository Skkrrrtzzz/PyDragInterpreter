package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonSyntax extends AppCompatActivity {

    Button buttonSyntaxPrev;
    Button buttonSyntaxNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_syntax);

        buttonSyntaxPrev = findViewById(R.id.btnSyntaxPrev);
        buttonSyntaxNext = findViewById(R.id.btnSyntaxNext);

        buttonSyntaxNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonSyntax.this, ExerSyntax.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonSyntaxPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonSyntax.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}
