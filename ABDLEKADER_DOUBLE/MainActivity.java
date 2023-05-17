package com.example.tp2_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText inputNumber = findViewById(R.id.input_number);
        TextView result = findViewById(R.id.result);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String inputString = inputNumber.getText().toString();
                double input = Double.parseDouble(inputString);
                double doubled = input * 2;
                result.setText("LE DOUBLE DE : " + inputString + " EST " + doubled);
            }
        });

    }
}
