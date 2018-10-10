package com.example.pcbill.microwaveapp;

import android.content.Intent;
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
        DateFormat df = new SimpleDateFormat("HH:mm");   // me afto to tropo
        Date dateobj = new Date();                              // pairnw thn wra
        timeText=(TextView) findViewById(R.id.timeText);        //orizw to text view gia thn wra
        timeText.setText(String.valueOf(df.format(dateobj)));   //etsi emfanizw thn wra

        buttonRythmisiPsisimatos=(Button) findViewById(R.id.RythmisiPsisimatosButton);

      /*  buttonRythmisiPsisimatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ****.class);
                startActivityForResult(myIntent, 0);
            }
        });
        */ //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi rithmisi psisimatos


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

      /*  buttonApopsiksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ****.class);
                startActivityForResult(myIntent, 0);
            }
        });
        */ //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi Apopsiksi

        buttonGrigoriThermansi=(Button) findViewById(R.id.GrigoriThermansiButton);

      /*  buttonGrigoriThermansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ****.class);
                startActivityForResult(myIntent, 0);
            }
        });
        */ //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi grhgorh thermansi

        buttonEtoimaProgrammata=(Button) findViewById(R.id.EtoimaProgrammataButton);

      /*  buttonEtoimaProgrammata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ****.class);
                startActivityForResult(myIntent, 0);
            }
        });
        */ //edw perimenei na tou grapsoume se poia diepafh tha paei meta to koympi etoima programmata





    }



}
