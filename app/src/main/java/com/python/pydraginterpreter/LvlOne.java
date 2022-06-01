package com.python.pydraginterpreter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LvlOne extends AppCompatActivity {

    TextView textview_score;
    Button button_next;
    int currentScore;
    int addScore = 1;
    int newScore;
    Button deletePref;

    SharedPreferences sharedPreferences;

    public static String SHARED_PREF_NAME = "mypref";
    //public static String KEY_SCORE= "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_one);

        textview_score = findViewById(R.id.textviewlvlonescore);
        button_next = findViewById(R.id.btnContinue);
        deletePref = findViewById(R.id.deletepref);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //get score
        currentScore = sharedPreferences.getInt("score", 0);

        textview_score.setText(""+currentScore);


        if ( currentScore == 0) {
            button_next.setOnClickListener(view -> {

                newScore = currentScore + addScore;

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score", newScore);
                editor.apply();

                Intent intent = new Intent(LvlOne.this, MainDesign.class);
                startActivity(intent);

                Toast.makeText(LvlOne.this, "\n" +
                        "Congrats! You've unlocked the Python Syntax.", Toast.LENGTH_SHORT).show();
            });
        } else {
            button_next.setOnClickListener(view -> {

        Intent intent = new Intent(LvlOne.this, MainDesign.class);
        startActivity(intent);
            });
        }


        deletePref.setOnClickListener(view -> {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(LvlOne.this, MainDesign.class);
            startActivity(intent);


            Toast.makeText(LvlOne.this, "DELETED", Toast.LENGTH_SHORT).show();
        });
    }
}