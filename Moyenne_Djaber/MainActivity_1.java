import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText edit_E_2,edit_E_1,edit_e;
    private Button buttonN;
    private TextView textView2T;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        edit_E_2 = findViewById(R.id.editText2);
        edit_E_1 =findViewById(R.id.editText1);
        edit_e = findViewById(R.id.EditText);
        Button buttonN = findViewById(R.id.button);
        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String N_1Value = edit_e.getText().toString().trim();
                String N_2Value = edit_E_1 .getText().toString().trim();
                String N_3Value = edit_E_2.getText().toString().trim();
                if (N_1Value.isEmpty() || N_2Value.isEmpty() || N_3Value.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Must entre values", Toast.LENGTH_SHORT).show(); return;}
                try {
                    float N_1Value = Float.parseFloat(N_1Value);
                    float N_2Value = Float.parseFloat(N_2Value);
                    float N_3Value = Float.parseFloat(N_3Value);
                    float moyenne = (N_1Value + N_2Value + N_3Value) / 3;
                    if (moyenne >= 10) {
                        Intent intent = new Intent(MainActivity.this,resultats.class);
                        intent.putExtra("Moynne", Moyenne);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, resultat2.class);
                        intent.putExtra("Mouynne", Moyenne);
                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Nombres", Toast.LENGTH_SHORT).show();
                }
            }
   });
 }
}