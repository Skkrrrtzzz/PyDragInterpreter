package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonComment extends AppCompatActivity {



    Button buttonPrev;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_comment);

        buttonPrev = findViewById(R.id.btnCommentPrev);
        buttonNext = findViewById(R.id.btnCommentNext);

        buttonNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonComment.this, ExerComment.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonComment.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}