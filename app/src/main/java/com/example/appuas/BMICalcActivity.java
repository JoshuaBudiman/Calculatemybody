package com.example.appuas;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalcActivity  extends AppCompatActivity {

    private EditText editText_weightBMI,editText_heightBMI;
    private TextView TextView_outputBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().setTitle("Calculate My Body");
        editText_weightBMI = findViewById(R.id.editText_weightBMI);
        editText_heightBMI = findViewById(R.id.editText_heightBMI);
        TextView_outputBMI = findViewById(R.id.textView_outputBMI);

        findViewById(R.id.button_calculateBMI).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String weight = editText_weightBMI.getText().toString();
                String height = editText_heightBMI.getText().toString();

                if (TextUtils.isEmpty(weight)) {
                    editText_weightBMI.setError("Please enter your weight");
                    return;
                }
                if (TextUtils.isEmpty(height)) {
                    editText_heightBMI.setError("Please enter your height");
                    return;
                }
                float weight1 = Float.parseFloat(weight);
                float height1 = Float.parseFloat(height) / 100;

                float nilaiBMI = calculateBMI(weight1, height1);
                String diagnosa = DiagnosaBMI(nilaiBMI);

                TextView_outputBMI.setText(nilaiBMI + " - " + diagnosa);
            }
        });
    }

    private float calculateBMI(float weight, float height) {
        return (weight / (height * height));
    }

    private String DiagnosaBMI(float nilaiBMI) {
        if (nilaiBMI < 17) {
            return "Severely underweight";

        } else if (nilaiBMI < 18.5) {
            return "Underweight";

        } else if (nilaiBMI < 25) {
            return "Normal";

        } else if (nilaiBMI < 28) {
            return "Overweight";

        } else if (nilaiBMI < 35) {
            return "Obese";

        } else if (nilaiBMI < 40) {
            return "Very obese";

        } else {
            return "Extremely obese";
        }
    }
}
