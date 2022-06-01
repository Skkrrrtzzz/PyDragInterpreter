package com.python.pydraginterpreter;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ExerSyntax extends AppCompatActivity {

    TextView textAnsDef, textAnsPrint, textAnsFor, textAnsElse;
    TextView dragPlace;
    Button btnContinue;

    int currentScore;
    int addScore = 1;
    int newScore;

    SharedPreferences sharedPreferences;

    public static String SHARED_PREF_NAME = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer_syntax);



        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //get score & assign into a currentScore variable
        currentScore = sharedPreferences.getInt("score", 0);

        textAnsDef = (TextView) findViewById(R.id.tvAnsDef);
        textAnsPrint = (TextView) findViewById(R.id.tvAnsPrint);
        textAnsFor= (TextView) findViewById(R.id.tvAnsFor);
        textAnsElse = (TextView) findViewById(R.id.tvAnsElse);
        dragPlace = (TextView) findViewById(R.id.etquiz);

        btnContinue = findViewById(R.id.btnContinue);


        textAnsDef.setOnLongClickListener(longClickListener);
        textAnsPrint.setOnLongClickListener(longClickListener);
        textAnsFor.setOnLongClickListener(longClickListener);
        textAnsElse.setOnLongClickListener(longClickListener);

        dragPlace.setOnDragListener(dragListener);

        if ( currentScore == 1) {

            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    newScore = currentScore + addScore;

                    //STORE NEW SCORE INTO SHAREDPREF
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("score", newScore);
                    editor.apply();

                    Intent intent = new Intent(ExerSyntax.this, MainDesign.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                    Toast.makeText(ExerSyntax.this, "Congrats! You've unlocked the Python Comment.", Toast.LENGTH_SHORT).show();


                }
            });

        } else {

            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ExerSyntax.this, MainDesign.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                    Toast.makeText(ExerSyntax.this, "Success!", Toast.LENGTH_SHORT).show();
                }
            });

        }


    }

    //PRESS AND HOLD EVENT
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, myShadowBuilder, view, 0);
            return true;
        }
    };

    //ON DRAG EVENT
    final View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    //if (view.getId() == R.id.tvForLoopDrag) {
                    //}

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.tvAnsDef) {
                        dragPlace.setText("def");
                        dragPlace.setBackgroundColor(Color.parseColor("#EC7063"));
                        btnContinue.setEnabled(false);
                    }
                    if (view.getId() == R.id.tvAnsPrint) {
                        dragPlace.setText("print");
                        dragPlace.setBackgroundColor(Color.parseColor("#03DAC5"));
                        btnContinue.setEnabled(true);
                    }
                    if (view.getId() == R.id.tvAnsFor) {
                        dragPlace.setText("for");
                        dragPlace.setBackgroundColor(Color.parseColor("#EC7063"));
                        btnContinue.setEnabled(false);
                    }
                    if (view.getId() == R.id.tvAnsElse) {
                        dragPlace.setText("else");
                        dragPlace.setBackgroundColor(Color.parseColor("#EC7063"));
                        btnContinue.setEnabled(false);
                    }


                    break;
            }

            return true;
        }
    };

}