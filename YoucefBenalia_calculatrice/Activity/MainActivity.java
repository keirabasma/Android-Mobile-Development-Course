package com.example.youcefcalcu;




import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText1;
    private EditText mEditText2;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = findViewById(R.id.edit_1);
        mEditText2 = findViewById(R.id.edit_2);
        mTextView = findViewById(R.id.resultTextView);
    }

    public void displayMessage(View view) {
        // retrieve the values entered by the user in the EditTexts
        String strNum1 = mEditText1.getText().toString();
        String strNum2 = mEditText2.getText().toString();

        // check if the EditTexts are empty
        if (TextUtils.isEmpty(strNum1) || TextUtils.isEmpty(strNum2)) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        // retrieve the selected radio button
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // check if an operator has been selected
        if (selectedId == -1) {
            Toast.makeText(this, "Please select an operator", Toast.LENGTH_SHORT).show();
            return;
        }

        // convert the values to double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // perform the calculation based on the selected radio button
        double result = 0;
        switch (selectedId) {
            case R.id.radioButton:
                result = num1 + num2;
                break;
            case R.id.radioButton2:
                result = num1 - num2;
                break;
            case R.id.radioButton3:
                result = num1 * num2;
                break;
            case R.id.radioButton4:
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        // update the TextView with the result
        mTextView.setText("Résultat : " + result);
    }

}