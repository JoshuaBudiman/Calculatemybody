package com.example.appuas;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMICalcActivity  extends AppCompatActivity {

    private EditText editText_weightBMI,editText_heightBMI;
    private TextView TextView_outputBMI;
    private Button button_calculateBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        editText_weightBMI = findViewById(R.id.editText_weightBMI);
        editText_heightBMI = findViewById(R.id.editText_heightBMI);
        TextView_outputBMI = findViewById(R.id.textView_outputBMI);
        button_calculateBMI =findViewById(R.id.button_calculateBMI);

        button_calculateBMI.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String weight = editText_weightBMI.getText().toString().trim();
                String height = editText_heightBMI.getText().toString().trim();
                

                if (!weight.isEmpty() && !height.isEmpty()){
                    float weight1 = Float.parseFloat(weight);
                    float height1 = Float.parseFloat(height) / 100;

                    float nilaiBMI = calculateBMI(weight1, height1);
                    String diagnosa = DiagnosaBMI(nilaiBMI);

                    TextView_outputBMI.setText(nilaiBMI + " - " + diagnosa);
                }else{
                    Toast.makeText(getApplicationContext(), "Please fill in all the data", Toast.LENGTH_SHORT).show();
                }

            }
        });
        editText_weightBMI.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String weight = editText_weightBMI.getText().toString().trim();
                if (weight.isEmpty()) {
                    editText_weightBMI.setError("Please enter your weight");
                }else{
                    editText_weightBMI.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editText_heightBMI.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String height = editText_heightBMI.getText().toString().trim();
                if (height.isEmpty()) {
                    editText_heightBMI.setError("Please enter your height");
                }else{
                    editText_heightBMI.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

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
