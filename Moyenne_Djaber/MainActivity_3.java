import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Locale;
public class resultats extends AppCompatActivity {
    private TextView moyennee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        moyennee = findViewById(R.id.textView4);
        float moyenne= getIntent().getFloatExtra("moyenne",0);
        moyennee.setText(String.format(Locale.getDefault(),"%.2f",moyenne));}}