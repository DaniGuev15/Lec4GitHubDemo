package com.example.wtcalcdemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Calculator Demo";
    TextView txtViewResults;
    EditText editTextInputWt;
    Button btnConvertWt;
    RadioGroup radioGroupCvt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_wt_round);
        actionBar.setTitle(R.string.txtTitle);

        txtViewResults = findViewById(R.id.txtViewResults);
        editTextInputWt = findViewById(R.id.editTextInputWt);
        radioGroupCvt = findViewById(R.id.radioGroupCvt);
        btnConvertWt = findViewById(R.id.btnConvertWt);

        btnConvertWt.setOnClickListener((View view) -> {

            if (radioGroupCvt.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please choose Conversion Type", Toast.LENGTH_SHORT).show();
            } else {
                double inputWt =0, outputWt=0;
                try {
                    inputWt = Double.parseDouble(editTextInputWt.getText().toString());
                    if (inputWt <= 0) {
                        Toast.makeText(this, "Input Weight must be > 0", Toast.LENGTH_SHORT).show();
                    } else if(radioGroupCvt.getCheckedRadioButtonId() == R.id.radioBtConvertKgtoLbs){
                        if (inputWt>500){
                            Toast.makeText(this, "Input Weight must be < 500", Toast.LENGTH_SHORT).show();
                        } else {
                            outputWt = inputWt * 2.2;
                            txtViewResults.setText(String.format("Converted wt: %.2f", outputWt));
                        }
                    } else if (radioGroupCvt.getCheckedRadioButtonId()== R.id.radioBtConvertKg) {
                        if (inputWt>1000){
                            Toast.makeText(this, "Input Weight must be < 1000", Toast.LENGTH_SHORT).show();
                        } else {
                            outputWt = inputWt / 2.2;
                            txtViewResults.setText(String.format("Converted wt: %.2f", outputWt));
                        }

                    }


                } catch (Exception ex){
                    ex.printStackTrace();
                    Log.d("WT DEMO", ex.getMessage());
                }
            }
        });

    }
}