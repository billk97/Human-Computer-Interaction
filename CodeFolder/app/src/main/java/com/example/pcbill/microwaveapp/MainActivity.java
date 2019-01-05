package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView timeText;
    Button buttonRythmisiPsisimatos;
    Button buttonGrill;
    Button buttonApopsiksi;
    Button buttonGrigoriThermansi;
    Button buttonEtoimaProgrammata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Me ayto to tropo orizw to textview ths wras kai me to thread poy ftiaxnw
        //moy alazei h wra symfwna me to roloi tou kinhtoy
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                timeText=(TextView) findViewById(R.id.timeText);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                                String dateString = sdf.format(date);
                                timeText.setTextColor(Color.BLACK); //this is green color
                                timeText.setTextSize(120);
                                timeText.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();









        buttonRythmisiPsisimatos=(Button) findViewById(R.id.RythmisiPsisimatosButton);

       buttonRythmisiPsisimatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), regulate_cook.class);
                startActivityForResult(myIntent, 0);
            }
        });
        //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi rithmisi psisimatos


        buttonGrill=(Button) findViewById(R.id.GrillButton);

       buttonGrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Grill_Activity.class);
                startActivityForResult(myIntent, 0);
            }
        });
         //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi Grill

        buttonApopsiksi=(Button) findViewById(R.id.ApopsiksiButton);

       buttonApopsiksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), activity_apopsiji.class);
                startActivityForResult(myIntent, 0);
            }
        });
        //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi Apopsiksi

        buttonGrigoriThermansi=(Button) findViewById(R.id.GrigoriThermansiButton);

        buttonGrigoriThermansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), FastCook.class);
                startActivityForResult(myIntent, 0);
            }
        });
         //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi grhgorh thermansi

        buttonEtoimaProgrammata=(Button) findViewById(R.id.EtoimaProgrammataButton);

        buttonEtoimaProgrammata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MicroPrograms.class);
                startActivityForResult(myIntent, 0);
            }
        });
        //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi etoima programmata





    }



}
