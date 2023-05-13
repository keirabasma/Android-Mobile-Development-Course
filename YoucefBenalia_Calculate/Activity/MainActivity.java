package com.example.team01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNote1, editTextNote2, editTextNote3;
    private Button buttonCalculer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNote1 = findViewById(R.id.editText1);
        editTextNote2 = findViewById(R.id.editText2);
        editTextNote3 = findViewById(R.id.editText3);
        buttonCalculer = findViewById(R.id.button_calculer);

        buttonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note1 = editTextNote1.getText().toString().trim();
                String note2 = editTextNote2.getText().toString().trim();
                String note3 = editTextNote3.getText().toString().trim();

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
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("moyenne", moyenne);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                        intent.putExtra("moyenne", moyenne);
                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Les notes doivent être des nombres", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}