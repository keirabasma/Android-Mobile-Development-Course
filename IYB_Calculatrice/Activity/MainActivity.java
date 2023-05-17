package devmob.iyb.tp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton button= findViewById(R.id.calcule);
        AppCompatRadioButton somme= findViewById(R.id.somme);
        AppCompatRadioButton difference= findViewById(R.id.difference);
        AppCompatRadioButton multiplication=findViewById(R.id.mul);
        AppCompatRadioButton division = findViewById(R.id.div);
        AppCompatTextView result= findViewById(R.id.result);
        AppCompatEditText input1= findViewById(R.id.num1);
        AppCompatEditText input2= findViewById(R.id.num2);

        button.setOnClickListener(
                view -> {
                    String text1= input1.getText().toString();
                    String text2= input2.getText().toString();
                    if(!text1.isEmpty()&&!text2.isEmpty()) {
                        double num1=0,num2=0;
                        try {
                             num1 = Double.parseDouble(text1);
                             num2 = Double.parseDouble(text2);
                        }catch(Exception e){
                            Toast.makeText(this,"Cannot do arithmetic operation on letters!!", 1).show();
                        }
                        if (somme.isChecked()) {
                            double sommation=(num1+num2);
                            result.setText( Double.toString(sommation)
                            );

                        } else if (difference.isChecked()) {
                            double soustraction=(num1-num2);
                            result.setText( Double.toString(soustraction)
                            );
                        } else if (multiplication.isChecked()) {
                            double mul=(num1*num2);
                            result.setText( Double.toString(mul)
                            );
                        } else if (division.isChecked()) {
                            try {
                                double div=num1/num2;
                                result.setText(Double.toString(div));
                            }catch(Exception e){
                                Toast.makeText(this,"Error: division failed!",1).show();
                            }

                        }
                    }else{
                        Toast.makeText(this,"Empty field!",1).show();
                    }
                }
        );
    }
}