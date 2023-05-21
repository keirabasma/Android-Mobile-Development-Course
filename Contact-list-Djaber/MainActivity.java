import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.EditText;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list1=(ListView) findViewById(R.id.simpleListView);
        ContactDetailsActivity cc1=new ContactDetailsActivity("moh_1", "med","0999999999");
        ContactDetailsActivity cc2=new ContactDetailsActivity("moh_2", "med","0888888888");
        ContactDetailsActivity cc3=new ContactDetailsActivity("moh_3", "med","0555555555");
        ContactDetailsActivity cc4=new ContactDetailsActivity("moh_4", "med","0222222222");
        ArrayList<ContactDetailsActivity> mylist=new ArrayList<>();
        mylist.add(cc1); mylist.add(cc2);mylist.add(cc3); mylist.add(cc4);
        Adapter customAdapter = new Adapter(getApplicationContext(), mylist);
        list1.setAdapter(customAdapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent myIntent = new Intent(MainActivity.this, ListActivity.class);
                startActivityForResult(myIntent, 0);
            }});}}