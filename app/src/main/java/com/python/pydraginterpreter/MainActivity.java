package com.python.pydraginterpreter;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends Activity {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        button1 = findViewById(R.id.btnLearnPython);
        button2 = findViewById(R.id.btnPyDragInterpreter);
        button3 = findViewById(R.id.btnReferences);

        button1.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this,MainDesign.class);
            startActivity(intent);
        });
        button2.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, MainDrag.class);
            startActivity(intent);

        });
        button3.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, PReferences.class);
            startActivity(intent);

        });
    }
}