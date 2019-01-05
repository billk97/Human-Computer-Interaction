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
import android.widget.SeekBar.OnSeekBarChangeListener;
//bill
public class Grill_Activity extends AppCompatActivity {

    private  Button buttonBack;
    private  Button buttonToMain;
    private SeekBar seekBartime;
    private TextView GrillTimeDisplay;
    private TextView GrillTempDisplay;
    private SeekBar seekBarTemp;
    private Button GrillStartButton;
    int timi = 0;
    int min=0;
    int sec=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grill_);
        initializeVriable();
        GrillTempDisplay.setTextColor(Color.BLACK);
        GrillTimeDisplay.setTextColor(Color.BLACK);

        /*backButton function*/
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*displaing 00:00*/
        GrillTimeDisplay.setText("00:00");
        /*to controle the seek bar*/
        seekBartime.setMax(30);
        seekBartime.setProgress(0);
        seekBartime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBartime, int progresValue, boolean b) {
                timi = progresValue;
                min=timi*20/60;
                sec=timi*20%60;
                String minutes=String.format("%02d",min); //%02d einai akriveia 2 dekadikvn psifion dgladh to 1 to kanei 01
                String seconds=String.format(":%02d", sec);//to xrhsimopoiw gia thn wra
                String finalTime=minutes+seconds;
                GrillTimeDisplay.setTextSize(120);
                GrillTimeDisplay.setText(finalTime);



            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBartime) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBartime) {

            }
        });
        /**controling the data for the temperature  **/
        GrillTempDisplay.setText("200");//initializing samething for the begining
        seekBarTemp.setMax(10);//setting max temp
        seekBarTemp.setProgress(2);//setting min temp
        /**the most important part
         * initializing temp and printing on textView the result of the action on the bar**/
        seekBarTemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int temp =0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                temp=progressValue;
                GrillTempDisplay.setTextSize(120);
                GrillTempDisplay.setText(" "+temp*80);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        GrillStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timi>0)
                {
                    Intent myIntent = new Intent(v.getContext(), MicrowaveIsOn.class);
                    myIntent.putExtra(Intent.EXTRA_TEXT, timi); // edw stelnw th timh pou lamvanw apo th mpara gia thw wra;
                    startActivityForResult(myIntent, 0);
                }
                else
                    {
                        Toast.makeText(getApplicationContext(),"NO time chosen", Toast.LENGTH_SHORT).show();
                    }


            }
        });
        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    /**initializing the interface**/
    private void initializeVriable()
    {
        buttonBack=(Button) findViewById(R.id.GrillBackButton);
        buttonToMain=(Button) findViewById(R.id.grillButtonMain);
        seekBartime = (SeekBar) findViewById(R.id.GrillTimeBar);
        GrillTimeDisplay=(TextView) findViewById(R.id.GrillTimeDisplay);
        GrillTempDisplay=(TextView)findViewById(R.id.GrillTempDisplay);
        seekBarTemp=(SeekBar) findViewById(R.id.GrillTempBar);
        GrillStartButton=(Button)findViewById(R.id.GrillButtonStart);
    }
}
