package com.example.convertisseur;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtValue;
    private TextView textResult;
    private RadioButton radioCelsiusToFahrenheit;
    private RadioButton radioFahrenheitToCelsius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValue = findViewById(R.id.editValue);
        textResult = findViewById(R.id.textResult);
        radioCelsiusToFahrenheit = findViewById(R.id.radioCelsiusToFahrenheit);
        radioFahrenheitToCelsius = findViewById(R.id.radioFahrenheitToCelsius);

        Button btnConvert = findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }




    private void convert() {
        float inputValue = Float.valueOf(edtValue.getText().toString());
        float result;

        if (radioCelsiusToFahrenheit.isChecked()) {
            result = celsiusToFahrenheit(inputValue);
            textResult.setText(String.valueOf(result));
        } else if (radioFahrenheitToCelsius.isChecked()) {
            result = fahrenheitToCelsius(inputValue);
            textResult.setText(String.valueOf(result));
        }
    }


    private float celsiusToFahrenheit(float celsius) {
        return (celsius * 9/5) + 32;
    }

    private float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

}