package com.example.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    //Making ArrayList to sote the options
    ArrayList<Integer> options= new ArrayList<Integer>();
    TextView resultTextView,timerTextView;
    TextView pointsTextView,sumTextView;
    Button button0,button1,button2,button3,playAgainButton;
    RelativeLayout gameRealtive;
    int locationOfCorrectAns;
    int score = 0;
    int numberOfQuestions = 0;

    //Adding Play Again Feature
    public void playAgain(View view)
    {
        score=0;
        numberOfQuestions=0;
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);

        generateQuestion();
        //We need to enable our counter too
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String time=Integer.toString((int) millisUntilFinished/1000);
                if(millisUntilFinished/1000<=9)
                    time="0"+time;
                timerTextView.setText(time+"s");
            }

            @Override
            public void onFinish() {
                //After finishing, we have to show the final results
                playAgainButton.setVisibility(View.VISIBLE);
                timerTextView.setText("00s");
                resultTextView.setText("Your Score : "+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
            }
        }.start(); //30s

    }

    //Method for generating new questions
    public void generateQuestion()
    {
        int incorrectAnswer;
        //Creating random numbers
        Random rand= new Random();
        int a= rand.nextInt(51);
        int b= rand.nextInt(51);

        sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));

        locationOfCorrectAns=rand.nextInt(4);   //0,1,2,3
        //We need to clear our options ArrayList each time we make a new one
        options.clear();

        for(int i=0; i<4; i++)
        {
            if(i==locationOfCorrectAns)
                options.add(a+b);
            else
            {
                incorrectAnswer = rand.nextInt(101);
                while (incorrectAnswer==a+b)
                    incorrectAnswer = rand.nextInt(101);
                options.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(options.get(0)));
        button1.setText(Integer.toString(options.get(1)));
        button2.setText(Integer.toString(options.get(2)));
        button3.setText(Integer.toString(options.get(3)));

    }
    public void chooseanswer(View view)
    {
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAns)))
        {
            Log.i("Correct",view.getTag().toString());
            //Adding 1 to the score if the answer is correct
            score++;
            resultTextView.setText("Correct Answer !");
        }
        else
        {
            resultTextView.setText("Incorrect Answer !");
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    public void start(View view)
    {
        startButton.setVisibility(View.INVISIBLE);
        gameRealtive.setVisibility(RelativeLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton=(Button)findViewById(R.id.startButton);
        resultTextView=(TextView)findViewById(R.id.resultTextView);
        pointsTextView=(TextView)findViewById(R.id.pointsTextView);
        timerTextView=(TextView)findViewById(R.id.timerTextView);
        sumTextView=(TextView)findViewById(R.id.sumTextView);
        button0= (Button)findViewById(R.id.button2);
        button1= (Button)findViewById(R.id.button3);
        button2= (Button)findViewById(R.id.button4);
        button3= (Button)findViewById(R.id.button5);
        playAgainButton=(Button)findViewById(R.id.playAgainButton);
        gameRealtive=(RelativeLayout) findViewById(R.id.gameRelative);
        //generateQuestion();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //adds items to action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
