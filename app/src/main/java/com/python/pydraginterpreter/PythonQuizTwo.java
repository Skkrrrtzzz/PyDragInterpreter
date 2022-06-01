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

public class PythonQuizTwo extends AppCompatActivity {

    private TextView tvQuestionQ1, questionNumberTV, questionItemTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn, nextQuestionBtn;
    private ArrayList<QuizTwo> quizTwoArrayList;
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
        setContentView(R.layout.activity_python_quiz_two);

        //    -----------SHARED PREF-----------
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //get score & assign into a currentScore variable
        currentScore = sharedPreferences.getInt("score", 0);
//    ------------END SHARED PREF-----------


        tvQuestionQ1 = findViewById(R.id.idQuizTwoQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        questionItemTV = findViewById(R.id.idTVQuestionItem);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        nextQuestionBtn = findViewById(R.id.idBtnNext);
        quizTwoArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizTwoArrayList);
        currentPosition = random.nextInt(quizTwoArrayList.size());
        setDataToViews(currentPosition);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizTwoArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {

                    correctAnswer = quizTwoArrayList.get(currentPosition).getAnswer().trim().toLowerCase();

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
                            currentPosition = random.nextInt(quizTwoArrayList.size());
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
                    correctAnswer = quizTwoArrayList.get(currentPosition).getAnswer();

                    showCorrectAnswer();
                }

            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizTwoArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {

                    correctAnswer = quizTwoArrayList.get(currentPosition).getAnswer().trim().toLowerCase();

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

                            currentPosition = random.nextInt(quizTwoArrayList.size());
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
                    correctAnswer = quizTwoArrayList.get(currentPosition).getAnswer();

                    showCorrectAnswer();
                }

            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizTwoArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {

                    correctAnswer = quizTwoArrayList.get(currentPosition).getAnswer().trim().toLowerCase();

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
                            currentPosition = random.nextInt(quizTwoArrayList.size());
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
                    correctAnswer = quizTwoArrayList.get(currentPosition).getAnswer();

                    showCorrectAnswer();
                }

            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizTwoArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {

                    correctAnswer = quizTwoArrayList.get(currentPosition).getAnswer().trim().toLowerCase();

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
                            currentPosition = random.nextInt(quizTwoArrayList.size());
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
                    correctAnswer = quizTwoArrayList.get(currentPosition).getAnswer();

                    showCorrectAnswer();
                }

            }
        });

    }

    private  void showCorrectAnswer() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PythonQuizTwo.this);
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
                currentPosition = random.nextInt(quizTwoArrayList.size());
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PythonQuizTwo.this);
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
                    currentPosition = random.nextInt(quizTwoArrayList.size());
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
            if (currentScore == 11) {

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

                        Intent q1ToHome = new Intent(PythonQuizTwo.this, MainDesign.class);
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

                        Intent q1ToHome = new Intent(PythonQuizTwo.this, MainDesign.class);
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
            tvQuestionQ1.setText(quizTwoArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizTwoArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizTwoArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizTwoArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizTwoArrayList.get(currentPos).getOption4());
        }

    }

    private void getQuizQuestion(ArrayList<QuizTwo> quizTwoArrayList) {


        quizTwoArrayList.add(new QuizTwo("Q.    In Python, What is the syntax to output \"Python\"", "DISPLAY(\"Python\")", "print(\"Python\")", "echo \"Python\"", "console.log(\"Python\")", "print(\"Python\")"));
        quizTwoArrayList.add(new QuizTwo("Q.    What is the correct syntax to comment? ", "#", "//", "$", "%", "#"));
        quizTwoArrayList.add(new QuizTwo("Q.    What year was Python released?", "1992", "1990", "1991", "1993", "1991"));
        quizTwoArrayList.add(new QuizTwo("Q.    What is the correct naming of a variables?", "1personName", "personName", "person Name", "person-Name", "personName"));
        quizTwoArrayList.add(new QuizTwo("Q.    Who created Python?", "Rasmus Lerdorf", "Arnel Ruiz", "James Gosling", "Guido van Rossum", "Guido van Rossum"));
        quizTwoArrayList.add(new QuizTwo("Q.    What will be the output if x= 5.0, print(type(x))", "int", "complex", "str", "float", "float"));
        quizTwoArrayList.add(new QuizTwo("Q.    What function will be used to get the data types of a Python object?", "type()", "dataTypes()", "typeof()", "dataObject()", "type()"));
        quizTwoArrayList.add(new QuizTwo("Q.    Which of the following are built-in data types of Python?", "set", "str", "int", "All Of The Above", "All Of The Above"));
        quizTwoArrayList.add(new QuizTwo("Q.    What special character is used to assign  a value to a variable?", "=>", "!=", "=", ">", "="));
        quizTwoArrayList.add(new QuizTwo("Q.    What is variable?", "used to storing data", "used to get the data type of any object", "used to compare two objects", "used to create a function", "used to storing data"));
        quizTwoArrayList.add(new QuizTwo("Q.    What is the correct syntax to comment? ", "#", "//", "$", "%", "#"));
        quizTwoArrayList.add(new QuizTwo("Q.    What is the extension of Python Files? ", ".pyt", ".py", ".pthn", ".python", ".py"));
        quizTwoArrayList.add(new QuizTwo("Q.    Which function can display string literal ?", "print()", "display()", "output()", "console.log)", "print()"));
        quizTwoArrayList.add(new QuizTwo("Q.    What is the correct way of assigning string to variable? ", "Variable name followed by an equal sign and the string.", "Declaring Data types and variable name plus the strings", "We can't assign and store strings in a variable", "None of the above", "Variable name followed by an equal sign and the string."));
        quizTwoArrayList.add(new QuizTwo("Q.    Which is the correct  way to assign a multiline string to a variable?", "using single quotes", "Using double quotes", "Using three double quotes", "None of the above", "Using three double quotes"));
        quizTwoArrayList.add(new QuizTwo("Q.    What statement can stop the loop before it looped through all the item?", "pass", "break", "stop", "continue", "break"));
        quizTwoArrayList.add(new QuizTwo("Q.    What statement  can stop the current iteration of the loop and continue with the next?", "pass", "break", "stop", "continue", "continue"));
        quizTwoArrayList.add(new QuizTwo("Q.    Which function returns a sequence of numbers?", "return()", "len()", "length()", "range()", "range()"));
        quizTwoArrayList.add(new QuizTwo("Q.    What keyword in a for loop specifies a block of code to be executed when the loop is finished?", "for", "elif", "else)", "while", "else"));
        quizTwoArrayList.add(new QuizTwo("Q.    What statement is needed   if for loops is empty  to avoid getting an error?", "pass", "avoid", "break", "continue", "pass"));
        quizTwoArrayList.add(new QuizTwo("Q.    Which logical condition  for equals?", "=>", "!=", "==", "=", "=="));
        quizTwoArrayList.add(new QuizTwo("Q.    Which logical condition for not equal?", "=>", "!=", "==", "=", "!="));
        quizTwoArrayList.add(new QuizTwo("Q.    What is whitespace at the beginning of a line that define scope in the code? ", "Indentation", "Comment", "Syntax", "None of the above", "Indentation"));
        quizTwoArrayList.add(new QuizTwo("Q.    Which keyword is use if the previous conditions were not true then try this condition? ", "if", "elif", "else", "for", "elif"));
        quizTwoArrayList.add(new QuizTwo("Q.    Which is the correct syntax to get the data types of an object? ", "type()", "typeOf()", "data()", "dataTypes()", "type()"));
        quizTwoArrayList.add(new QuizTwo("Q.    This is the positive or negative whole number. ", "int", "float", "complex", "None of the above", "int"));
        quizTwoArrayList.add(new QuizTwo("Q.    Which is the correct function to convert number into positive or negative number? ", "int()", "float()", "complex()", "None of the above", "int()"));

    }
}