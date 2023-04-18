package com.example.moyennecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText2E,editText1E,EditTextE;
    private Button buttonN;
    private TextView textView2T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText2E = findViewById(R.id.editText2);
        editText1E =findViewById(R.id.editText1);
        EditTextE = findViewById(R.id.EditText);

        Button buttonN = findViewById(R.id.button);

        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note1 = EditTextE.getText().toString().trim();
                String note2 = editText1E .getText().toString().trim();
                String note3 = editText2E.getText().toString().trim();

                if (note1.isEmpty() || note2.isEmpty() || note3.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show();
                    return;

                }
                try {
                    float note1Value = Float.parseFloat(note1);
                    float note2Value = Float.parseFloat(note2);
                    float note3Value = Float.parseFloat(note3);
                    float moyenne = (note1Value + note2Value + note3Value) / 3;

                    if (moyenne >= 10) {
                        Intent intent = new Intent(MainActivity.this,resultats.class);
                        intent.putExtra("moyenne", moyenne);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, resultat2.class);
                        intent.putExtra("moyene", moyenne);
                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "SVP les notes doivent etre des nombres", Toast.LENGTH_SHORT).show();
                }
            }
   });
 }
}