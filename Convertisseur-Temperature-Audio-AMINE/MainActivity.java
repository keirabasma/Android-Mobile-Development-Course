package fr.amineaitm.convertisseur_temperature;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;


public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperature;
    private RadioGroup radioGroupUnit;
    private RadioButton radioButtonCelsius;
    private RadioButton radioButtonFahrenheit;
    private Button buttonConvert;
    private TextView textViewResult;
    private MediaPlayer mediaPlayer; // Déclaration de la variable MediaPlayer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextTemperature = findViewById(R.id.editTextTemperature);
        radioGroupUnit = findViewById(R.id.radioGroupUnit);
        radioButtonCelsius = findViewById(R.id.radioButtonCelsius);
        radioButtonFahrenheit = findViewById(R.id.radioButtonFahrenheit);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        // Set click listener for the convert button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
                playAudio();
            }
        });
    }

    private void playAudio() {
        mediaPlayer = MediaPlayer.create(this, R.raw.i_mean_its_alright_meme_sound_effect);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer resources
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void convertTemperature() {
        // Get the temperature from the edit text
        String temperatureString = editTextTemperature.getText().toString();

        if (!temperatureString.isEmpty()) {
            // Convert the temperature based on the selected unit
            double temperature = Double.parseDouble(temperatureString);
            double convertedTemperature;

            if (radioButtonCelsius.isChecked()) {
                // Convert Celsius to Fahrenheit
                convertedTemperature = (temperature * 9 / 5) + 32;
            } else {
                // Convert Fahrenheit to Celsius
                convertedTemperature = (temperature - 32) * 5 / 9;
            }

            // Display the result and set the text color based on the temperature
            textViewResult.setText(String.format("%.2f", convertedTemperature));

            if (convertedTemperature >= 100) {
                textViewResult.setTextColor(Color.RED);
            } else if (convertedTemperature >= 80) {
                textViewResult.setTextColor(Color.YELLOW);
            } else if (convertedTemperature <= 0) {
                textViewResult.setTextColor(Color.BLUE);
            } else {
                textViewResult.setTextColor(Color.BLACK);
            }
        } else {
            // Clear the result if the input is empty
            textViewResult.setText("");
            textViewResult.setTextColor(Color.BLACK);
        }
    }
}
