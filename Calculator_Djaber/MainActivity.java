import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inputFirstNumber, inputSecondNumber;
    TextView labelResult;
    Button addButton, subtractButton, multiplyButton, divideButton, calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                                                          // Get references to views
         inputFirstNumber = findViewById(R.id.input_first_number);
        inputSecondNumber = findViewById(R.id.input_second_number);
        labelResult = findViewById(R.id.label_result);
        addButton = findViewById(R.id.button_add);
         subtractButton = findViewById(R.id.button_subtract);
        multiplyButton = findViewById(R.id.button_multiply);
        divideButton = findViewById(R.id.button_divide);
         calculateButton = findViewById(R.id.button_calculate);

                    
                                                                        
// listeners for buttons
            addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
                case R.id.button_add:
                performCalculation('+'); break;
               
                case R.id.button_subtract:
                performCalculation('-'); break;
               
                case R.id.button_multiply:
                performCalculation('*');break;
                
                case R.id.button_divide:
                performCalculation('/');break;
                
                case R.id.button_calculate:
                performCalculation();break;
                }
    }

// Get input values
    private void performCalculation() {
        
        double firstNumber, secondNumber;
        try {
            firstNumber = Double.parseDouble(inputFirstNumber.getText().toString());
            secondNumber = Double.parseDouble(inputSecondNumber.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            return;
        }


 // Calculate result
        double result = 0;
        String operator = "";
        if (addButton.isSelected()) {
            result = firstNumber + secondNumber;
            operator = "+";
        } else if (subtractButton.isSelected()) {
            result = firstNumber - secondNumber;
            operator = "-";
        } else if (multiplyButton.isSelected()) {
            result = firstNumber * secondNumber;
            operator = "*";
        } else if (divideButton.isSelected()) {
            if (secondNumber == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            result = firstNumber / secondNumber;
            operator = "/";
        }





                    // this section to Display result
        labelResult.setText(firstNumber + " " + operator + " " + secondNumber + " = " + result);
    }

    private void performCalculation(char operator) {

             // here to Get input values
        double firstNumber, secondNumber;
        try {
            firstNumber = Double.parseDouble(inputFirstNumber.getText().toString());
            secondNumber = Double.parseDouble(inputSecondNumber.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            return;
        }

             // Calculate result  with exception of division by zero
        double result = 0;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber
                break;
            case '/':
                if (secondNumber == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = firstNumber / secondNumber;
                break;
        }

                         // Display result
        labelResult.setText(firstNumber + " " + operator + " " + secondNumber + " = " + result);
    }