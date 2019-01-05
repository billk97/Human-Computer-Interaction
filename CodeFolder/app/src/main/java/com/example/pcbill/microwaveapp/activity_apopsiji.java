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

public class activity_apopsiji extends AppCompatActivity {

    private  Button buttonBack;
    private  Button buttonGoesToMain;
    private SeekBar seekBartime;
    private TextView ApopsijiTimeDisplay;
    private Button StartButton;
    int timi=0;
    int min=0;
    int sec=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apopsiji);
        initializeVariable();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ApopsijiTimeDisplay.setTextColor(Color.BLACK);
        ApopsijiTimeDisplay.setText("00:00");
        seekBartime.setMax(30);
        seekBartime.setProgress(0);
        seekBartime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int ProgressValue, boolean b) {
              timi=ProgressValue;
              min=timi*20/60;
              sec=timi*20%60;
              String minutes=String.format("%02d",min);
              String seconds=String.format(":%02d",sec);
              String finalTime=minutes+seconds;
              ApopsijiTimeDisplay.setTextSize(120);
              ApopsijiTimeDisplay.setText(finalTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timi>0)
                {
                    Intent myIntent = new Intent(view.getContext(),MicrowaveIsOn.class);
                    myIntent.putExtra(Intent.EXTRA_TEXT,timi);
                    startActivityForResult(myIntent,0);

                }
                else
                    {
                        Toast.makeText(getApplicationContext(),"NO time chosen", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        buttonGoesToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                }
        });
    }

    private void initializeVariable()
    {
        buttonBack=(Button) findViewById(R.id.apopsijiBackButton2);
        buttonGoesToMain=(Button)findViewById(R.id.apopsijilinformationMain);
        StartButton=(Button) findViewById(R.id.apopsijiStart);
        seekBartime=(SeekBar) findViewById(R.id.apopsijiTimeBar);
        ApopsijiTimeDisplay=(TextView)findViewById(R.id.apopsijiTimeDisplay);
    }
}
