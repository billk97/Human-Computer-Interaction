package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class regulate_cook extends AppCompatActivity {

    private Button RegulateStartButton;
    private Button RegulateBackButton;
    private TextView RegulateTimeDisplay;
    private TextView RegulateTempDisplay;
    private SeekBar RegulateTimeBar;
    private SeekBar RegulateTempBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regulate_cook);
        initializeVriable();

        /*back button's fuction*/
        RegulateBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        /*display time*/
        RegulateTimeDisplay.setText("00:00");
        /*to control the seek bar*/
        RegulateTimeBar.setMax(30);
        RegulateTimeBar.setProgress(0);
        RegulateTimeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int timi = 0;
            int min = 0;
            int sec = 0;

            @Override
            public void onProgressChanged(SeekBar RegulateTimeBar, int progresValue, boolean b) {
                timi = progresValue;
                min = timi * 20 / 60;
                sec = timi * 20 % 60;
                if (sec == 0) {
                    if (min != 10) {
                        RegulateTimeDisplay.setText("0" + min + ":" + sec + "0");
                    } else {
                        RegulateTimeDisplay.setText(min + ":" + sec + "0");
                    }
                } else {
                    RegulateTimeDisplay.setText("0" + min + ":" + sec);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar RegulateTimeBar) {
                // Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar ReguTimeBar) {
                //  Toast.makeText(getApplicationContext(), "Stopped tracking seekbar" +timi, Toast.LENGTH_SHORT).show();
                //to bug ap kato
            }

        });

        /**controling the data for the temperature  **/
        RegulateTempDisplay.setText("0");//initializing samething for the begining
        RegulateTempBar.setMax(10);//setting max temp
        RegulateTempBar.setProgress(0);//setting min temp
        /**the most important part
         * initializing temp and printing on textView the result of the action on the bar**/
        RegulateTempBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int temp =0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                temp=progressValue;
                RegulateTempDisplay.setText(" "+temp*80);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void initializeVriable()
    {
        RegulateStartButton=(Button) findViewById(R.id.RegulateCookStartButton);
        RegulateBackButton = (Button) findViewById(R.id.RegulateCookBackButton);
        RegulateTimeDisplay=(TextView) findViewById(R.id.RegulateCookTimeDisplay);
        RegulateTempDisplay=(TextView)findViewById(R.id.RegulateCookTempDisplay);
        RegulateTimeBar=(SeekBar) findViewById(R.id.RegulateCookTimeBar);
        RegulateTempBar=(SeekBar)findViewById(R.id.RegulateCookTempBar);
    }

}
