package com.python.pydraginterpreter;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ExerNumbers extends AppCompatActivity {

    TextView textAnsOne, textAnsTwo, textAnsThree, textAnsFour;
    EditText dropTarget1, dropTarget2;
    Button btnContinue;

    int count;

    int currentScore;
    int addScore = 1;
    int newScore;

    SharedPreferences sharedPreferences;

    public static String SHARED_PREF_NAME = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer_numbers);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //get score & assign into a currentScore variable
        currentScore = sharedPreferences.getInt("score", 0);

        textAnsOne = (TextView) findViewById(R.id.tvAns1);
        textAnsTwo = (TextView) findViewById(R.id.tvAns2);
        textAnsThree = (TextView) findViewById(R.id.tvAns3);
        textAnsFour = (TextView) findViewById(R.id.tvAns4);

        dropTarget1 = findViewById(R.id.ansholder1);
        dropTarget2 = findViewById(R.id.ansholder2);
        btnContinue = findViewById(R.id.btnContinue);

        textAnsOne.setOnLongClickListener(longClickListener);
        textAnsTwo.setOnLongClickListener(longClickListener);
        textAnsThree.setOnLongClickListener(longClickListener);
        textAnsFour.setOnLongClickListener(longClickListener);

        dropTarget1.setOnDragListener(dragListener);
        dropTarget2.setOnDragListener(dragListener);

        if ( currentScore == 6) {

            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    newScore = currentScore + addScore;

                    //STORE NEW SCORE INTO SHAREDPREF
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("score", newScore);
                    editor.apply();

                    //Creating intent to navigate to the next activity
                    Intent intent = new Intent(ExerNumbers.this, MainDesign.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                    Toast.makeText(ExerNumbers.this, "Congrats! You've unlocked the Python String.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ExerNumbers.this, MainDesign.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                    Toast.makeText(ExerNumbers.this, "Success!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("", "");
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

                    v.getId();
                    //#03DAC5 GREEN
                    //#EC7063 RED
                    if (view.getId() == R.id.tvAns1) {
                        if (v.getId() == R.id.ansholder1) {
                            dropTarget1.setText("type");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if (v.getId() == R.id.ansholder2) {
                            dropTarget2.setText("type");
                            dropTarget2.setBackgroundColor(Color.parseColor("#03DAC5"));
                            count += 1;
                            dropTarget2.setEnabled(false);
                        }
                    }
                    if (view.getId() == R.id.tvAns2) {
                        if (v.getId() == R.id.ansholder1) {
                            dropTarget1.setText("str");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if (v.getId() == R.id.ansholder2) {
                            dropTarget2.setText("str");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                    }
                    if (view.getId() == R.id.tvAns3) {
                        if (v.getId() == R.id.ansholder1) {
                            dropTarget1.setText("float");
                            dropTarget1.setBackgroundColor(Color.parseColor("#03DAC5"));
                            count += 1;
                            dropTarget1.setEnabled(false);
                            ;
                        }
                        if (v.getId() == R.id.ansholder2) {
                            dropTarget2.setText("float");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                    }
                    if (view.getId() == R.id.tvAns4) {
                        if (v.getId() == R.id.ansholder1) {
                            dropTarget1.setText("int");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if (v.getId() == R.id.ansholder2) {
                            dropTarget2.setText("int");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                    }

                    break;

            }

            //cnt ay String, count ay int. String.valueof ay int to string
            //cnt = String.valueOf(count);
            //textcnt.setText(cnt);

            if (count == 2) {
                btnContinue.setEnabled(true);
            } else {
                btnContinue.setEnabled(false);
            }
            return true;
        }


    };
}