package com.example.listname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);
        int img = R.drawable.aaaaa;
        int img2 = R.drawable.www;
        Contact contact1 = new Contact("Test","1", img);
        Contact contact2 = new Contact("Test2","2", img2);
        ArrayList<Contact> mylist = new ArrayList<Contact>();
        mylist.add(contact1);
        mylist.add(contact2);

        ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, mylist);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Open the another_layout.xml here
                Intent intent = new Intent(getApplicationContext(), ShowContact.class);
                Contact C = mylist.get(position);

                intent.putExtra("Name",C.name);
                intent.putExtra("LastName",C.lastName);
                intent.putExtra("Pic",C.Pic);
                startActivity(intent );
            }
        });
    }
    public class Contact {
        String name ;
        String lastName;
        int Pic ;
        public Contact(String name  , String lastName , int Pic) {
            this.name = name ;
            this.lastName = lastName ;
            this.Pic = Pic ;
        }
    }
}