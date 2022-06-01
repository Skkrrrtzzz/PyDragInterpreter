package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PythonDictionary extends AppCompatActivity {

    Button buttonDictionaryPrev,btnMembership,btnTryit;
    Button buttonDictionaryNext;
    TextView sendCode,sendCodeM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_dictionary);

        buttonDictionaryPrev = findViewById(R.id.btnDictionaryPrev);
        buttonDictionaryNext = findViewById(R.id.btnDictionaryNext);
        sendCodeM = findViewById(R.id.send_codeM);
        sendCode = findViewById(R.id.send_code);
        btnTryit = findViewById(R.id.send_button);
        btnMembership =findViewById(R.id.btnRunCodeMembership);

        //Add onclick listener if button is click
        btnMembership.setOnClickListener(view -> {
            //Getting text and converting into string
            String getCode = sendCodeM.getText().toString();

            //Creating intent to navigate to the next activity
            Intent intent = new Intent(PythonDictionary.this, MainDrag.class);
            intent.putExtra("samplekey", getCode);
            startActivity(intent);
        });
        btnTryit.setOnClickListener(view -> {
            //Getting text and converting into string
            String getCode = sendCode.getText().toString();

            //Creating intent to navigate to the next activity
            Intent intent = new Intent(PythonDictionary.this, MainDrag.class);
            intent.putExtra("samplekey", getCode);
            startActivity(intent);
        });


        buttonDictionaryNext.setOnClickListener(view -> {

            //Creating intent to navigate to the next activity
            //Next
            Intent intent = new Intent(PythonDictionary.this, ExerDictionary.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });

        buttonDictionaryPrev.setOnClickListener(view -> {
            //Creating intent to navigate to the next activity
            //Previous
            Intent intent = new Intent(PythonDictionary.this, MainDesign.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        });
    }
}