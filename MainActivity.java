package com.example.moyen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText note1EditText, note2EditText, note3EditText;
    private Button calculerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1EditText = findViewById(R.id.note1_edittext);
        note2EditText = findViewById(R.id.note2_edittext);
        note3EditText = findViewById(R.id.note3_edittext);
        calculerButton = findViewById(R.id.calculer_button);

        calculerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note1 = note1EditText.getText().toString();
                String note2 = note2EditText.getText().toString();
                String note3 = note3EditText.getText().toString();

                if (TextUtils.isEmpty(note1) || TextUtils.isEmpty(note2) || TextUtils.isEmpty(note3)) {
                    // Afficher une alerte
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Erreur");
                    builder.setMessage("Veuillez saisir toutes les notes");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    // Calcule moyenne
                    double moyenne = (Double.parseDouble(note1) + Double.parseDouble(note2) + Double.parseDouble(note3)) / 3;

                    if (moyenne > 10) {
                        //Ouvrir l'interface Réussite
                        Intent intent = new Intent(MainActivity.this, ReussiteActivity.class);
                        intent.putExtra("moyenne", moyenne);
                        startActivity(intent);
                    } else {
                        //Ouvrir l'interface Recalé
                        Intent intent = new Intent(MainActivity.this, RecaleActivity.class);
                        intent.putExtra("moyenne", moyenne);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
