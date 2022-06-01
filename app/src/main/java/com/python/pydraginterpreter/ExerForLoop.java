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

public class ExerForLoop extends AppCompatActivity {

    TextView textAnsOne, textAnsTwo, textAnsThree, textAnsFour, textAnsFive, textAnsSix, textAnsSeven, textAnsEight;
    TextView dropTarget1, dropTarget2, dropTarget3, dropTarget4;
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
        setContentView(R.layout.activity_exer_for_loop);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //get score & assign into a currentScore variable
        currentScore = sharedPreferences.getInt("score", 0);


        textAnsOne = (TextView) findViewById(R.id.tvAns1);
        textAnsTwo = (TextView) findViewById(R.id.tvAns2);
        textAnsThree = (TextView) findViewById(R.id.tvAns3);
        textAnsFour = (TextView) findViewById(R.id.tvAns4);
        textAnsFive = (TextView) findViewById(R.id.tvAns5);
        textAnsSix = (TextView) findViewById(R.id.tvAns6);
        textAnsSeven = (TextView) findViewById(R.id.tvAns7);
        textAnsEight = (TextView) findViewById(R.id.tvAns8);

        dropTarget1 = findViewById(R.id.tvDropTarget1);
        dropTarget2 = findViewById(R.id.tvDropTarget2);
        dropTarget3 = findViewById(R.id.tvDropTarget3);
        dropTarget4 = findViewById(R.id.tvDropTarget4);
        btnContinue = findViewById(R.id.btnContinue);

        textAnsOne.setOnLongClickListener(longClickListener);
        textAnsTwo.setOnLongClickListener(longClickListener);
        textAnsThree.setOnLongClickListener(longClickListener);
        textAnsFour.setOnLongClickListener(longClickListener);
        textAnsFive.setOnLongClickListener(longClickListener);
        textAnsSix.setOnLongClickListener(longClickListener);
        textAnsSeven.setOnLongClickListener(longClickListener);
        textAnsEight.setOnLongClickListener(longClickListener);

        dropTarget1.setOnDragListener(dragListener);
        dropTarget2.setOnDragListener(dragListener);
        dropTarget3.setOnDragListener(dragListener);
        dropTarget4.setOnDragListener(dragListener);

        if ( currentScore == 9) {

            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    newScore = currentScore + addScore;

                    //STORE NEW SCORE INTO SHAREDPREF
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("score", newScore);
                    editor.apply();

                    //Creating intent to navigate to the next activity
                    Intent intent = new Intent(ExerForLoop.this, MainDesign.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                    Toast.makeText(ExerForLoop.this, "Congrats! You've unlocked the Python While Loop.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ExerForLoop.this, MainDesign.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                    Toast.makeText(ExerForLoop.this, "Success!", Toast.LENGTH_SHORT).show();
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

                    v.getId();
                    //#03DAC5 GREEN
                    //#EC7063 RED
                    if (view.getId() == R.id.tvAns1) {
                        if(v.getId() == R.id.tvDropTarget1) {
                            dropTarget1.setText("if");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget2) {
                            dropTarget2.setText("if");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));

                        }
                        if(v.getId() == R.id.tvDropTarget3) {
                            dropTarget3.setText("if");
                            dropTarget3.setBackgroundColor(Color.parseColor("#03DAC5"));
                            count +=1;
                            dropTarget3.setEnabled(false);

                        }
                        if(v.getId() == R.id.tvDropTarget4) {
                            dropTarget4.setText("if");
                            dropTarget4.setBackgroundColor(Color.parseColor("#EC7063"));

                        }
                    }

                    if (view.getId() == R.id.tvAns2) {
                        if(v.getId() == R.id.tvDropTarget1) {
                            dropTarget1.setText("break");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget2) {
                            dropTarget2.setText("break");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget3) {
                            dropTarget3.setText("break");
                            dropTarget3.setBackgroundColor(Color.parseColor("#EC7063"));

                        }
                        if(v.getId() == R.id.tvDropTarget4) {
                            dropTarget4.setText("break");
                            dropTarget4.setBackgroundColor(Color.parseColor("#03DAC5"));
                            count +=1;
                            dropTarget4.setEnabled(false);

                        }
                    }

                    if (view.getId() == R.id.tvAns3) {
                        if(v.getId() == R.id.tvDropTarget1) {
                            dropTarget1.setText("print");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget2) {
                            dropTarget2.setText("print");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget3) {
                            dropTarget3.setText("print");
                            dropTarget3.setBackgroundColor(Color.parseColor("#EC7063"));

                        }
                        if(v.getId() == R.id.tvDropTarget4) {
                            dropTarget4.setText("print");
                            dropTarget4.setBackgroundColor(Color.parseColor("#EC7063"));

                        }
                    }

                    if (view.getId() == R.id.tvAns4) {
                        if(v.getId() == R.id.tvDropTarget1) {
                            dropTarget1.setText("else");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));

                        }
                        if(v.getId() == R.id.tvDropTarget2) {
                            dropTarget2.setText("else");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget3) {
                            dropTarget3.setText("else");
                            dropTarget3.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget4) {
                            dropTarget4.setText("else");
                            dropTarget4.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                    }

                    if (view.getId() == R.id.tvAns5) {
                        if(v.getId() == R.id.tvDropTarget1) {
                            dropTarget1.setText("for");
                            dropTarget1.setBackgroundColor(Color.parseColor("#03DAC5"));
                            count +=1;
                            dropTarget1.setEnabled(false);
                        }
                        if(v.getId() == R.id.tvDropTarget2) {
                            dropTarget2.setText("for");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget3) {
                            dropTarget3.setText("for");
                            dropTarget3.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget4) {
                            dropTarget4.setText("for");
                            dropTarget4.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                    }

                    if (view.getId() == R.id.tvAns6) {
                        if(v.getId() == R.id.tvDropTarget1) {
                            dropTarget1.setText("while");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget2) {
                            dropTarget2.setText("while");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget3) {
                            dropTarget3.setText("while");
                            dropTarget3.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget4) {
                            dropTarget4.setText("while");
                            dropTarget4.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                    }

                    if (view.getId() == R.id.tvAns7) {
                        if(v.getId() == R.id.tvDropTarget1) {
                            dropTarget1.setText("range");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget2) {
                            dropTarget2.setText("range");
                            dropTarget2.setBackgroundColor(Color.parseColor("#03DAC5"));
                            count +=1;
                            dropTarget2.setEnabled(false);
                        }
                        if(v.getId() == R.id.tvDropTarget3) {
                            dropTarget3.setText("range");
                            dropTarget3.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget4) {
                            dropTarget4.setText("range");
                            dropTarget4.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                    }

                    if (view.getId() == R.id.tvAns8) {
                        if(v.getId() == R.id.tvDropTarget1) {
                            dropTarget1.setText("pass");
                            dropTarget1.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget2) {
                            dropTarget2.setText("pass");
                            dropTarget2.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget3) {
                            dropTarget3.setText("pass");
                            dropTarget3.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                        if(v.getId() == R.id.tvDropTarget4) {
                            dropTarget4.setText("pass");
                            dropTarget4.setBackgroundColor(Color.parseColor("#EC7063"));
                        }
                    }

                    break;

            }

            //cnt ay String, count ay int. String.valueof ay int to string
            //cnt = String.valueOf(count);
            //textcnt.setText(cnt);
            if (count == 4){
                btnContinue.setEnabled(true);
            } else {
                btnContinue.setEnabled(false);
            }
            return true;
        }


    };

}