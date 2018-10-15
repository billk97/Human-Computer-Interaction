package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;


public class MicrowaveIsOn extends AppCompatActivity {
    Button PauseButton;
    Button BackButton;
    TextView Clock;
    TextView Info;
    long mStartTimeInMilis=62000;
    CountDownTimer  mCountDownTimer;
    boolean mTimerRunning;
    long mTimeLeftInMillis=mStartTimeInMilis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microwave_is_on);
        initializeVriable();

        startTimer();
        PauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerRunning) {
                    pauseTimer();
                }
                else{
                    startTimer();

                }
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

    private void initializeVriable()
    { PauseButton=(Button) findViewById(R.id.buttonPause);
      BackButton=(Button)findViewById(R.id.butBack);
      Clock=(TextView)findViewById(R.id.ClocktextView);
      Info=(TextView)findViewById(R.id.infoTextView);
      }

      private void startTimer(){
        mCountDownTimer =new CountDownTimer(mTimeLeftInMillis,1000) { //posa lepta exoun apomeinei kai me th ruthmo tha phgainei to xronometro!(1000ms=1s)
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis=millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                   mTimerRunning=false; //edw kanw oti thelw opws teleivsei
                   PauseButton.setText("ΕΝΑΡΞΗ");

            }
        }.start();
          mTimerRunning=true;
          PauseButton.setText("ΠΑΥΣΗ");

      }

      private void pauseTimer(){
            mCountDownTimer.cancel();
           mTimerRunning=false;
           PauseButton.setText("ΕΝΑΡΞΗ");


      }

    private void updateCountDownText(){
        int minutes=(int) (mTimeLeftInMillis/1000)/60;
        int seconds=(int) (mTimeLeftInMillis/1000)%60;
        String timeLeftFormatted=String.format(minutes+":"+seconds);
        Clock.setText(timeLeftFormatted);
    }

}
