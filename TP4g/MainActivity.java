package com.example.tp4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the list of contacts
        ArrayList<Contact> contacts = createContactList();

        // Setup the ListView and its adapter
        setupListView(contacts);
    }

    // Create and return an ArrayList of Contact objects
    private ArrayList<Contact> createContactList() {
        ArrayList<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact("CHIKHI", "Wassim", "065869448"));
        contactList.add(new Contact("CHIKHI", "Mohammed", "0640709623"));
        contactList.add(new Contact("GUEFFAF", "Fares", "0798269623"));
        contactList.add(new Contact("GUEFFAF", "Razine", "0796125366"));

        return contactList;
    }

    // Setup the ListView with the provided list of contacts
    private void setupListView(ArrayList<Contact> contacts) {
        ListView listView = findViewById(R.id.simpleListView);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), contacts);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ListItemActivity1.class);
            startActivityForResult(intent, 0);
        });
    }
}
