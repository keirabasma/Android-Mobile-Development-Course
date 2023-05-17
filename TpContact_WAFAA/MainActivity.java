package com.example.contacte;

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
        Contact cc1=new Contact("Mekbal", "wafaa","0554090756");
        Contact cc2=new Contact("Mekbal", "ayoub","0665843690");
        Contact cc3=new Contact("Zerkouk", "Khaoula","0578564890");
        Contact cc4=new Contact("gazi", "Louay","0768453790");
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
