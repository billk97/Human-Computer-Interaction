package com.example.pcbill.microwaveapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MicrowaveIsOn extends AppCompatActivity {
    Button PauseButton;
    Button BackButton;
    TextView Clock;
    TextView Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microwave_is_on);
        initializeVriable();

        PauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(PauseButton.getText().equals("ΠΑΥΣΗ")) {
                    PauseButton.setText("ΕΝΑΡΞΗ");
                }
                else{
                    PauseButton.setText("ΠΑΥΣΗ");
                }
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initializeVriable()
    { PauseButton=(Button) findViewById(R.id.buttonPause);
      BackButton=(Button)findViewById(R.id.butBack);
      Clock=(TextView)findViewById(R.id.ClocktextView);
      Info=(TextView)findViewById(R.id.infoTextView);



    }
}
