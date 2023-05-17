package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText val1, val2;
    private TextView res;
    private Button btnSomme, btnDifference, btnMultiplication, btnDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = (EditText) findViewById(R.id.val1);
        val2 = (EditText) findViewById(R.id.val2);
        res = (TextView) findViewById(R.id.res);
        btnSomme = (Button) findViewById(R.id.btn_somme);
        btnDifference = (Button) findViewById(R.id.btn_difference);
        btnMultiplication = (Button) findViewById(R.id.btn_multiplication);
        btnDivision = (Button) findViewById(R.id.btn_division);

        btnSomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(val1.getText().toString());
                float number2 = Float.parseFloat(val2.getText().toString());
                float resultat = number1 + number2;
                res.setText(String.valueOf(resultat));
            }
        });

        btnDifference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(val1.getText().toString());
                float number2 = Float.parseFloat(val2.getText().toString());
                float resultat = number1 - number2;
                res.setText(String.valueOf(resultat));
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(val1.getText().toString());
                float number2 = Float.parseFloat(val2.getText().toString());
                float resultat = number1 * number2;
                res.setText(String.valueOf(resultat));
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(val1.getText().toString());
                float number2 = Float.parseFloat(val2.getText().toString());

                if (number2 != 0) {
                    float resultat = number1 / number2;
                    res.setText(String.valueOf(resultat));
                } else {
                    res.setText("Division par zéro interdite");
                }
            }
        });
    }
}
