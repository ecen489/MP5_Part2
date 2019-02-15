package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class quiz_activity  extends AppCompatActivity {
    private static final String[] topics = {"Breakfast", "Math", "Movie"};
    private static final String[] questions = {"What breakfast item is a pancake that went to the gym?", "What is (5*8)/10?", "Who is the first Avenger (Marvel)?"};
    private static final String[] answers = {"Waffle", "4", "Captain America"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        Intent forwardIntent = getIntent();
        String extra = forwardIntent.getStringExtra("topic");
        TextView textview = (TextView) findViewById(R.id.questionsText);

        if (extra.equals(topics[0])) {
            textview.setText(questions[0]);
        }

        if (extra.equals(topics[1])) {
            textview.setText(questions[1]);
        }
            if (extra.equals(topics[2])) {
                textview.setText(questions[2]);
            }
        }

        public int getUserAnswer (String userAnswer){

            TextView text = (TextView) findViewById(R.id.questionsText);
            if (text.getText().toString().equals(questions[0])) {
                if (userAnswer.equals(answers[0])) {
                    return 1;
                }

                else {
                    return 0;
                }
            }
            else if (text.getText().toString().equals(questions[1])) {
                if (userAnswer.equals(answers[1])) {
                    return 1;
                }

                else {
                    return 0;
                }
            }
            else {
                if (userAnswer.equals(answers[2])) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        public void submitOnClick (View view){
            Intent backIntent = new Intent();
            EditText ansText = (EditText) findViewById(R.id.userAnswer);
            int isCorrect;

            isCorrect = getUserAnswer(ansText.getText().toString().toLowerCase());
            backIntent.putExtra("isCorrect", isCorrect);
            setResult(RESULT_OK, backIntent);
            finish();
        }
    }
