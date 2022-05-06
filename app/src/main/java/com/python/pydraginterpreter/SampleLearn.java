package com.python.pydraginterpreter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.python.pydraginterpreter.databinding.ActivitySampleLearnBinding;

public class SampleLearn extends DrawerBase {

    //  Initialize variable
    Button btnTryit;
    TextView sendCode;
    ActivitySampleLearnBinding activitySampleLearnBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activitySampleLearnBinding = ActivitySampleLearnBinding.inflate(getLayoutInflater());
        setContentView(activitySampleLearnBinding.getRoot());
        allocateActivityTitle("Sample Learn");

        setContentView(R.layout.activity_sample_learn);

        //finding ID from textview(sample code)
        sendCode = findViewById(R.id.send_code);
        btnTryit = findViewById(R.id.send_button);

        //Add onclick listener if button is click
        btnTryit.setOnClickListener(view -> {
            //Getting text and converting into string
            String getCode = sendCode.getText().toString();

            //Creating intent to navigate to the next activity
            Intent intent = new Intent(SampleLearn.this,MainDrag.class);
            intent.putExtra("samplekey", getCode);
            startActivity(intent);
        });
    }
}