package com.example.dineuroconv;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText dinarInput;
    private Button convertButton;
    private TextView euroOutput;
    private RadioGroup unitSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unitSelection = findViewById(R.id.unit_selection);
        dinarInput = findViewById(R.id.dinar_input);
        convertButton = findViewById(R.id.convert_button);
        euroOutput = findViewById(R.id.euro_output);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = unitSelection.getCheckedRadioButtonId();
                int euroAmount = 0 ;
                int dinarAmount =  Integer.parseInt((dinarInput.getText().toString()));
                if (selectedId == R.id.celsius_button) {
                    euroAmount = (dinarAmount - 32) * 5 / 9;

                } else if (selectedId == R.id.fahrenheit_button) {
                    euroAmount = (dinarAmount * 9 / 5) + 32;
                }
                euroOutput.setText(Integer.toString(euroAmount));
            }
        });
    }
}
