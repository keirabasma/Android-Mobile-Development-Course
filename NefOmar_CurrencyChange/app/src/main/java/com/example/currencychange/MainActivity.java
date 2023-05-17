package com.example.currencychange;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText montantEdit;
    private RadioButton euroToDzdRadio;
    private RadioButton dzdToEuroRadio;
    private TextView resultatText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        montantEdit = findViewById(R.id.edit_montant);
        euroToDzdRadio = findViewById(R.id.radio_eur_to_dzd);
        dzdToEuroRadio = findViewById(R.id.radio_dzd_to_eur);
        resultatText = findViewById(R.id.text_resultat);

        Button convertButton = findViewById(R.id.button_convert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });

        // Enregistrement des boutons radio dans le menu contextuel
        registerForContextMenu(euroToDzdRadio);
        registerForContextMenu(dzdToEuroRadio);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.radio_eur_to_dzd) {
            menu.setHeaderTitle("Taux dinar -> euro");
            menu.add(Menu.NONE, 0, Menu.NONE, "Afficher le taux");
        } else if (v.getId() == R.id.radio_dzd_to_eur) {
            menu.setHeaderTitle("Taux euro -> dinar");
            menu.add(Menu.NONE, 1, Menu.NONE, "Afficher le taux");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            Toast.makeText(this, "Taux dinar -> euro : 1 DZD = 0.0071 EUR", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == 1) {
            Toast.makeText(this, "Taux euro -> dinar : 1 EUR = 140.45 DZD", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private float dinarsToEuro(float valeurDinar) {
        return (float) (valeurDinar * 0.0071);
    }

    private float euroToDinars(float valeurEuro) {
        return (float) (valeurEuro * 140.45);
    }

    private void convertir() {
        float montant = Float.parseFloat(montantEdit.getText().toString());
        float resultat;

        if (euroToDzdRadio.isChecked()) {
            resultat = euroToDinars(montant);
            resultatText.setText("Résultat de la conversion : " + resultat + " DZD");
        } else if (dzdToEuroRadio.isChecked()) {
            resultat = dinarsToEuro(montant);
            resultatText.setText("Résultat de la conversion : " + resultat + " EUR");
        }
    }
}