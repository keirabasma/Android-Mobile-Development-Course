package com.example.moyenne;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3;
    private Button buttonCalculer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        buttonCalculer = findViewById(R.id.button_calculer);

        buttonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // Récupérer les valeurs saisies par l'utilisateur
                //Supprime les espaces en début et en fin de chaîne. Les valeurs récupérées sont stockées dans le
                String s1 = editText1.getText().toString().trim();
                String s2 = editText2.getText().toString().trim();
                String s3 = editText3.getText().toString().trim();

                // Vérifier que les champs ne sont pas vides
                if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez entrer trois valeurs", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    // Calculer la moyenne
                    double result = (Double.parseDouble(s1) + Double.parseDouble(s2) + Double.parseDouble(s3)) / 3;

                    // Créer une intention pour passer la moyenne à l'activité suivante
                    Intent intent;

                    if (result >= 10) {
                        intent = new Intent(getApplicationContext(), Admis.class);
                    } else {
                        intent = new Intent(getApplicationContext(), Ajourné.class);
                    }

                    intent.putExtra("doubleNumber", result);
                    startActivity(intent);
                }
            }
        });
    }
}