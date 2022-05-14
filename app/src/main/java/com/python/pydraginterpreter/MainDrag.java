package com.python.pydraginterpreter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainDrag extends AppCompatActivity {
    //initializing variables
    EditText editTextSampleCode;
    TextView output;
    EditText CodeArea;
    Button Run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.output);
        CodeArea = findViewById(R.id.codearea);
        Run = findViewById(R.id.run);

        //finding the ID of the Edit Text(Coding Area) kungsan mapupunta ang sample code
        editTextSampleCode = findViewById(R.id.codearea);

        //Getting the samplecode from previous activity
        String sampleTexts = getIntent().getStringExtra("samplekey");

        //Setting text to the EditText(CodingArea)
        editTextSampleCode.setText(sampleTexts);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }


        //now on click on run button we will extract code from code area data and send that data to our python script..

        Run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Python py = Python.getInstance();

                //here we call our script with the name "myscript
                PyObject pyobj = py.getModule("myscript");  //give python script name

                //and call main method inside script...//pass data here
                PyObject obj = pyobj.callAttr("main", CodeArea.getText().toString());

                //here we will set returned value of our python script to our output textview
                output.setText(obj.toString());
            }
        });


    }
}
