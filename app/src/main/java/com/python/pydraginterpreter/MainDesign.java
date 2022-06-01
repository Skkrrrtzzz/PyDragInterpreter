package com.python.pydraginterpreter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainDesign extends AppCompatActivity {

    TextView textview_score;
    TextView PyAbout, PySyntax, PyComment, PyVariables, PyDataTypes, PyNumbers, PyStrings, PyBooleans, PyBasicOperators,
            PyLists, PySets, PyTuples, PyDictionaries, PyIfElse, PyForLoop, PyWhileLoop, PyFunction, PyArray;
    TextView btnTakePyIntroQuiz, btnTakePyQuiz2, btnTakePyQuiz3;
    ImageButton button;

    int currentScore;

    SharedPreferences sharedPreferences;

    public static String SHARED_PREF_NAME = "mypref";

    //CREATE KEY AND VALUE
    //public static String KEY_SCORE= "score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_design);
        button = findViewById(R.id.btnBack);

        button.setOnClickListener(view -> {

            Intent intent = new Intent(MainDesign.this,MainActivity.class);
            startActivity(intent);
        });


        PyAbout = findViewById(R.id.idPyIntroAbout);
        PySyntax = findViewById(R.id.idPyIntroSyntaxIndent);
        PyComment = findViewById(R.id.idPyIntroComment);
        PyVariables = findViewById(R.id.idPyIntroVariables);
        PyDataTypes = findViewById(R.id.idPyIntroDataTypes);
        btnTakePyIntroQuiz = findViewById(R.id.idTakePyIntroQuiz);
        PyNumbers = findViewById(R.id.idPyNumbers);
        PyStrings = findViewById(R.id.idPyStrings);
        PyIfElse = findViewById(R.id.idPyIfElse);
        PyForLoop = findViewById(R.id.idPyForLoops);
        PyWhileLoop = findViewById(R.id.idPyWhileLoops);
        btnTakePyQuiz2 = findViewById(R.id.idTakePyIntroQuizTwo);
        PyLists = findViewById(R.id.idPyLists);
        PyTuples = findViewById(R.id.idPyTuples);
        PySets = findViewById(R.id.idPySets);
        PyDictionaries = findViewById(R.id.idPyDictionaries);
        PyFunction = findViewById(R.id.idPyFunctions);
        PyArray = findViewById(R.id.idPyArrays);

        textview_score = findViewById(R.id.idCurrent);


        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        currentScore = sharedPreferences.getInt("score", 0);
        textview_score.setText(""+ currentScore);



        //      DRAWABLE ICON WILL SET IF THEY COMPLETED THE TASK
        Drawable drawableCheck = getResources().getDrawable(R.drawable.ic_check_circle);
        Drawable drawableLockOpen = getResources().getDrawable(R.drawable.ic_lock_open);

        //        IF CURRENSCORE IS 1, UNLOCKED PYTHON SYNTAX & INDENTATION
        if (currentScore >= 1) {
            PySyntax.setEnabled(true);
            PySyntax.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PySyntax.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 2, UNLOCKED PYTHON COMMENT
        if (currentScore >= 2) {
            PyComment.setEnabled(true);
            PyComment.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyComment.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 3, UNLOCKED PYTHON VARIABLES
        if (currentScore >= 3) {
            PyVariables.setEnabled(true);
            PyVariables.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyVariables.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 4, UNLOCKED DATA TYPES
        if (currentScore >= 4) {
            PyDataTypes.setEnabled(true);
            PyDataTypes.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyDataTypes.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 5, UNLOCKED QUIZ ONE
        if (currentScore >= 5) {
            btnTakePyIntroQuiz.setEnabled(true);
            btnTakePyIntroQuiz.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableLockOpen, null);
            btnTakePyIntroQuiz.setTextColor(Color.parseColor("#ffffff"));
        }


        //        IF CURRENSCORE IS 6, UNLOCKED PPYTHON NUMBERS
        if (currentScore >= 6) {
            PyNumbers.setEnabled(true);
            PyNumbers.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyNumbers.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 7, UNLOCKED QPYTHON STRINGS
        if (currentScore >= 7) {
            PyStrings.setEnabled(true);
            PyStrings.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyStrings.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 8, UNLOCKED PYTHON IF ELSE
        if (currentScore >= 8) {
            PyIfElse.setEnabled(true);
            PyIfElse.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyIfElse.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 9, UNLOCKED PYTHON FOR LOOP
        if (currentScore >= 9) {
            PyForLoop.setEnabled(true);
            PyForLoop.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyForLoop.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 10, UNLOCKED PYTHON WHILE LOOP
        if (currentScore >= 10) {
            PyWhileLoop.setEnabled(true);
            PyWhileLoop.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyWhileLoop.setTextColor(Color.parseColor("#ffffff"));
        }

        if (currentScore >= 11) {
            btnTakePyQuiz2.setEnabled(true);
            btnTakePyQuiz2.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableLockOpen, null);
            btnTakePyQuiz2.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 12, UNLOCKED PYTHON LISTS
        if (currentScore >= 12) {
            PyLists.setEnabled(true);
            PyLists.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyLists.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 12, UNLOCKED PYTHON TUPLES
        if (currentScore >= 13) {
            PyTuples.setEnabled(true);
            PyTuples.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyTuples.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 12, UNLOCKED PYTHON SETS
        if (currentScore >= 14) {
            PySets.setEnabled(true);
            PySets.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PySets.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 12, UNLOCKED PYTHON DICTIONARIES
        if (currentScore >= 15) {
            PyDictionaries.setEnabled(true);
            PyDictionaries.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyDictionaries.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 12, UNLOCKED PYTHON FUNCTION
        if (currentScore >= 16) {
            PyFunction.setEnabled(true);
            PyFunction.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyFunction.setTextColor(Color.parseColor("#ffffff"));
        }

        //        IF CURRENSCORE IS 12, UNLOCKED PYTHON ARRAY
        if (currentScore >= 17) {
            PyArray.setEnabled(true);
            PyArray.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableCheck, null);
            PyArray.setTextColor(Color.parseColor("#ffffff"));
        }




        //APPLY DATA ON SHAREDPREFS IF BUTTON IS CLICKED
        //AND INTENT TO THE NEXT ACTIVITY


        PyAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent aboutIntent = new Intent(MainDesign.this, AboutPython.class);
                startActivity(aboutIntent);

            }
        });


        PySyntax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent syntaxIntent = new Intent(MainDesign.this, PythonSyntax.class);
                startActivity(syntaxIntent);

            }
        });

        PyComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent commentIntent = new Intent(MainDesign.this, PythonComment.class);
                startActivity(commentIntent);

            }
        });

        PyVariables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent variablesIntent = new Intent(MainDesign.this, PythonVariables.class);
                startActivity(variablesIntent);

            }
        });

        PyDataTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent dataTypesIntent = new Intent(MainDesign.this, PythonDataTypes.class);
                startActivity(dataTypesIntent);

            }
        });

        btnTakePyIntroQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent PyQuizOneIntent = new Intent(MainDesign.this, PythonQuizOne.class);
                startActivity(PyQuizOneIntent);

            }
        });

        PyNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent NumbersIntent = new Intent(MainDesign.this, PythonNumbers.class);
                startActivity(NumbersIntent);

            }
        });

        PyStrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent StringsIntent = new Intent(MainDesign.this, PythonStrings.class);
                startActivity(StringsIntent);

            }
        });

        PyIfElse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent IfElseIntent = new Intent(MainDesign.this, PythonIfElse.class);
                startActivity(IfElseIntent);

            }
        });

        PyForLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent ForLoopIntent = new Intent(MainDesign.this, PythonForLoop.class);
                startActivity(ForLoopIntent);

            }
        });

        PyWhileLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent WhileLoopIntent = new Intent(MainDesign.this, PythonWhileLoop.class);
                startActivity(WhileLoopIntent);

            }
        });

        btnTakePyQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent PyQuizTwoIntent = new Intent(MainDesign.this, PythonQuizTwo.class);
                startActivity(PyQuizTwoIntent);

            }
        });

        PyLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent ListsIntent = new Intent(MainDesign.this, PythonLists.class);
                startActivity(ListsIntent);

            }
        });

        PyTuples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent TuplesIntent = new Intent(MainDesign.this, PythonTuples.class);
                startActivity(TuplesIntent);

            }
        });

        PySets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent SetsIntent = new Intent(MainDesign.this, PythonSets.class);
                startActivity(SetsIntent);

            }
        });

        PyDictionaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent DictionariesIntent = new Intent(MainDesign.this, PythonDictionary.class);
                startActivity(DictionariesIntent);

            }
        });

        PyFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent FunctionIntent = new Intent(MainDesign.this, PythonFunctions.class);
                startActivity(FunctionIntent);

            }
        });

        PyArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", currentScore);
                editor.apply();

                Intent ArrayIntent = new Intent(MainDesign.this, PythonArrays.class);
                startActivity(ArrayIntent);

            }
        });


    }
}