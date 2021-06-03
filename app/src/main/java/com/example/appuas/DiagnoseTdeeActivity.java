package com.example.appuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiagnoseTdeeActivity extends AppCompatActivity {

    private Intent intent;
    private TextView diagnose_textview_yourtdee,diagnose_textview_weightloss,diagnose_textview_weightgain;
    private Button backtomenu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_tdee);

        diagnose_textview_yourtdee = findViewById(R.id.diagnose_textview_yourtdee);
        diagnose_textview_weightloss = findViewById(R.id.diagnose_textview_weightloss);
        diagnose_textview_weightgain = findViewById(R.id.diagnose_textview_weightgain);
        backtomenu_button = findViewById(R.id.backtomenu_button);
        intent = getIntent();

        String TDEE = intent.getStringExtra("TDEE");
        String WeightLoss = intent.getStringExtra("WeightLoss");
        String WeightGainMin = intent.getStringExtra("WeightGainMin");
        String WeightGainMax = intent.getStringExtra("WeightGainMax");

        diagnose_textview_yourtdee.setText(TDEE + " Cal/day");
        diagnose_textview_weightloss.setText(WeightLoss +" Cal/day");
        diagnose_textview_weightgain.setText(WeightGainMin+"-"+WeightGainMax+" Cal/day");

        backtomenu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DiagnoseTdeeActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}