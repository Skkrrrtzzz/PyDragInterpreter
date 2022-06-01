package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonIntro extends AppCompatActivity {



    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_intro);

        buttonNext = findViewById(R.id.btnIntroNext);

        buttonNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            Intent intent = new Intent(PythonIntro.this, PythonSyntax.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}