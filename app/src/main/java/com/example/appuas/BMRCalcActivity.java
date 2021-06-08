package com.example.appuas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class BMRCalcActivity extends AppCompatActivity {

    private RadioButton radioButton_maleBMR,radioButton_femaleBMR;
    private TextInputLayout textInputLayout_age_bmr, textInputLayout_weight_bmr, textInputLayout_height_bmr;
    private TextView textView_outputBMR;
    private Button button_calculateBMR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        getSupportActionBar().setTitle("Calculate My Body");

        radioButton_maleBMR = findViewById(R.id.radioButton_maleBMR);
        radioButton_femaleBMR = findViewById(R.id.radioButton_femaleBMR);
        textInputLayout_age_bmr = findViewById(R.id.textInputLayout_age_bmr);
        textInputLayout_weight_bmr = findViewById(R.id.textInputLayout_weight_bmr);
        textInputLayout_height_bmr = findViewById(R.id.textInputLayout_height_bmr);
        textView_outputBMR = findViewById(R.id.textView_outputBMR);
        button_calculateBMR = findViewById(R.id.button_calculateBMR);


        button_calculateBMR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String weight = textInputLayout_weight_bmr.getEditText().getText().toString().trim();
                String height = textInputLayout_height_bmr.getEditText().getText().toString().trim();
                String age = textInputLayout_age_bmr.getEditText().getText().toString().trim();


                if (radioButton_maleBMR.isChecked() || radioButton_femaleBMR.isChecked() && !age.isEmpty() && !height.isEmpty() && !weight.isEmpty()){
                    float nilaiBMR=0;
                    int resultBMR;


                    float weight1 = Float.parseFloat(weight);
                    float height1 = Float.parseFloat(height);
                    float age1 = Float.parseFloat(age);

                    if (radioButton_maleBMR.isChecked()) {
                        nilaiBMR = (float) (66.5 + (weight1 * 13.7) + (5 * height1) - (6.8 * age1));
                    }  else if (radioButton_femaleBMR.isChecked()) {
                        nilaiBMR = (float) (655 + (9.6 * weight1) + (1.8 * height1) - (4.7 * age1));
                    }
                    resultBMR = Math.round(nilaiBMR);
                    textView_outputBMR.setText("Your minimum daily calorie requirement is " + resultBMR +" calorie");
                }else{
                    Toast.makeText(getApplicationContext(), "Please fill in all the data", Toast.LENGTH_SHORT).show();
                }

            }
        });
        textInputLayout_age_bmr.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String age = textInputLayout_age_bmr.getEditText().getText().toString().trim();
                if (age.isEmpty()) {
                    textInputLayout_age_bmr.setError("Please enter your age");
                }else {
                    textInputLayout_age_bmr.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textInputLayout_weight_bmr.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String weight = textInputLayout_weight_bmr.getEditText().getText().toString().trim();
                if (weight.isEmpty()) {
                    textInputLayout_weight_bmr.setError("Please enter your weight");
                }else {
                    textInputLayout_weight_bmr.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textInputLayout_height_bmr.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String height = textInputLayout_height_bmr.getEditText().getText().toString().trim();
                if (height.isEmpty()) {
                    textInputLayout_height_bmr.setError("Please enter your height");
                }else{
                    textInputLayout_height_bmr.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
