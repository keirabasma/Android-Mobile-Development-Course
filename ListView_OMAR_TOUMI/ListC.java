package com.example.listeviews;
import android.os.Bundle;

import android.app.Activity;
import android.widget.ImageView;


public class ListC extends Activity {
    private ImageView imageViewContact;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        imageViewContact = findViewById(R.id.image);
    }
}