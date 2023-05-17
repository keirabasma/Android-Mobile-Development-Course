package com.example.tp_liste_contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private LayoutInflater inflater;

    public ContactAdapter(Context context, List<Contact> contacts) {
        super(context, 0, contacts);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_main, parent, false);
        }

        Contact contact = getItem(position);

        TextView contactNameTextView = convertView.findViewById(R.id.text_view_title);
        contactNameTextView.setText(contact.toString());

        return convertView;
    }
}
