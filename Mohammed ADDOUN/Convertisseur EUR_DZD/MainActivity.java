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
    private RadioButton radioDinarToEuro;
    private RadioButton radioEuroToDinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValue = findViewById(R.id.editValue);
        textResult = findViewById(R.id.textResult);
        radioDinarToEuro = findViewById(R.id.radioDinarToEuro);
        radioEuroToDinar = findViewById(R.id.radioEuroToDinar);

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

        if (radioDinarToEuro.isChecked()) {
            result = dinarsToEuro(inputValue);
            textResult.setText(String.valueOf(result));
        } else if (radioEuroToDinar.isChecked()) {
            result = euroToDinar(inputValue);
            textResult.setText(String.valueOf(result));
        }
    }

    private float dinarsToEuro(float valeurDinar) {
        return (float) (valeurDinar *0.0071 );
    }

    private float euroToDinar(float valeurEuro) {
        return (float) (valeurEuro * 140.45);
    }
}