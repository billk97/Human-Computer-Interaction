package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MicroPrograms extends AppCompatActivity {

    Button SpaghettiButton;
    Button mainButton;
    Button FishButton;
    Button RiseButton;
    Button ChickenButton;
    Button VegetableButton;
    Button PotatoeButton;
    Button MeatButton;
    Button LiquidButton;
    Button BackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_programs);
        initializeVriable();





        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SpaghettiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToPass="ΖΥΜΑΡΙΚΑ";
                Intent myIntent = new Intent(v.getContext(), SpaghettiProgram.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivityForResult(myIntent, 0);
            }
        });

        FishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToPass="ΨΑΡΙ";
                Intent myIntent = new Intent(v.getContext(), SpaghettiProgram.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivityForResult(myIntent, 0);
            }
        });

       RiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToPass="ΡΥΖΙ";
                Intent myIntent = new Intent(v.getContext(), SpaghettiProgram.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivityForResult(myIntent, 0);
            }
        });

        ChickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToPass="ΚΟΤΟΠΟΥΛΟ";
                Intent myIntent = new Intent(v.getContext(), SpaghettiProgram.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivityForResult(myIntent, 0);
            }
        });

        VegetableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToPass="ΛΑΧΑΝΙΚΑ";
                Intent myIntent = new Intent(v.getContext(), SpaghettiProgram.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivityForResult(myIntent, 0);
            }
        });

        PotatoeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToPass="ΠΑΤΑΤΕΣ";
                Intent myIntent = new Intent(v.getContext(), SpaghettiProgram.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivityForResult(myIntent, 0);
            }
        });

        MeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToPass="ΚΡΕΑΣ";
                Intent myIntent = new Intent(v.getContext(), SpaghettiProgram.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivityForResult(myIntent, 0);
            }
        });
        LiquidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToPass="ΥΓΡΑ";
                Intent myIntent = new Intent(v.getContext(), SpaghettiProgram.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivityForResult(myIntent, 0);
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initializeVriable()
    {
        BackButton=(Button) findViewById(R.id.MicroProgramsBackButton);
        mainButton=(Button) findViewById(R.id.microMainButton);
        SpaghettiButton=(Button) findViewById(R.id.buttonSpagheti);
        FishButton=(Button) findViewById(R.id.buttonFish);
        RiseButton=(Button) findViewById(R.id.buttonRise);
        ChickenButton=(Button) findViewById(R.id.buttonChicken);
        VegetableButton=(Button) findViewById(R.id.buttonVegetables);
        PotatoeButton=(Button) findViewById(R.id.buttonPotatoe);
        MeatButton=(Button) findViewById(R.id.buttonMeat);
        LiquidButton=(Button) findViewById(R.id.buttonLiquid);

    }
}
