package com.example.tp_liste_contacts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewContacts;
    List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation de la liste des contacts
        contacts = new ArrayList<>();
        String[] prenoms = {"John", "Jane", "Bob", "Alice", "Jack", "Lisa", "Mark", "Kate", "Paul", "Sarah", "David"};
        String[] noms = {"Doe", "Smith", "Johnson", "Lee", "Garcia", "Brown", "Davis", "Wilson", "Jones", "Taylor", "Anderson"};
        for (int i = 0; i < 25; i++) {
            String prenom = prenoms[(int)(Math.random() * prenoms.length)];
            String nom = noms[(int)(Math.random() * noms.length)];
            String telephone = "+213" + String.format("%08d", i+1);
            int imageResId = getResources().getIdentifier("contact_image_" + i, "drawable", getPackageName());
            contacts.add(new Contact(nom, prenom, telephone, R.drawable.logo));

        }

        // Référence à la ListView dans le layout
        listViewContacts = findViewById(R.id.list_view_contacts);

        // Création de l'adaptateur pour la ListView
        ContactAdapter adapter = new ContactAdapter(this, contacts);

        // Liaison de l'adaptateur avec la ListView
        listViewContacts.setAdapter(adapter);

        // Gestionnaire d'événements pour le clic sur un contact dans la liste
        listViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Récupérer le contact sélectionné
                Contact contact = (Contact) adapterView.getItemAtPosition(position);

                // Créer un Intent pour lancer l'activité ContactActivity
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);

                // Passer les informations du contact à l'activité ContactActivity
                intent.putExtra("nom", contact.getNom());
                intent.putExtra("prenom", contact.getPrenom());
                intent.putExtra("telephone", contact.getTelephone());
                intent.putExtra("imageResId", contact.getImageResId());

                // Lancer l'activité ContactActivity
                startActivity(intent);
            }
        });

    }
}
