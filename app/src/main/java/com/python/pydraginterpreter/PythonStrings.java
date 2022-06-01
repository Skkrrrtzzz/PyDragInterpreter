package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PythonStrings extends AppCompatActivity {


    Button buttonStringsNext,buttonStringsPrev,btnMembership,btnTryit;
    TextView sendCode,sendCodeM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_strings);

        buttonStringsPrev = findViewById(R.id.btnStringsPrev);
        buttonStringsNext = findViewById(R.id.btnStringsNext);
        sendCodeM = findViewById(R.id.send_codeM);
        sendCode = findViewById(R.id.send_code);
        btnTryit = findViewById(R.id.btnRunCode);
        btnMembership =findViewById(R.id.btnRunCodeMembership);

        //Add onclick listener if button is click
        btnMembership.setOnClickListener(view -> {
            //Getting text and converting into string
            String getCode = sendCodeM.getText().toString();

            //Creating intent to navigate to the next activity
            Intent intent = new Intent(PythonStrings.this, MainDrag.class);
            intent.putExtra("samplekey", getCode);
            startActivity(intent);
        });
        btnTryit.setOnClickListener(view -> {
            //Getting text and converting into string
            String getCode = sendCode.getText().toString();

            //Creating intent to navigate to the next activity
            Intent intent = new Intent(PythonStrings.this, MainDrag.class);
            intent.putExtra("samplekey", getCode);
            startActivity(intent);
        });

        buttonStringsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating intent to navigate to the next activity
                //Next
                Intent intent = new Intent(PythonStrings.this, ExerStrings.class);
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });

        buttonStringsPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating intent to navigate to the next activity
                //Previous
                Intent intent = new Intent(PythonStrings.this, MainDesign.class);
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });
    }
}