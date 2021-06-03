package com.example.appuas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BMRCalcActivity extends AppCompatActivity {

    private RadioButton radioButton_maleBMR,radioButton_femaleBMR;
    private EditText editText_ageBMR,editText_weightBMR,editText_heightBMR;
    private TextView textView_outputBMR;
    private Button button_calculateBMR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        getSupportActionBar().setTitle("Calculate My Body");

        radioButton_maleBMR = findViewById(R.id.radioButton_maleBMR);
        radioButton_femaleBMR = findViewById(R.id.radioButton_femaleBMR);
        editText_ageBMR = findViewById(R.id.editText_ageBMR);
        editText_weightBMR = findViewById(R.id.editText_weightBMR);
        editText_heightBMR = findViewById(R.id.editText_heightBMR);
        textView_outputBMR = findViewById(R.id.textView_outputBMR);
        button_calculateBMR = findViewById(R.id.button_calculateBMR);


        button_calculateBMR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String weight = editText_weightBMR.getText().toString();
                String height = editText_heightBMR.getText().toString();
                String age = editText_ageBMR.getText().toString();
                float nilaiBMR;
                int resultBMR;
                if (TextUtils.isEmpty(age)) {
                    editText_ageBMR.setError("Please enter your age");
                }
                if (TextUtils.isEmpty(weight)) {
                    editText_weightBMR.setError("Please enter your weight");
                }
                if (TextUtils.isEmpty(height)) {
                    editText_heightBMR.setError("Please enter your height");
                }

                float weight1 = Float.parseFloat(weight);
                float height1 = Float.parseFloat(height);
                float age1 = Float.parseFloat(age);

                if (radioButton_maleBMR.isChecked()) {
                    nilaiBMR = (float) (66.5 + (weight1 * 13.7) + (5 * height1) - (6.8 * age1));
                    resultBMR = Math.round(nilaiBMR);
                    textView_outputBMR.setText("Your minimum daily calorie requirement is " + resultBMR +" calorie");

                }  else if (radioButton_femaleBMR.isChecked()) {
                    nilaiBMR = (float) (655 + (9.6 * weight1) + (1.8 * height1) - (4.7 * age1));
                    resultBMR = Math.round(nilaiBMR);
                    textView_outputBMR.setText("Your minimum daily calorie requirement is " + resultBMR +" calorie");

                }
            }
        });
    }
}
