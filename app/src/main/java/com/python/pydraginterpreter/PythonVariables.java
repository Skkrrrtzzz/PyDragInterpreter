package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PythonVariables extends AppCompatActivity {

    //  Initialize variable for run code button
    TextView sendCode;
    Button buttonVariablesPrev,btnTryit;
    Button buttonVariablesNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_variables);

        buttonVariablesPrev = findViewById(R.id.btnVariablesPrev);
        buttonVariablesNext = findViewById(R.id.btnVariablesNext);
        //finding ID from textview(sample code)
        sendCode = findViewById(R.id.send_code);
        btnTryit = findViewById(R.id.send_button);

        //Add onclick listener if button is click
        btnTryit.setOnClickListener(view -> {
            //Getting text and converting into string
            String getCode = sendCode.getText().toString();

            //Creating intent to navigate to the next activity
            Intent intent = new Intent(PythonVariables.this, MainDrag.class);
            intent.putExtra("samplekey", getCode);
            startActivity(intent);
        });
        buttonVariablesNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating intent to navigate to the next activity
                //Next
                Intent intent = new Intent(PythonVariables.this, ExerVariables.class);
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });
        buttonVariablesPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating intent to navigate to the next activity
                //Previous
                Intent intent = new Intent(PythonVariables.this, MainDesign.class);
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });
    }
}