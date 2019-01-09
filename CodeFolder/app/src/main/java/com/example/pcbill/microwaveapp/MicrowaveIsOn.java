package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class MicrowaveIsOn extends AppCompatActivity {
    Button PauseButton;
    Button BackButton;
    TextView Clock;
    TextView Info;
    CountDownTimer  mCountDownTimer;
    boolean mTimerRunning;
    long mTimeLeftInMillis;
    MediaPlayer ring;
    ImageView Image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microwave_is_on);
        initializeVriable();
        Clock.setTextSize(120);
        Clock.setTextColor(Color.BLACK);
        Info.setTextColor(Color.BLACK);
         mTimeLeftInMillis =10000*2*getIntent().getIntExtra(Intent.EXTRA_TEXT, 1); // pairnw th timh p esteila kai kanw tis prakseis
                                                                                             //gia na ginei milisecond.
        ring= MediaPlayer.create(MicrowaveIsOn.this,R.raw.ring);


        startTimer();
        PauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mTimerRunning) {
                    pauseTimer();
                    Image.setImageResource(R.drawable.off);
                    Info.setText("ΣΕ ΑΝΑΜΟΝΉ");
                }
                else{
                    startTimer();
                    Image.setImageResource(R.drawable.on);
                    Info.setText("ΣΕ ΛΕΙΤΟΥΡΓΊΑ");
                }
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
                finish();
            }
        });
    }

    private void initializeVriable()
    { PauseButton=(Button) findViewById(R.id.buttonPause);
      BackButton=(Button)findViewById(R.id.butBack);
      Clock=(TextView)findViewById(R.id.ClocktextView);
      Info=(TextView)findViewById(R.id.infoTextView);
      Image=(ImageView)findViewById(R.id.ImageId);
      }

      private void startTimer(){ // apo edw kai katw ksekinaei h diadikasia gia na ftiaksw to xronometro.oles oi monades einais e milisecond
        mCountDownTimer =new CountDownTimer(mTimeLeftInMillis,1000) { //posa lepta exoun apomeinei kai me th ruthmo tha phgainei to xronometro!(1000ms=1s)
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis=millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                   mTimerRunning=false; //edw kanw oti thelw opws teleivsei
                   ring.start();
                   PauseButton.setText("ΕΝΑΡΞΗ");

                   finish();//this closes the activity

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
        String timeLeftFormattedMinutes=String.format("%02d",minutes);
        String timeLeftFormattedSeconds=String.format(":%02d", seconds);
        String timeLeftFormatted=timeLeftFormattedMinutes+timeLeftFormattedSeconds;
        Clock.setTextSize(120);
        Clock.setText(timeLeftFormatted);

    }

}
