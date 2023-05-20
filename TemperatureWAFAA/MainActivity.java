package com.example.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button bout;
    private EditText tmp;
    private RadioButton b1, b2;
    private TextView resut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tmp = findViewById(R.id.nbtmp);
        b1 = findViewById(R.id.rButton);
        b2 = findViewById(R.id.rButton2);
        bout = findViewById(R.id.convertir);
        resut = findViewById(R.id.resu);

        bout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float temperature = Float.parseFloat(tmp.getText().toString());

                if (b1.isChecked()) {
                    fehrenCelsius(temperature);
                } else {
                    celsiusFahrenheit(temperature);
                }
            }
        });
    }

    private void fehrenCelsius(float temperature) {
        float result = (temperature - 32) * 5 / 9;
        resut.setText("Le résultat est " + result + " °C");
    }

    private void celsiusFahrenheit(float temperature) {
        float result = (temperature * 9 / 5) + 32;
        resut.setText("Le résultat est " + result + " °F");
    }
}
