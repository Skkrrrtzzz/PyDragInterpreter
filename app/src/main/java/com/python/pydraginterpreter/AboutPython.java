package com.python.pydraginterpreter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutPython extends AppCompatActivity {

    Button button_next;
    int currentScore;
    int addScore = 1;
    int newScore;

    SharedPreferences sharedPreferences;

    public static String SHARED_PREF_NAME = "mypref";
    //public static String KEY_SCORE= "score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_python);

        button_next = findViewById(R.id.btnAboutNext);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //get score
        currentScore = sharedPreferences.getInt("score", 0);

        if ( currentScore == 0) {
            button_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    newScore = currentScore + addScore;

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("score", newScore);
                    editor.apply();

                    Intent intent = new Intent(AboutPython.this, MainDesign.class);
                    startActivity(intent);

                    Toast.makeText(AboutPython.this, "\n" +
                            "Congrats! You've unlocked the Python Syntax.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            button_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(AboutPython.this, MainDesign.class);
                    startActivity(intent);
                }
            });
        }
    }
}