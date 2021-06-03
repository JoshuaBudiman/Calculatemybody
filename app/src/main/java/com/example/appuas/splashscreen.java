package com.example.appuas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;

public class splashscreen extends AppCompatActivity {

    private int waktuLoading=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().setTitle("Calculate My Body");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home=new Intent(splashscreen.this, MenuActivity.class);
                startActivity(home);
                finish();

            }
        },waktuLoading);
    }
}
