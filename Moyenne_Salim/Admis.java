package com.example.moyenne;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Admis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associe le layout activity_second à cette activité
        setContentView(R.layout.activity_admis);

        // Récupère l'objet TextView qui affichera le résultat
        TextView textViewMoyenne = findViewById(R.id.textViewMoyenne);

        // Récupère l'intent qui a lancé cette activité
        Intent intent = getIntent();

        // Récupère le double qui a été transmis dans l'intent sous la clé "doubleNumber"
        // Si aucun double n'a été transmis, la valeur par défaut 0 sera utilisée
        double doubleValue = intent.getDoubleExtra("doubleNumber", 0);

        // Affiche le résultat dans l'objet TextView
        textViewMoyenne.setText("" + doubleValue);
    }
    // Méthode appelée lorsque le bouton Retour est cliqué
    public void onRetourClick(View v) {
        // Retourne à l'interface précédente
        onBackPressed();
    }
}