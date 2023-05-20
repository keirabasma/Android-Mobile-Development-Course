package com.example.convertisseur_temp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText celsiusInput = findViewById(R.id.celsiusInput);
        Button convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double celsius = Double.parseDouble(celsiusInput.getText().toString());
                double fahrenheit = celsius * 9/5 + 32;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("FAHRENHEIT", fahrenheit);
                startActivity(intent);
            }
        });
    }
}