package com.example.convertisseurt;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText entree;
    RadioButton celsiusToFahrenheit, fahrenheitToCelsius;
    TextView resultat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entree = findViewById(R.id.entree);
        celsiusToFahrenheit = findViewById(R.id.celsius_to_fahrenheit);
        fahrenheitToCelsius = findViewById(R.id.fahrenheit_to_celsius);
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

        double valeurInitiale = Double.parseDouble(entreeText);
        double valeurConvertie;

        if (celsiusToFahrenheit.isChecked()) {
            valeurConvertie = celsiusToFahrenheit(valeurInitiale);
        } else {
            valeurConvertie = fahrenheitToCelsius(valeurInitiale);
        }

        resultat.setText(String.valueOf(valeurConvertie));
    }


    private double celsiusToFahrenheit(double valeurCelsius) {
        return (valeurCelsius * 9/5) + 32;
    }

    private double fahrenheitToCelsius(double valeurFahrenheit) {
        return (valeurFahrenheit - 32) * 5/9;
    }

}

