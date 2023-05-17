
package com.example.tp4r;

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
        Contact cc1=new Contact("RABAH", "Lotfi","0560739037");
        Contact cc2=new Contact("HADJALI", "Saadi","0559921749");
        Contact cc3=new Contact("WONDERWOMAN", "Belgacem","0550514399");
        Contact cc4=new Contact("RABAH", "Zineddine","0568455521");
        ArrayList<Contact> mylist=new ArrayList<>();
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