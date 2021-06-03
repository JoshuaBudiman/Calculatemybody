package com.example.appuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Intent intent;
    private Button button_tdee, button_bmi, button_bmr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setTitle("Calculate My Body");

        button_bmi = findViewById(R.id.button_bmi);
        button_tdee = findViewById(R.id.button_tdee);
        button_bmr = findViewById(R.id.button_bmr);

        button_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuActivity.this, BMICalcActivity.class);
                startActivity(intent);
            }
        });
        button_tdee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuActivity.this, TDEECalcActivity.class);
                startActivity(intent);
            }
        });
        button_bmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuActivity.this, BMRCalcActivity.class);
                startActivity(intent);
            }
        });
    }
}
