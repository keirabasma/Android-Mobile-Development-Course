package com.example.convertisseur_temp_abdelkader;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.convertisseur_temp_abdelkader.CelsiusFahrenheitConverter;
import com.example.convertisseur_temp_abdelkader.FahrenheitCelsiusConverter;

public class MainActivity extends AppCompatActivity {
    private EditText inputTemperature;
    private Button btnCelsiusToFahrenheit;
    private Button btnFahrenheitToCelsius;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTemperature = findViewById(R.id.input_temperature);
        btnCelsiusToFahrenheit = findViewById(R.id.btn_celsius_to_fahrenheit);
        btnFahrenheitToCelsius = findViewById(R.id.btn_fahrenheit_to_celsius);
        resultTextView = findViewById(R.id.result_text_view);

        btnCelsiusToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsiusToFahrenheit();
            }
        });

        btnFahrenheitToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFahrenheitToCelsius();
            }
        });
    }

    private void convertCelsiusToFahrenheit() {
        String input = inputTemperature.getText().toString();
        if (input.isEmpty()) {
            resultTextView.setText("Veuillez entrer une valeur de température.");
            return;
        }

        double celsius = Double.parseDouble(input);
        double fahrenheit = CelsiusFahrenheitConverter.convertCelsiusToFahrenheit(celsius);

        resultTextView.setText(String.format("%.2f °F", fahrenheit));
    }

    private void convertFahrenheitToCelsius() {
        String input = inputTemperature.getText().toString();
        if (input.isEmpty()) {
            resultTextView.setText("Veuillez entrer une valeur de température.");
            return;
        }

        double fahrenheit = Double.parseDouble(input);
        double celsius = FahrenheitCelsiusConverter.convertFahrenheitToCelsius(fahrenheit);

        resultTextView.setText(String.format("%.2f °C", celsius));
    }
}
