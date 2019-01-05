package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpaghettiProgram extends AppCompatActivity {

    Button BackSpaButton;
    Button MainSpaButton;
    Button ProgramSpaButton;
    Button FirstChoiceSpaButton;
    Button SecondChoiceSpaButton;
    Button ThirdChoiceSpaButton;
    Button FourthChoiceSpaButton;
    Button StartSpaButton;
    TextView info;
    int timi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spaghetti_programm);
        initializeVriable();
        info.setTextColor(Color.BLACK);

        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);
        info.setTextSize(30);
        info.setTextColor(Color.BLACK);
        info.setText(text);

        BackSpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        StartSpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MicrowaveIsOn.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, timi); // edw stelnw th timh pou lamvanw apo th mpara gia thw wra;
                startActivityForResult(myIntent, 0);
            }
        });

        FirstChoiceSpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeButtonDefalult();
                blackButton(FirstChoiceSpaButton);
                timi=2;

            }
        });
        SecondChoiceSpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeButtonDefalult();
                blackButton(SecondChoiceSpaButton);
                timi=4;

            }
        });
        ThirdChoiceSpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeButtonDefalult();
                blackButton(ThirdChoiceSpaButton);
                timi=6;
            }
        });
        FourthChoiceSpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeButtonDefalult();
                blackButton(FourthChoiceSpaButton);
                timi=8;
            }
        });
        MainSpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent myIntent = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(myIntent,0);
            }
        });
        ProgramSpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void initializeVriable()
    {
        BackSpaButton=(Button) findViewById(R.id.SpaBackButton);
        MainSpaButton=(Button) findViewById(R.id.spahgetiMainButton);
        ProgramSpaButton=(Button) findViewById(R.id.spaghetiProgramButton);
        FirstChoiceSpaButton=(Button) findViewById(R.id.buttonFirstChoiceSpa);
        SecondChoiceSpaButton=(Button) findViewById(R.id.buttonSecondChoiceSpa);
        ThirdChoiceSpaButton=(Button) findViewById(R.id.buttonThirdChoiceSpa);
        FourthChoiceSpaButton=(Button) findViewById(R.id.buttonFourthChoiceSpa);
        StartSpaButton=(Button) findViewById(R.id.buttonStartSpa);
        info=(TextView) findViewById(R.id.informationSpaghetti);



    }

    private void makeButtonDefalult(){
        FirstChoiceSpaButton.setBackgroundResource(android.R.drawable.btn_default);
        FirstChoiceSpaButton.setTextColor(Color.BLACK);
        SecondChoiceSpaButton.setBackgroundResource(android.R.drawable.btn_default);
        SecondChoiceSpaButton.setTextColor(Color.BLACK);
        ThirdChoiceSpaButton.setBackgroundResource(android.R.drawable.btn_default);
        ThirdChoiceSpaButton.setTextColor(Color.BLACK);
        FourthChoiceSpaButton.setBackgroundResource(android.R.drawable.btn_default);
        FourthChoiceSpaButton.setTextColor(Color.BLACK);
    }
    private  void blackButton(Button button)
    {
        button.setBackgroundColor(Color.BLACK) ;
        button.setTextColor(Color.WHITE);

    }
}
