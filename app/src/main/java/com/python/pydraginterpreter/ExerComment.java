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

public class ExerComment extends AppCompatActivity {

    TextView textAnsOne, textAnsTwo, textAnsThree, textAnsFour;
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
        setContentView(R.layout.activity_exer_comment);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //get score & assign into a currentScore variable
        currentScore = sharedPreferences.getInt("score", 0);


        textAnsOne = (TextView) findViewById(R.id.tvAns1);
        textAnsTwo = (TextView) findViewById(R.id.tvAns2);
        textAnsThree= (TextView) findViewById(R.id.tvAns3);
        textAnsFour = (TextView) findViewById(R.id.tvAns4);
        dragPlace = (TextView) findViewById(R.id.etquiz);

        btnContinue = findViewById(R.id.btnContinue);


        textAnsOne.setOnLongClickListener(longClickListener);
        textAnsTwo.setOnLongClickListener(longClickListener);
        textAnsThree.setOnLongClickListener(longClickListener);
        textAnsFour.setOnLongClickListener(longClickListener);

        dragPlace.setOnDragListener(dragListener);

        if ( currentScore == 2) {

            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    newScore = currentScore + addScore;

                    //STORE NEW SCORE INTO SHAREDPREF
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("score", newScore);
                    editor.apply();

                    //Creating intent to navigate to the next activity
                    Intent exerCToMain = new Intent(ExerComment.this, MainDesign.class);
                    overridePendingTransition(0, 0);
                    startActivity(exerCToMain);

                    Toast.makeText(ExerComment.this, "Congrats! You've unlocked the Python Variables.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {

            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ExerComment.this, MainDesign.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                    Toast.makeText(ExerComment.this, "Success!", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, myShadowBuilder, view, 0);
            return true;
        }
    };

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
                    if (view.getId() == R.id.tvAns1) {
                        dragPlace.setText("&");
                        dragPlace.setBackgroundColor(Color.parseColor("#EC7063"));
                        btnContinue.setEnabled(false);
                    }
                    if (view.getId() == R.id.tvAns2) {
                        dragPlace.setText("$");
                        dragPlace.setBackgroundColor(Color.parseColor("#EC7063"));
                        btnContinue.setEnabled(false);
                    }
                    if (view.getId() == R.id.tvAns3) {
                        dragPlace.setText("%");
                        dragPlace.setBackgroundColor(Color.parseColor("#EC7063"));
                        btnContinue.setEnabled(false);
                    }
                    if (view.getId() == R.id.tvAns4) {
                        dragPlace.setText("#");
                        dragPlace.setBackgroundColor(Color.parseColor("#03DAC5"));
                        btnContinue.setEnabled(true);
                    }


                    break;
            }

            return true;
        }
    };
}