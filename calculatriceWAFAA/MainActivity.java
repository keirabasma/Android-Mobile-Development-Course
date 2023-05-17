package com.example.revis1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num2N ,num1N;
    private TextView ResN;
    private Button addN,sousN,multN,divN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1N = findViewById(R.id.num1);
        num2N = findViewById(R.id.num2);
        ResN = findViewById(R.id.Res);

        addN = findViewById(R.id.addButton);
        sousN = findViewById(R.id.sousButton);
        multN = findViewById(R.id.multButton);
        divN = findViewById(R.id.divButton);


        addN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcule('+');
            }
        });

        sousN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcule('-');
            }
        });

        multN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcule('*');
            }
        });

        divN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcule('/');
            }
        });
    }
    private void calcule (char oper){
        String valr1 = num1N.getText().toString();
        String valr2 = num2N.getText().toString();

        if (valr1.isEmpty() || valr2.isEmpty()){
            ResN.setText("veillez entrer deux nombres");
            return;
        }else {
            try{
                double val1 =  Double.parseDouble(valr1);
                double val2 = Double.parseDouble(valr2);
                double resultat;

                switch (oper){
                    case '+':
                        resultat = val1 + val2;
                        break;
                    case '-':
                        resultat = val1 - val2 ;
                        break;
                    case '*':
                        resultat = val1 * val2;
                        break;
                    case '/':
                        if (val2 == 0){
                            ResN.setText("division par 0");
                            return;
                        }else {
                        resultat = val1 / val2 ;
                        break;}
                    default: ResN.setText("operation non valide");
                    return;
                }
                ResN.setText(String.valueOf(resultat));
            }catch (NumberFormatException e){
                ResN.setText("entrer des chiffre valide");
            }
        }
    }
}