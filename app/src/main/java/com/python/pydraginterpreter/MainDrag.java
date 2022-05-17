package com.python.pydraginterpreter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.google.android.material.textfield.TextInputLayout;

public class MainDrag extends AppCompatActivity {
    //initializing variables
    EditText editTextSampleCode;
    TextView output,textDragHere;
    EditText CodeArea;
    Button Run;
    String ForLoopCode, IfElseCode;
    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;
    TextView textViewDraggable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.output);
        CodeArea = findViewById(R.id.codearea);
        Run = findViewById(R.id.run);
        textInputLayout = findViewById(R.id.menu_dropdown);
        autoCompleteTextView = findViewById(R.id.dropDownItems);
        textViewDraggable = findViewById(R.id.tvItemSelectedDraggable);

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

        String[] itemsList = {"For Loop", "If Else",};
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(MainDrag.this, R.layout.item_list, itemsList);
        autoCompleteTextView.setAdapter(itemAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                textViewDraggable.setText((String) parent.getItemAtPosition(position));

                if (textViewDraggable.getText() == "For Loop") {
                    textViewDraggable.setTag("For Loop");
                }
                else if (textViewDraggable.getText() == "If Else") {
                    textViewDraggable.setTag("If Else");
                }
            }
        });


        //START | DRAG N DROP

        textDragHere = (EditText) findViewById(R.id.codearea);

        textViewDraggable.setOnLongClickListener(longClickListener);

        textDragHere.setOnDragListener(dragListener);

        //Sample prepared code
        ForLoopCode = "\nfruits = ['apple', 'banana', 'cherry']\nfor x in fruits\n  print(x)";

        IfElseCode = "\na = 33\n b = 200\n if b > a:\n  print('b is greater than a')";

    }

    //PARA SA PANG HOLD NG TEXT
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }
    };

    //PARA SA PANDRAG
    final View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getTag() == "For Loop") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + ForLoopCode);
                    }
                    if (view.getTag() == "If Else") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + IfElseCode);
                    }


                    break;
            }

            return true;
        }

        //END | DRAG N DROP
    };
}
