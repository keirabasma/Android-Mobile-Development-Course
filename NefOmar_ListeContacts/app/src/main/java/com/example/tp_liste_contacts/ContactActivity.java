package com.example.tp_liste_contacts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    private TextView nomTextView;
    private TextView prenomTextView;
    private TextView telephoneTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        nomTextView = findViewById(R.id.text_view_nom);
        prenomTextView = findViewById(R.id.text_view_prenom);
        telephoneTextView = findViewById(R.id.text_view_telephone);
        imageView = findViewById(R.id.image);

        // Récupérer les données envoyées par l'activité précédente
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String prenom = intent.getStringExtra("prenom");
        String telephone = intent.getStringExtra("telephone");
        int imageResId = intent.getIntExtra("imageResId", 0);

        // Afficher les informations du contact dans les TextViews
        nomTextView.setText("Nom : " + nom);
        prenomTextView.setText("Prénom : " + prenom);
        telephoneTextView.setText("Téléphone : " + telephone);

        // Afficher l'image du contact
        if (imageResId != 0) {
            imageView.setImageResource(imageResId);
        }
    }
}
