package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText entree;
    RadioButton dinarToEuro, euroToDinar;
    TextView resultat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entree = findViewById(R.id.entree);
        dinarToEuro = findViewById(R.id.dinar_to_euro);
        euroToDinar = findViewById(R.id.euro_to_dinar);
        resultat = findViewById(R.id.resultat);
    }

    public void convertir(View view) {
        String entreeText = entree.getText().toString();

        if (entreeText.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Champs Manquant")
                    .setMessage("Vous devez insérer une valeur à convertir !!!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return;
        }
        float valeurInitiale = Float.parseFloat(entreeText);
        float valeurConvertie;

        if (dinarToEuro.isChecked()) {
            valeurConvertie = dinarToEuro(valeurInitiale);
        } else {
            valeurConvertie = euroToDinar(valeurInitiale);
        }

        resultat.setText(String.valueOf(valeurConvertie));
    }

    private float dinarToEuro(float valeurDinar) {
        return (float) (valeurDinar * 0.0071);
    }

    private float euroToDinar(float valeurEuro) {
        return (float) (valeurEuro * 140.45);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Conversion Dinar <-> Dollar");
        menu.add(0, 2, 0, "Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                // Laisser vide pour le moment
                break;
            case 2:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}