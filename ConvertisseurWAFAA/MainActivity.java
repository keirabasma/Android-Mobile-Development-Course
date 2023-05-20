package com.example.convertisseur;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText Maonais;
    private RadioButton b1, b2;
    private TextView resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Maonais = findViewById(R.id.nbtmp);
        b1 = findViewById(R.id.rButton);
        b2 = findViewById(R.id.rButton2);
        btn = findViewById(R.id.convertir);
        resultat = findViewById(R.id.resu);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float Mn = Float.parseFloat(Maonais.getText().toString());

                if (b1.isChecked()) {
                    EuroToDinar(Mn);
                } else {
                    DinarToEuro(Mn);
                }
            }
        });
    }

    private void DinarToEuro(float Monais) {
        Double result = (Monais * 0.0071);
        resultat.setText("Le résultat est " + result + "Euro");
    }

    private void EuroToDinar(float Monais) {

        Double result = (Monais * 140.45);
        resultat.setText("Le résultat est " + result + " DA");
    }
}
