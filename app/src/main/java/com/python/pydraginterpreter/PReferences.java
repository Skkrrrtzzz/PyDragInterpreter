package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PReferences extends AppCompatActivity {
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.references);

        button = findViewById(R.id.btnBack);

        button.setOnClickListener(view -> {

            Intent intent = new Intent(PReferences.this, MainActivity.class);
            startActivity(intent);
        });
    }
}