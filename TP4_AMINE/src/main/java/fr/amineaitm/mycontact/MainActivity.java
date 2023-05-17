package fr.amineaitm.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewContacts;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContacts = findViewById(R.id.listViewContacts);

        // Création de la liste des contacts
        contacts = new ArrayList<>();
        contacts.add(new Contact("AIT MOKHTAR ", "AMINE", "123456789", R.drawable.chat2));
        contacts.add(new Contact("", "Jane", "987654321", R.drawable.chatphoto));
        contacts.add(new Contact("ABDELKADER", "LOTFI", "123456789", R.drawable.chatchien));

        // Création de l'adaptateur pour la liste des contacts
        ArrayAdapter<Contact> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, contacts);
        listViewContacts.setAdapter(adapter);

        // Gestion du clic sur un contact
        listViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contacts.get(position);
                afficherDetailsContact(contact);
            }
        });
    }

    private void afficherDetailsContact(Contact contact) {
        Intent intent = new Intent(this, ContactDetailsActivity.class);
        intent.putExtra("nom", contact.getNom());
        intent.putExtra("prenom", contact.getPrenom());
        intent.putExtra("numero", contact.getNumero());
        intent.putExtra("photo", contact.getPhotoId());
        startActivity(intent);
    }
}
