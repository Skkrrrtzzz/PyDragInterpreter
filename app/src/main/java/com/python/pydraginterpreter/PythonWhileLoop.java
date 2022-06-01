package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonWhileLoop extends AppCompatActivity {

    Button buttonWhileLoopPrev;
    Button buttonWhileLoopNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_while_loop);

        buttonWhileLoopPrev = findViewById(R.id.btnWhileLoopPrev);
        buttonWhileLoopNext = findViewById(R.id.btnWhileLoopNext);

        buttonWhileLoopNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating intent to navigate to the next activity
                //Next
                Intent intent = new Intent(PythonWhileLoop.this, ExerWhileLoop.class);
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });

        buttonWhileLoopPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating intent to navigate to the next activity
                //Previous
                Intent intent = new Intent(PythonWhileLoop.this, MainDesign.class);
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });
    }
}