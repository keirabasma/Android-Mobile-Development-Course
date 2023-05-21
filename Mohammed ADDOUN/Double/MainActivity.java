package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText champ1;
    private Button button1;
    private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        champ1 =(EditText) findViewById(R.id.editText1);
        button1=(Button) findViewById(R.id.button1);
        textView1=(TextView) findViewById(R.id.textView1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(champ1.getText().toString());
                double result = Double_it(num1);
                textView1.setText(Double.toString(result));
            }
            private double Double_it(double num1){
                double result=0;
                result= num1 * 2;
                return result;
            }

        });
    }
}