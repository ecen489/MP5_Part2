package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String[] quizQuestions = {"Breakfast Food", "Gaming", "Math"};
    private static final int REQUIRED_CODE = 3500;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent forwardIntent = new Intent(this, quiz_activity.class);

        ListView simpleList = (ListView) findViewById(R.id.dalist);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quizQuestions);
        simpleList.setAdapter(myAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String topic = parent.getItemAtPosition(position).toString();
                forwardIntent.putExtra("topic", topic);

                startActivityForResult(forwardIntent, REQUIRED_CODE); // return 1 or 0 for result of quiz question
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        TextView scoreText = (TextView) findViewById(R.id.scoreBoard);
        if(requestCode==REQUIRED_CODE){
            int answer = intent.getIntExtra("isCorrect", 0);
            if(answer == 1){
                score += 1;
                scoreText.setText("Score:" + score);
                Toast.makeText(MainActivity.this, "You're Correct! You get one point.", Toast.LENGTH_SHORT).show(); // message shown if they ae right
            }

            else
                Toast.makeText(MainActivity.this, "You're wrong you get zero points.", Toast.LENGTH_SHORT).show(); // message shown if they are wrong
        }
    }

    public void onClickReset(View view){
        TextView scoreText = (TextView) findViewById(R.id.scoreBoard);
        score = 0;
        scoreText.setText("Score:" + score);
    }
}