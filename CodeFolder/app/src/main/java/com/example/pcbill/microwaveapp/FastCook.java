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

public class FastCook extends AppCompatActivity {


    private Button buttonBack;
    private Button buttonToMain;
    private SeekBar seekBartime;
    private TextView FastCookTimeDisplay;
    private Button StartButton;
    int timi=0;
    int min=0;
    int sec=0;
    //comment


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_cook);
        initializerVariable();
        FastCookTimeDisplay.setTextColor(Color.BLACK);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timi>0)
                {
                    Intent myIntent = new Intent(view.getContext(),MicrowaveIsOn.class);
                    myIntent.putExtra(Intent.EXTRA_TEXT, timi); // edw stelnw th timh pou lamvanw apo th mpara gia thw wra;
                    startActivityForResult(myIntent,0);
                }
                else
                    {
                        Toast.makeText(getApplicationContext(),"NO time chosen", Toast.LENGTH_SHORT).show();
                    }



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
                FastCookTimeDisplay.setTextSize(120);
                FastCookTimeDisplay.setText(finalTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
    private void  initializerVariable()
    {
        buttonToMain=(Button) findViewById(R.id.buttonToMain);
        buttonBack=(Button)findViewById(R.id.FatCookBack);
        StartButton=(Button)findViewById(R.id.FatCookStart);
        seekBartime=(SeekBar) findViewById(R.id.FastCookSeekBar);
        FastCookTimeDisplay=(TextView)findViewById(R.id.FastCookTimeDisplay);

    }
}
