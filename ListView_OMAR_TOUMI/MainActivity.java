package com.example.listeviews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list1=(ListView) findViewById(R.id.listep);
        Contact cc1=new Contact("toumi", "omar","0553965847");
        Contact cc2=new Contact("benaddoun", "salim","0664578574");
        Contact cc3=new Contact("toumi", "Anis","0575896587");
        Contact cc4=new Contact("toumi", "yahia","0774152512");
        ArrayList<Contact> list=new ArrayList<Contact>();
        list.add(cc1);
        list.add(cc2);
        list.add(cc3);
        list.add(cc4);

        monAdapter monAdapter = new monAdapter (this,R.layout.activity_contact ,list );
        list1.setAdapter (monAdapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent myIntent = new Intent(MainActivity.this,ListC.class);
                startActivityForResult(myIntent, 0);

            }
        });

    }
}