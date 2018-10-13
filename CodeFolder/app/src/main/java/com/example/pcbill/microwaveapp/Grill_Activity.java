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
//bill
public class Grill_Activity extends AppCompatActivity {

    private  Button buttonBack;
    private SeekBar seekBartime;
    private TextView GrillTimeDisplay;
    private TextView GrillTempDisplay;
    private SeekBar seekBarTemp;
    private Button GrillStartButton;

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
        /**controling the data for the temperature  **/
        GrillTempDisplay.setText("0000");//initializing samething for the begining
        seekBarTemp.setMax(10);//setting max temp
        seekBarTemp.setProgress(0);//setting min temp
        /**the most important part
         * initializing temp and printing on textView the result of the action on the bar**/
        seekBarTemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int temp =0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                temp=progressValue;
                GrillTempDisplay.setText(" "+temp+"00");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    /**initializing the interface**/
    private void initializeVriable()
    {
        buttonBack=(Button) findViewById(R.id.GrillBackButton);
        seekBartime = (SeekBar) findViewById(R.id.GrillTimeBar);
        GrillTimeDisplay=(TextView) findViewById(R.id.GrillTimeDisplay);
        GrillTempDisplay=(TextView)findViewById(R.id.GrillTempDisplay);
        seekBarTemp=(SeekBar) findViewById(R.id.GrillTempBar);
        GrillStartButton=(Button)findViewById(R.id.GrillButtonStart);
    }
}
