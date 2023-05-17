package com.example.contacte;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;


public class ListC extends Activity {
    private ImageView imageViewContact;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_c);


        imageViewContact = findViewById(R.id.image);
        imageViewContact.setImageResource(R.drawable.img);
    }
}
