import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText number1EditText;
    private EditText number2EditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1Input = number1EditText.getText().toString();
                String number2Input = number2EditText.getText().toString();

                try {
                    double number1 = Double.parseDouble(number1Input);
                    double number2 = Double.parseDouble(number2Input);
                    double average = (number1 + number2) / 2;

                    resultTextView.setText("Average: " + average);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input! Please enter valid numbers.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
