package com.python.pydraginterpreter;

import android.Manifest;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainDrag extends AppCompatActivity {
    public static final String EXTRA_CODE = "com.python.pydraginterpreter.EXTRA_CODE";
    public static Object context;

    //initializing variables
    TextView textDragHere,textViewDraggable;
    LineNumberedEditText CodeArea,et_text;
    FloatingActionButton Run;
    String ListCode, TupleCode, SetCode, DictionaryCode, HelloCode,IndentationCode,CommentCode,NumberCode,NumberCode1,NumberCode2,StringCode,BooleanCode,OperatorCode;
    String fileContent = "",filepath = "",filename = "",ForCode,IfCode ,WhileCode,ElifCode, ElseCode;
    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextViewDataCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.contentToolBar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(MainDrag.this, MainActivity.class);
            startActivity(intent);
        });
        //Interpreter
        CodeArea= findViewById(R.id.codearea);
        Run = findViewById(R.id.run);
        // Initialize two String variables for storing filename and filepath
        filename = "PythonFile.py";
        filepath = "MyFileDir";

        //Numbers in lines
        //Drop Down
        textInputLayout = findViewById(R.id.menu_dropdown);
        autoCompleteTextViewDataCollection = findViewById(R.id.dropDownDC);
        textViewDraggable = findViewById(R.id.tvItemSelectedDraggable);

        //finding the ID of the Edit Text(Coding Area) kungsan mapupunta ang sample code
        et_text = findViewById(R.id.codearea);
        //Getting the samplecode from previous activity
            String sampleTexts = getIntent().getStringExtra("samplekey");
        //Setting text to the EditText(CodingArea)
        et_text.setText(sampleTexts);


        //now on click on run button we will extract code from code area data and send that data to our output area..
        Run.setOnClickListener(view -> {
            fileContent = CodeArea.getText().toString().trim();
            if(!fileContent.equals("")){
               openOutput();
            }
            else{
                // If the Text field is empty show corresponding Toast message
                DynamicToast.makeWarning(MainDrag.this, "Text field can not be empty.", Toast.LENGTH_SHORT).show();
            }
        });
        String[] itemsListData = {"Hello World!","Indentation","Comment","Number int","Number float","Number complex","Strings","Booleans","Operators","List","Tuple","Set","Dictionary","If","Else","Elif","For","While"};
        ArrayAdapter<String> itemAdapterData = new ArrayAdapter<>(MainDrag.this, R.layout.item_list, itemsListData);
        autoCompleteTextViewDataCollection.setAdapter(itemAdapterData);
        autoCompleteTextViewDataCollection.setOnItemClickListener((parent, view, position, l) -> {
            textViewDraggable.setText((String) parent.getItemAtPosition(position));
            if (textViewDraggable.getText() == "For") {
                textViewDraggable.setTag("For");
            }
            else if (textViewDraggable.getText() == "While") {
                textViewDraggable.setTag("While");
            }
            else if (textViewDraggable.getText() == "If") {
                textViewDraggable.setTag("If");
            }
            else if (textViewDraggable.getText() == "Elif") {
                textViewDraggable.setTag("Elif");
            }
            else if (textViewDraggable.getText() == "Else") {
                textViewDraggable.setTag("Else");
            }
            else if (textViewDraggable.getText() == "List") {
                    textViewDraggable.setTag("List");
            }
            else if (textViewDraggable.getText() == "Tuple") {
                    textViewDraggable.setTag("Tuple");
            }
            else if (textViewDraggable.getText() == "Set") {
                    textViewDraggable.setTag("Set");
            }
            else if (textViewDraggable.getText() == "Dictionary") {
                    textViewDraggable.setTag("Dictionary");
            }
            else if (textViewDraggable.getText() == "Hello World!") {
                textViewDraggable.setTag("Hello World!");
            }
            else if (textViewDraggable.getText() == "Comment") {
                textViewDraggable.setTag("Comment");
            }
            else if (textViewDraggable.getText() == "Indentation") {
                textViewDraggable.setTag("Indentation");
            }
            else if (textViewDraggable.getText() == "Number int") {
                textViewDraggable.setTag("Number int");
            }
            else if (textViewDraggable.getText() == "Number float") {
                textViewDraggable.setTag("Number float");
            }
            else if (textViewDraggable.getText() == "Number complex") {
                textViewDraggable.setTag("Number complex");
            }
            else if (textViewDraggable.getText() == "Strings") {
                textViewDraggable.setTag("Strings");
            }
            else if (textViewDraggable.getText() == "Booleans") {
                textViewDraggable.setTag("Booleans");
            }
            else if (textViewDraggable.getText() == "Operators") {
                textViewDraggable.setTag("Operators");
            }
        });


        //START | DRAG N DROP

        textDragHere = findViewById(R.id.codearea);

        textViewDraggable.setOnLongClickListener(longClickListener);

        textDragHere.setOnDragListener(dragListener);

        //Sample prepared code
        ForCode = "\n#For Loop\nfor a in range(5): \n    print(a)";
        WhileCode = "\n#While Loop\na = 0\nwhile a < 10 :\n    print(a)\n    a+=1";
        IfCode = "\n#if statement\nnum = 25\nif num > 15:\n    print(\"num is greater than 15\")";
        ElifCode = "\n#elif statement\nnum = 25\nif num < 15:\n    print(\"num is greater than 15\")\nelif num < 50: \n    print(\"num is less than 50\")";
        ElseCode = "\n#else statement\nnum = 25\nif num == 15:\n    print(\"num is equal to 15\")\nelse: \n    print(\"num is not equal to 15\")";
        ListCode = "\nmyList = [ \"ListItem1\", \"ListItem2\", \"ListItem3\" ]";
        TupleCode = "\nmyTuple = ( \"TupleItem1\", \"TupleItem2\", \"TupleItem3\" )";
        SetCode = " \nmySet = { \"SetItem1\", \"SetItem2\", \"SetItem3\" }";
        DictionaryCode = " \nmyDictionary = { \"Key1\" : \"Value1\",  \"Key2\" : \"Value2\", \"Key3\" : \"Value3\" }";
        HelloCode="\nprint (\"Hello World!\")";
        IndentationCode="\nif True: \n   print(\"Hello\")";
        CommentCode="\n#This is Comment!";
        NumberCode="\n#This is int\na = 10\nprint(a, \"is of type\", type(a))";
        NumberCode1="\n#This is float\na = 7.0\nprint(a, \"is of type\", type(a))";
        NumberCode2="\n#This is complex\na = 3.14j\nprint(a, \"is of type\", type(a))";
        StringCode="\nyour_string = 'Single Quote String'\nprint(your_string)\nyour_string = \"Double Quote String\"\nprint(your_string)";
        BooleanCode="\n#True or False\nprint(20 > 22)\nprint(20 == 22)\nprint(20 < 22)";
        OperatorCode="\na=14\nb=6\nprint('a + b =',a+b)\nprint('a > b is',a>b)";

    }
    public void openOutput(){
        //PYDRAG
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject pyobj = py.getModule("pythonscript");
        PyObject obj = pyobj.callAttr("main",CodeArea.getText().toString());
        Intent intent =new Intent(this,MainOutput.class);
        intent.putExtra(EXTRA_CODE,obj.toString());
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_list, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Save:
                // Get the input from EditText
                fileContent = CodeArea.getText().toString().trim();
                // Check for Storage Permission
                if (isStoragePermissionGranted()) {
                    // If input is not empty, we'll proceed
                    if (!fileContent.equals("")) {
                        // To access app-specific files from external storage, you can call
                        // getExternalFilesDir() method. It returns the path to
                        // storage > self > Android > data > [package_name] > files > MyFileDir
                        // directory on the SD card. Once the app is uninstalled files here also get
                        // deleted.
                        // Create a File object like this.
                        File myExternalFile = new File(getExternalFilesDir(filepath), filename);
                        // Create an object of FileOutputStream for writing data to myFile.txt
                        FileOutputStream fos;
                        try {
                            // Instantiate the FileOutputStream object and pass myExternalFile in constructor
                            fos = new FileOutputStream(myExternalFile);
                            // Write to the file
                            fos.write(fileContent.getBytes());
                            // Close the stream
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // Clear the EditText
                        CodeArea.setText("");
                        // Show a Toast message to inform the user that the operation has been successfully completed.
                        DynamicToast.makeSuccess(MainDrag.this, "Android/data/com.python.pydraginterpreter/files/MyFilDir/" + filename, Toast.LENGTH_LONG).show();
                    } else {
                        // If the Text field is empty show corresponding Toast message
                        DynamicToast.makeError(MainDrag.this, "No Text to be saved.", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            case R.id.Load:
                // Create a FileReader object reference. FileReader is typically suitable for reading
                // streams of characters.
                // For reading streams of raw bytes, you can use a FileInputStream.
                FileReader fr = null;
                File myExternalFile = new File(getExternalFilesDir(filepath), filename);
                // Instantiate a StringBuilder object. This class is an alternative to String Class
                // and it is mutable, has methods such as append(), insert(), or replace() that allow to
                // modify strings. Hence it is more efficient.
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    // Instantiate the FileReader object and pass myExternalFile in the constructor
                    fr = new FileReader(myExternalFile);
                    // Instantiate a BufferedReader object and pass FileReader object in constructor.
                    // The BufferedReader maintains an internal buffer and can be used with different
                    // types of readers to read text from an Input stream more efficiently.
                    BufferedReader br = new BufferedReader(fr);
                    // Next, call readLine() method on BufferedReader object to read a line of text.
                    String line = br.readLine();
                    // Use a while loop to read the entire file
                    while (line != null) {
                        // Append the line read to StringBuilder object. Also, append a new-line
                        stringBuilder.append(line).append('\n');
                        // Again read the next line and store in variable line
                        line = br.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // Convert the StringBuilder content into String and add text "File contents\n"
                    // at the beginning.
                    String fileContents = stringBuilder.toString();
                    // Set the TextView with fileContents
                    CodeArea.setText(fileContents);
                }
                return true;
            case R.id.Exit:
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("PYDRAG")
                        .setMessage("Are you sure you want to close this Console?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean isStoragePermissionGranted () {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S_V2) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                //Permission is granted
                return true;
            } else {
                //Permission is revoked
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else {
            return true;
        }
    }
    //PARA SA PANG HOLD NG TEXT
    View.OnLongClickListener longClickListener = v -> {
        ClipData data = ClipData.newPlainText("", "");
        View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
        v.startDrag(data, myShadowBuilder, v, 0);
        return true;
    };

    //PARA SA PANDRAG
    final View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getTag() == "For") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + ForCode);
                    }
                    if (view.getTag() == "While") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + WhileCode);
                    }
                    if (view.getTag() == "If") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + IfCode);
                    }
                    if (view.getTag() == "Elif") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + ElifCode);
                    }
                    if (view.getTag() == "Else") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + ElseCode);
                    }
                    if (view.getTag() == "List") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + ListCode);
                    }
                    if (view.getTag() == "Tuple") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + TupleCode);
                    }
                    if (view.getTag() == "Set") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + SetCode);
                    }
                    if (view.getTag() == "Dictionary") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + DictionaryCode);
                    }
                    if (view.getTag() == "Hello World!") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + HelloCode);
                    }
                    if (view.getTag() == "Comment") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + CommentCode);
                    }
                    if (view.getTag() == "Indentation") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + IndentationCode);
                    }
                    if (view.getTag() == "Number int") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + NumberCode);
                    }
                    if (view.getTag() == "Number float") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + NumberCode1);
                    }
                    if (view.getTag() == "Number complex") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + NumberCode2);
                    }
                    if (view.getTag() == "Strings") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + StringCode);
                    }
                    if (view.getTag() == "Booleans") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + BooleanCode);
                    }
                    if (view.getTag() == "Operators") {
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        CharSequence currentData = item.getText();
                        textDragHere.append(currentData.toString() + OperatorCode);
                    }
                    break;
            }
            return true;
        }
        //END | DRAG N DROP
    };

}

