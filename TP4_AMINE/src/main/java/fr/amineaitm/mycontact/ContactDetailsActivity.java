package fr.amineaitm.mycontact;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailsActivity extends AppCompatActivity {
    private ImageView imageViewPhoto;
    private TextView textViewNom;
    private TextView textViewPrenom;
    private TextView textViewNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        imageViewPhoto = findViewById(R.id.imageViewPhoto);
        textViewNom = findViewById(R.id.textViewNom);
        textViewPrenom = findViewById(R.id.textViewPrenom);
        textViewNumero = findViewById(R.id.textViewNumero);

        // Récupérer les données passées depuis MainActivity
        Intent intent = getIntent();
        if (intent != null) {
            String nom = intent.getStringExtra("nom");
            String prenom = intent.getStringExtra("prenom");
            String numero = intent.getStringExtra("numero");
            int photoId = intent.getIntExtra("photo", 0);

            // Afficher les données dans les vues correspondantes
            textViewNom.setText(nom);
            textViewPrenom.setText(prenom);
            textViewNumero.setText(numero);
            imageViewPhoto.setImageResource(photoId);
        }
    }
}

