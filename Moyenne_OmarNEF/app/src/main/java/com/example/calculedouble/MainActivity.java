package com.example.calculedouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText note1EditText, note2EditText, note3EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des EditText pour les notes
        note1EditText = findViewById(R.id.editText1);
        note2EditText = findViewById(R.id.editText2);
        note3EditText = findViewById(R.id.editText3);

        // Récupération du bouton de calcul
        Button calculateButton = findViewById(R.id.button1);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage(v);
            }
        });
    }

    public void calculateAverage(View view) {
        // Récupération des trois notes
        double note1 = Double.parseDouble(note1EditText.getText().toString());
        double note2 = Double.parseDouble(note2EditText.getText().toString());
        double note3 = Double.parseDouble(note3EditText.getText().toString());

        // Calcul de la moyenne
        double moyenne = (note1 + note2 + note3) / 3;

        // Création de l'Intent pour afficher l'Activity suivante en fonction de la moyenne
        Intent intent;
        if (moyenne >= 10) {
            intent = new Intent(this, SuccessActivity.class);
        } else {
            intent = new Intent(this, FailureActivity.class);
        }

        // Ajout de la moyenne à l'Intent
        intent.putExtra("moyenne", moyenne);

        // Affichage de l'Activity suivante
        startActivity(intent);
    }
}
