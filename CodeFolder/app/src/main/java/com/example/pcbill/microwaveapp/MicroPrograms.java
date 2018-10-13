package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MicroPrograms extends AppCompatActivity {

    Button SpaghettiButton;
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
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });


    }

    private void initializeVriable()
    {
        BackButton=(Button) findViewById(R.id.buttonBack);
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
