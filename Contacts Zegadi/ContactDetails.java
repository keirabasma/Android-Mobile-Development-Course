package com.example.converisseur_temp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetails extends Activity {
    TextView nameTextView, numberTextView;
    ImageView photoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        String contactName = getIntent().getStringExtra("contactName");

        nameTextView = findViewById(R.id.nameTextView);
        numberTextView = findViewById(R.id.numberTextView);
        photoImageView = findViewById(R.id.photoImageView);

        nameTextView.setText(contactName);
        numberTextView.setText("1234567890");
        photoImageView.setImageResource(R.drawable.ic_launcher_background);
    }
}
