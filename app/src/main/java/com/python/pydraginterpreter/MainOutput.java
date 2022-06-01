package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;


public class MainOutput extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_output);
        //PYDRAG
        Intent intent = getIntent();
        String Codearea = intent.getStringExtra(MainDrag.EXTRA_CODE);
        TextView output1 =findViewById(R.id.output);
        output1.setText(Codearea);
    }

}