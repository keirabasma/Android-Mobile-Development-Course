
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edit_v;
    private TextView result;
    private RadioButton r_CelsiusToFahrenheit;
    private RadioButton r_FahrenheitToCelsius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edit_v = findViewById(R.id.editValue);
        result = findViewById(R.id.result);


        r_CelsiusToFahrenheit = findViewById(R.id.r_CelsiusToFahrenheit);
        r_FahrenheitToCelsius = findViewById(R.id.r_FahrenheitToCelsius);

        Button btnConvert = findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });}
        private void convert() {
        float inputValue = Float.valueOf(edit_v.getText().toString());
        float result;

        if (r_CelsiusToFahrenheit.isChecked()) {
            result = celsiusToFahrenheit(inputValue);
            result.setText(String.valueOf(result));
        } else if (r_FahrenheitToCelsius.isChecked()) {
            result = fahrenheitToCelsius(inputValue);
            result.setText(String.valueOf(result));
            }
        }
        private float celsiusToFahrenheit(float celsius) {
            return (celsius * 9/5) + 32;
        }

        private float fahrenheitToCelsius(float fahrenheit) {
            return (fahrenheit - 32) * 5/9;
        }

    }