package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Grill_Activity extends AppCompatActivity {

    private  Button buttonBack;
    private SeekBar seekBartime;
    private TextView GrillTimeDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grill_);
        initializeVriable();

        /*backButton function*/
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        /*displaing 00:00*/
        GrillTimeDisplay.setText("00:00");
        /*to controle the seek bar*/
        seekBartime.setMax(10);
        seekBartime.setProgress(0);
        seekBartime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int timi = 0;
            @Override
            public void onProgressChanged(SeekBar seekBartime, int progresValue, boolean b) {
                timi = progresValue;
               // System.out.print("i:"+i);
               // Toast.makeText(getApplicationContext(),"changing seekbar progress",Toast.LENGTH_SHORT).show();
                GrillTimeDisplay.setText("00:"+timi+"0");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBartime) {
               // Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBartime) {
              //  Toast.makeText(getApplicationContext(), "Stopped tracking seekbar" +timi, Toast.LENGTH_SHORT).show();
               //to bug ap kato
            }
        });
    }
    // arxikopoiiseis metabliton mazemenes
    private void initializeVriable()
    {
        buttonBack=(Button) findViewById(R.id.GrillBackButton);
        seekBartime = (SeekBar) findViewById(R.id.GrillTimeBar);
        GrillTimeDisplay=(TextView) findViewById(R.id.GrillTimeDisplay);
    }
}
