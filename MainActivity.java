package com.example.tp_calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText num1View = new EditText(this);
    EditText num2View = new EditText(this);

    RadioGroup radioGroup = new RadioGroup(this);
    RadioButton add = new RadioButton(this);
    RadioButton sub = new RadioButton(this);
    RadioButton mult = new RadioButton(this);
    RadioButton div = new RadioButton(this);

    TextView resultView = new TextView(this);

    Button calcul = new Button(this);
    boolean isKeyboardOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1View.findViewById(R.id.editTextNumber1);
        num2View.findViewById(R.id.editTextNumber2);
        radioGroup.findViewById(R.id.radioGroup);
        add.findViewById(R.id.radioButtonAdd);
        sub.findViewById(R.id.radioButtonSub);
        mult.findViewById(R.id.radioButtonMul);
        div.findViewById(R.id.radioButtonDiv);
        resultView.findViewById(R.id.textViewResult);
        calcul.findViewById(R.id.buttonCalculate);

        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int x = Integer.parseInt(num1View.getText().toString());
                    int y = Integer.parseInt(num2View.getText().toString());

                    int result = 0;

                    if (add.isChecked()) {
                        result = x + y;
                    } else if (sub.isChecked()) {
                        result = x - y;
                    } else if (mult.isChecked()) {
                        result = x * y;
                    } else if (div.isChecked()) {
                        if (y == 0) {
                            resultView.setText("La division par zéro est impossible");
                            return;
                        } else {
                            result = x / y;
                        }
                    } else {
                        resultView.setText("Sélectionnez une opération");
                        return;
                    }

                    resultView.setText(String.format("result = %d", result));

                    if (isKeyboardOpen) {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(num2View.getWindowToken(), 0);
                        isKeyboardOpen = false;
                    }
                }catch (NumberFormatException e){
                    Toast.makeText(this, "Saisissez un nombre entier valide", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        num2View.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                isKeyboardOpen = hasFocus;
            }
        });
    }
}