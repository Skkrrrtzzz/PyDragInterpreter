package com.python.pydraginterpreter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class PythonQuizOne extends AppCompatActivity {

    private TextView tvQuestionQ1, questionNumberTV, questionItemTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn, nextQuestionBtn;
    private ArrayList<QuizOne> quizOneArrayList;
    Random random;
    int quizCurrentScore,
            questionItem = 1,
            questionAttempted = 0,
            currentPosition;

    String correctAnswer;

//    -----------SHARED PREF-----------
    int currentScore;
    int addScore = 1;
    int newScore;

    SharedPreferences sharedPreferences;

    public static String SHARED_PREF_NAME = "mypref";

//    ------------END SHARED PREF-----------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_quiz_one);

//    -----------SHARED PREF-----------
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //get score & assign into a currentScore variable
        currentScore = sharedPreferences.getInt("score", 0);
//    ------------END SHARED PREF-----------


        tvQuestionQ1 = findViewById(R.id.idQuizOneQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        questionItemTV = findViewById(R.id.idTVQuestionItem);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        nextQuestionBtn = findViewById(R.id.idBtnNext);
        quizOneArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizOneArrayList);
        currentPosition = random.nextInt(quizOneArrayList.size());
        setDataToViews(currentPosition);



        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizOneArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {

                    correctAnswer = quizOneArrayList.get(currentPosition).getAnswer().trim().toLowerCase();

                    quizCurrentScore++;
                    option1Btn.setBackgroundResource(R.drawable.option_buttoncorrect);
                    nextQuestionBtn.setEnabled(true);
                    nextQuestionBtn.setBackgroundResource(R.drawable.option_button);

                    option2Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    option3Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    option4Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    nextQuestionBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            questionAttempted++;
                            if (questionItem <= 9){
                                questionItem++;
                            }
                            currentPosition = random.nextInt(quizOneArrayList.size());
                            setDataToViews(currentPosition);

                            nextQuestionBtn.setEnabled(false);
                            nextQuestionBtn.setBackgroundResource(R.drawable.option_buttonfalse);
                            option1Btn.setBackgroundResource(R.drawable.option_button);
                            option2Btn.setBackgroundResource(R.drawable.option_button);
                            option3Btn.setBackgroundResource(R.drawable.option_button);
                            option4Btn.setBackgroundResource(R.drawable.option_button);
                        }
                    });
                } else {
                    option1Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    correctAnswer = quizOneArrayList.get(currentPosition).getAnswer();

                    showCorrectAnswer();
                }

            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizOneArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {

                    correctAnswer = quizOneArrayList.get(currentPosition).getAnswer().trim().toLowerCase();

                    quizCurrentScore++;
                    option2Btn.setBackgroundResource(R.drawable.option_buttoncorrect);
                    nextQuestionBtn.setEnabled(true);
                    nextQuestionBtn.setBackgroundResource(R.drawable.option_button);

                    option1Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    option3Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    option4Btn.setBackgroundResource(R.drawable.option_buttonwrong);

                    nextQuestionBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            questionAttempted++;
                            if (questionItem <= 9){
                                questionItem++;
                            }

                            currentPosition = random.nextInt(quizOneArrayList.size());
                            setDataToViews(currentPosition);

                            nextQuestionBtn.setEnabled(false);
                            nextQuestionBtn.setBackgroundResource(R.drawable.option_buttonfalse);
                            option1Btn.setBackgroundResource(R.drawable.option_button);
                            option2Btn.setBackgroundResource(R.drawable.option_button);
                            option3Btn.setBackgroundResource(R.drawable.option_button);
                            option4Btn.setBackgroundResource(R.drawable.option_button);
                        }
                    });
                } else {
                    option2Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    correctAnswer = quizOneArrayList.get(currentPosition).getAnswer();

                    showCorrectAnswer();
                }

            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizOneArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {

                    correctAnswer = quizOneArrayList.get(currentPosition).getAnswer().trim().toLowerCase();

                    quizCurrentScore++;
                    option3Btn.setBackgroundResource(R.drawable.option_buttoncorrect);
                    nextQuestionBtn.setEnabled(true);
                    nextQuestionBtn.setBackgroundResource(R.drawable.option_button);

                    option1Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    option2Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    option4Btn.setBackgroundResource(R.drawable.option_buttonwrong);

                    nextQuestionBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            questionAttempted++;
                            if (questionItem <= 9){
                                questionItem++;
                            }
                            currentPosition = random.nextInt(quizOneArrayList.size());
                            setDataToViews(currentPosition);

                            nextQuestionBtn.setEnabled(false);
                            nextQuestionBtn.setBackgroundResource(R.drawable.option_buttonfalse);
                            option1Btn.setBackgroundResource(R.drawable.option_button);
                            option2Btn.setBackgroundResource(R.drawable.option_button);
                            option3Btn.setBackgroundResource(R.drawable.option_button);
                            option4Btn.setBackgroundResource(R.drawable.option_button);
                        }
                    });
                } else {
                    option3Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    correctAnswer = quizOneArrayList.get(currentPosition).getAnswer();

                    showCorrectAnswer();
                }

            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizOneArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {

                    correctAnswer = quizOneArrayList.get(currentPosition).getAnswer().trim().toLowerCase();

                    quizCurrentScore++;
                    option4Btn.setBackgroundResource(R.drawable.option_buttoncorrect);
                    nextQuestionBtn.setEnabled(true);
                    nextQuestionBtn.setBackgroundResource(R.drawable.option_button);

                    option1Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    option2Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    option3Btn.setBackgroundResource(R.drawable.option_buttonwrong);

                    nextQuestionBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            questionAttempted++;
                            if (questionItem <= 9){
                                questionItem++;
                            }
                            currentPosition = random.nextInt(quizOneArrayList.size());
                            setDataToViews(currentPosition);

                            nextQuestionBtn.setEnabled(false);
                            nextQuestionBtn.setBackgroundResource(R.drawable.option_buttonfalse);
                            option1Btn.setBackgroundResource(R.drawable.option_button);
                            option2Btn.setBackgroundResource(R.drawable.option_button);
                            option3Btn.setBackgroundResource(R.drawable.option_button);
                            option4Btn.setBackgroundResource(R.drawable.option_button);
                        }
                    });
                } else {
                    option4Btn.setBackgroundResource(R.drawable.option_buttonwrong);
                    correctAnswer = quizOneArrayList.get(currentPosition).getAnswer();

                    showCorrectAnswer();
                }

            }
        });

    }

    private  void showCorrectAnswer() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PythonQuizOne.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.correct_answer_dialog,(LinearLayout)findViewById(R.id.idllcorrectAnswer));
        TextView correctAnswerTV = bottomSheetView.findViewById(R.id.idTVCorrectAnswer);
        Button contToNextQuestion = bottomSheetView.findViewById(R.id.idBtnContinueToNextQuestion);

        correctAnswerTV.setText(correctAnswer);

        contToNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItem == 10){
                    showBottomSheet();
                }
                questionAttempted++;
                //quizCurrentScore--;
                questionItem++;
                currentPosition = random.nextInt(quizOneArrayList.size());
                setDataToViews(currentPosition);

                nextQuestionBtn.setEnabled(false);
                nextQuestionBtn.setBackgroundResource(R.drawable.option_buttonfalse);
                option1Btn.setBackgroundResource(R.drawable.option_button);
                option2Btn.setBackgroundResource(R.drawable.option_button);
                option3Btn.setBackgroundResource(R.drawable.option_button);
                option4Btn.setBackgroundResource(R.drawable.option_button);

                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PythonQuizOne.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_dialog,(LinearLayout)findViewById(R.id.idllscore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        TextView remarkTV = bottomSheetView.findViewById(R.id.idTVRemarks);
        Button retakeQuizBtn = bottomSheetView.findViewById(R.id.idBtnRetakeQuiz);


        //FAILED
        if (quizCurrentScore < 7) {
            scoreTV.setText("SCORE: " + quizCurrentScore + "/10");
            remarkTV.setText("You FAILED! Try Again.");
            remarkTV.setTextColor(Color.parseColor("#ff0000"));


            //RETAKE THE QUIZ AGAIN
            retakeQuizBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentPosition = random.nextInt(quizOneArrayList.size());
                    setDataToViews(currentPosition);
                    questionAttempted = 0;
                    questionItem = 1;
                    quizCurrentScore = 0;
                    bottomSheetDialog.dismiss();
                }
            });


        //PASSED
        } else {
            scoreTV.setText("SCORE: " + quizCurrentScore + "/10");
            remarkTV.setText("You PASSED!");
            remarkTV.setTextColor(Color.parseColor("#00ff00"));

            retakeQuizBtn.setText("Continue");

            //if currentScore is 5 then add plus one to currentscore
            //if not currentScore will not be added
            //user might use this bug to unlock other python topic by answering this quiz again and again.
            if (currentScore == 5) {

                //IF USER GOT PASSED THEN CONTINUE TO HOME
                //ADD 1 SCORE INTO CURRENTSCORE SO IT CAN UNLOCK NEXT TOPIC
                retakeQuizBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        newScore = currentScore + addScore;

                        //STORE NEW SCORE INTO SHAREDPREF
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("score", newScore);
                        editor.apply();

                        Intent q1ToHome = new Intent(PythonQuizOne.this, MainDesign.class);
                        startActivity(q1ToHome);

                        questionAttempted = 0;
                        questionItem = 1;
                        quizCurrentScore = 0;
                        bottomSheetDialog.dismiss();
                    }
                });

            } else {

                //IF USER GOT PASSED THEN CONTINUE TO HOME
                retakeQuizBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent q1ToHome = new Intent(PythonQuizOne.this, MainDesign.class);
                        startActivity(q1ToHome);

                        questionAttempted = 0;
                        questionItem = 1;
                        quizCurrentScore = 0;
                        bottomSheetDialog.dismiss();
                    }
                });

            }


        }

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos) {
        questionNumberTV.setText(questionAttempted + "/10");
        questionItemTV.setText("Question " + questionItem + "/10");

        if (questionAttempted == 10) {
            showBottomSheet();
        } else {
            tvQuestionQ1.setText(quizOneArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizOneArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizOneArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizOneArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizOneArrayList.get(currentPos).getOption4());
        }

    }

    private void getQuizQuestion(ArrayList<QuizOne> quizOneArrayList) {


        quizOneArrayList.add(new QuizOne("Q.    In Python, What is the syntax to output \"Python\"", "DISPLAY(\"Python\")", "print(\"Python\")", "echo \"Python\"", "console.log(\"Python\")", "print(\"Python\")"));
        quizOneArrayList.add(new QuizOne("Q.    What is the correct syntax to comment? ", "#", "//", "$", "%", "#"));
        quizOneArrayList.add(new QuizOne("Q.    What year was Python released?", "1992", "1990", "1991", "1993", "1991"));
        quizOneArrayList.add(new QuizOne("Q.    What is the correct naming of a variables?", "1personName", "personName", "person Name", "person-Name", "personName"));
        quizOneArrayList.add(new QuizOne("Q.    Who created Python?", "Rasmus Lerdorf", "Arnel Ruiz", "James Gosling", "Guido van Rossum", "Guido van Rossum"));
        quizOneArrayList.add(new QuizOne("Q.    What will be the output if x= 5.0, print(type(x))", "int", "complex", "str", "float", "float"));
        quizOneArrayList.add(new QuizOne("Q.    What function will be used to get the data types of a Python object?", "type()", "dataTypes()", "typeof()", "dataObject()", "type()"));
        quizOneArrayList.add(new QuizOne("Q.    Which of the following are built-in data types of Python?", "set", "str", "int", "All Of The Above", "All Of The Above"));
        quizOneArrayList.add(new QuizOne("Q.    What special character is used to assign  a value to a variable?", "=>", "!=", "=", ">", "="));
        quizOneArrayList.add(new QuizOne("Q.    What is variable?", "used to storing data", "used to get the data type of any object", "used to compare two objects", "used to create a function", "used to storing data"));
        quizOneArrayList.add(new QuizOne("Q.    What is the correct syntax to comment? ", "#", "//", "$", "%", "#"));
        quizOneArrayList.add(new QuizOne("Q.    What is the extension of Python Files? ", ".pyt", ".py", ".pthn", ".python", ".py"));

        //quizOneArrayList.add(new QuizOne("1", "1", "2", "3", "4", "1"));

    }
}