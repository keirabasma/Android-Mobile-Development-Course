package com.example.listeview;

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
        ContactDetailsActivity cc1=new ContactDetailsActivity("Benaddoun", "Salim","0559240653");
        ContactDetailsActivity cc2=new ContactDetailsActivity("Toumi", "Omar","0673995911");
        ContactDetailsActivity cc3=new ContactDetailsActivity("Addoun", "Mohammed","0784230415");
        ContactDetailsActivity cc4=new ContactDetailsActivity("Benyakoub", "Yazzid","0568452231");
        ArrayList<ContactDetailsActivity> mylist=new ArrayList<>();
        mylist.add(cc1);
        mylist.add(cc2);
        mylist.add(cc3);
        mylist.add(cc4);

        Adapter customAdapter = new Adapter(getApplicationContext(), mylist);
        list1.setAdapter(customAdapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent myIntent = new Intent(MainActivity.this, ListActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }}