package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.réponse);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Saisissez un numéro", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            try {
                return Integer.parseInt(editText.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Saisissez un nombre entier valide", Toast.LENGTH_SHORT).show();
                return 0;
            }
        }
    }

    @Override
    public void onClick(View view) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        try {
            switch (view.getId()) {
                case R.id.btn_add:
                    textView.setText("Réponse = " + (num1 + num2));
                    break;

                case R.id.btn_sub:
                    textView.setText("Réponse = " + (num1 - num2));
                    break;

                case R.id.btn_mul:
                    textView.setText("Réponse = " + (num1 * num2));
                    break;

                case R.id.btn_div:
                    if (num2 == 0) {
                        Toast.makeText(this, "Division par zéro impossible", Toast.LENGTH_SHORT).show();
                    } else {
                        textView.setText("Réponse = " + ((float) num1 / (float) num2));
                    }
                    break;
            }
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Erreur de calcul", Toast.LENGTH_SHORT).show();
        }
    }
}
