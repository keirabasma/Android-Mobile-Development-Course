import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText numberEditText;
    private Button doubleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText = findViewById(R.id.numberEditText);
        doubleButton = findViewById(R.id.doubleButton);

        doubleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = numberEditText.getText().toString();
                try {
                    double number = Double.parseDouble(input);
                    double result = number * 2;
                    Toast.makeText(MainActivity.this, "Double value: " + result, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input! Please enter a valid number.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
