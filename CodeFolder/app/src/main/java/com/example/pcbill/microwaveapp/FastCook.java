package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class FastCook extends AppCompatActivity {

    private Button buttonBack;
    private SeekBar seekBartime;
    private TextView FastCookTimeDisplay;
    private Button StartButton;
    int timi=0;
    int min=0;
    int sec=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_cook);
        initializerVariable();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(myIntent,0);
            }
        });
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),MicrowaveIsOn.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, timi); // edw stelnw th timh pou lamvanw apo th mpara gia thw wra;
                startActivityForResult(myIntent,0);
            }
        });
        FastCookTimeDisplay.setText("00:00");
        seekBartime.setMax(30);
        seekBartime.setProgress(0);
        seekBartime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int ProgressValue, boolean b) {
                timi= ProgressValue;
                min= timi*20/60;
                sec=timi*20%60;
                String minutes=String.format("%02d",min);
                String seconds=String.format(":%02d", sec);//to xrhsimopoiw gia thn wra
                String finalTime=minutes+seconds;
                FastCookTimeDisplay.setText(finalTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    private void  initializerVariable()
    {
        buttonBack=(Button)findViewById(R.id.FatCookBack);
        StartButton=(Button)findViewById(R.id.FatCookStart);
        seekBartime=(SeekBar) findViewById(R.id.FastCookSeekBar);
        FastCookTimeDisplay=(TextView)findViewById(R.id.FastCookTimeDisplay);

    }
}
