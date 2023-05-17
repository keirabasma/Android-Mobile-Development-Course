package com.example.degre_convert;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private TextView resultTextView;
    private RadioButton toFahrenheitRadioButton;
    private RadioButton toCelsiusRadioButton;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.input_edit_text);
        resultTextView = findViewById(R.id.result_text_view);
        toFahrenheitRadioButton = findViewById(R.id.fahrenheit_radio_button);
        toCelsiusRadioButton = findViewById(R.id.celsius_radio_button);
        convertButton = findViewById(R.id.convert_button);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String inputValue = inputEditText.getText().toString();

        if (inputValue.isEmpty()) {
            Toast.makeText(this, "Please enter a value.", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputTemperature = Double.parseDouble(inputValue);

        if (toFahrenheitRadioButton.isChecked()) {
            double result = (inputTemperature * 9 / 5) + 32;
            resultTextView.setText(String.format(getString(R.string.result_format), result));
        } else if (toCelsiusRadioButton.isChecked()) {
            double result = (inputTemperature - 32) * 5 / 9;
            resultTextView.setText(String.format(getString(R.string.result_format), result));
        } else {
            Toast.makeText(this, "Please select a conversion option.", Toast.LENGTH_SHORT).show();
        }
    }
}
