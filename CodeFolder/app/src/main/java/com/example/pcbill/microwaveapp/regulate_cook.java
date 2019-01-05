package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class regulate_cook extends AppCompatActivity {

    private Button RegulateStartButton;
    private Button RegulateMainButton;
    private Button RegulateBackButton;
    private TextView RegulateTimeDisplay;
    private TextView RegulateTempDisplay;
    private SeekBar RegulateTimeBar;
    private SeekBar RegulateTempBar;
    int timi = 0;
    int min = 0;
    int sec = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regulate_cook);
        initializeVriable();
        RegulateTempDisplay.setTextColor(Color.BLACK);
        RegulateTimeDisplay.setTextColor(Color.BLACK);

        /*back button's fuction*/
        RegulateBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*start button s fuction */
        RegulateStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timi>0)
                {
                    Intent myIntent = new Intent(v.getContext(), MicrowaveIsOn.class);
                    myIntent.putExtra(Intent.EXTRA_TEXT, timi); // edw stelnw th timh pou lamvanw apo th mpara gia thw wra;
                    startActivityForResult(myIntent, 0);
                }
                else {Toast.makeText(getApplicationContext(),"NO time chosen", Toast.LENGTH_SHORT).show();}



            }
        });

        /*display time*/
        RegulateTimeDisplay.setTextSize(120);
        RegulateTimeDisplay.setText("00:00");
        /*to control the seek bar*/
        RegulateTimeBar.setMax(30);
        RegulateTimeBar.setProgress(0);
        RegulateTimeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar RegulateTimeBar, int progresValue, boolean b) {
                timi = progresValue;
                min = timi * 20 / 60;
                sec = timi * 20 % 60;
                String minutes=String.format("%02d",min); //%02d einai akriveia 2 dekadikvn psifion dgladh to 1 to kanei 01
                String seconds=String.format(":%02d", sec);//to xrhsimopoiw gia thn wra
                String finalTime=minutes+seconds;
                RegulateTimeDisplay.setText(finalTime);

            }

            @Override
            public void onStartTrackingTouch(SeekBar RegulateTimeBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar ReguTimeBar) {

            }

        });

        /**controling the data for the temperature  **/
        RegulateTempDisplay.setTextSize(120);
        RegulateTempDisplay.setText("200");//initializing samething for the begining
        RegulateTempBar.setMax(10);//setting max temp
        RegulateTempBar.setProgress(2);//setting min temp
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
        RegulateMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void initializeVriable()
    {
        RegulateStartButton=(Button) findViewById(R.id.RegulateCookStartButton);
        RegulateMainButton=(Button) findViewById(R.id.regulatMainButton);
        RegulateBackButton = (Button) findViewById(R.id.RegulateCookBackButton);
        RegulateTimeDisplay=(TextView) findViewById(R.id.RegulateCookTimeDisplay);
        RegulateTempDisplay=(TextView)findViewById(R.id.RegulateCookTempDisplay);
        RegulateTimeBar=(SeekBar) findViewById(R.id.RegulateCookTimeBar);
        RegulateTempBar=(SeekBar)findViewById(R.id.RegulateCookTempBar);
    }

}
