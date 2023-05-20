package com.example.listname;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        // Get the contact details passed from the previous activity
        String contactName = getIntent().getStringExtra("Name");
        String contactPhone = getIntent().getStringExtra("LastName");
        // You can also get the contact photo if you passed it as well

        // Find views by their IDs
        TextView nameTextView = findViewById(R.id.contact_name);
        TextView phoneTextView = findViewById(R.id.contact_phone);
        ImageView photoImageView = findViewById(R.id.contact_photo);

        // Set the contact details in the views
        nameTextView.setText(contactName);
        phoneTextView.setText(contactPhone);
        photoImageView.setImageResource(getIntent().getIntExtra("Pic", 0 ));
        // Set the contact photo in the ImageView (you need to handle the photo loading yourself)
        // photoImageView.setImageDrawable(...);
    }
}
