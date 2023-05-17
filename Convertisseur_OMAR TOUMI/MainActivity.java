package com.example.convertisseur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValue;
    private RadioGroup radioGroupConversion;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue = findViewById(R.id.editTextValue);
        radioGroupConversion = findViewById(R.id.radioGroupConversion);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertValue();
            }
        });
    }

    private void convertValue() {
        String valueString = editTextValue.getText().toString().trim();
        if (valueString.isEmpty()) {
            textViewResult.setText("Veuillez entrer une valeur valide.");
            return;
        }

        double value = Double.parseDouble(valueString);

        int selectedId = radioGroupConversion.getCheckedRadioButtonId();
        if (selectedId == R.id.radioButtonDinarToEuro) {
            double euroAmount = value / 2.2; // Conversion factice pour l'exemple
            textViewResult.setText(String.format("%.2f euros", euroAmount));
        } else if (selectedId == R.id.radioButtonEuroToDinar) {
            double dinarAmount = value * 2.2; // Conversion factice pour l'exemple
            textViewResult.setText(String.format("%.2f dinars", dinarAmount));
        } else {
            textViewResult.setText("Veuillez choisir une direction de conversion.");
        }
    }
}
