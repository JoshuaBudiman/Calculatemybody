package com.example.appuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class TDEECalcActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RadioButton radioButton_male_tdee,radioButton_female_tdee;
    private EditText editText_ageTDEE,editText_weightTDEE,editText_heightTDEE;
    private Spinner spinner_tdee;
    private Button button_calculateTDEE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdee);
        getSupportActionBar().setTitle("Calculate My Body");

        radioButton_male_tdee = findViewById(R.id.radioButton_male_tdee);
        radioButton_female_tdee = findViewById(R.id.radioButton_female_tdee);
        editText_ageTDEE = findViewById(R.id.editText_ageTDEE);
        editText_weightTDEE = findViewById(R.id.editText_weightTDEE);
        editText_heightTDEE = findViewById(R.id.editText_heightTDEE);
        button_calculateTDEE = findViewById(R.id.button_calculateTDEE);
        spinner_tdee = findViewById(R.id.spinner_tdee);

        String[] activity_text = getResources().getStringArray(R.array.exercise);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, activity_text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tdee.setAdapter(adapter);

        button_calculateTDEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = editText_weightTDEE.getText().toString().trim();
                String height = editText_heightTDEE.getText().toString().trim();
                String age = editText_ageTDEE.getText().toString().trim();
                String act = spinner_tdee.getSelectedItem().toString();
                float nilaiact = CekActivity(act);
                float berat = Float.parseFloat(weight);
                float tinggi = Float.parseFloat(height);
                float umur = Float.parseFloat(age);
                float nilaiTDEE =0;
                int resultTDEE;
                int loseTDEE;
                int GainMinTDEE;
                int GainMaxTDEE;

                if (radioButton_male_tdee.isChecked()){
                    nilaiTDEE = (float) (66.5 + (berat * 13.7) + (5 * tinggi) - (6.8 * umur)) * nilaiact;
                }else if (radioButton_female_tdee.isChecked()){
                    nilaiTDEE = (float) (655 + (9.6 * berat) + (1.8 * tinggi) - (4.7 * umur)* nilaiact);
                }
                resultTDEE = Math.round(nilaiTDEE);
                loseTDEE = (int) (resultTDEE - (resultTDEE*0.2));
                GainMinTDEE= resultTDEE+200;
                GainMaxTDEE= resultTDEE+300;

                String TDEE = String.valueOf(resultTDEE);
                String WeightLoss = String.valueOf(loseTDEE);
                String WeightGainMin = String.valueOf(GainMinTDEE);
                String WeightGainMax = String.valueOf(GainMaxTDEE);
                if (radioButton_male_tdee.isChecked() && !weight.isEmpty() && !height.isEmpty() && !age.isEmpty() || radioButton_female_tdee.isChecked() && !weight.isEmpty() && !height.isEmpty() && !age.isEmpty()){
                    Intent intent = new Intent(getBaseContext(), DiagnoseTdeeActivity.class);
                    intent.putExtra("TDEE", TDEE);
                    intent.putExtra("WeightLoss", WeightLoss);
                    intent.putExtra("WeightGainMin", WeightGainMin);
                    intent.putExtra("WeightGainMax", WeightGainMax);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner_tdee){
            String ValueFromSpinner = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public float CekActivity(String exercise){
        float NilaiAct =0;
        if(exercise.equalsIgnoreCase("Sedentary (little or no exercise)")){
            NilaiAct= (float) 1.2;
        }else if(exercise.equalsIgnoreCase("Lightly active (1-3 hours of exercise per week)")){
            NilaiAct= (float) 1.375;
        }else if (exercise.equalsIgnoreCase("Moderately active (4-6 hours of exercise per week)")){
            NilaiAct= (float) 1.55;
        }else if (exercise.equalsIgnoreCase("Very active (7-9 hours of exercise per week)")){
            NilaiAct= (float) 1.725;
        }else if(exercise.equalsIgnoreCase("Highly active (10+ hours of exercise per week)")){
            NilaiAct= (float) 1.9;
        }
        return NilaiAct;}
}