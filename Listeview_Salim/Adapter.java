package com.example.listeview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    Context context;
    ArrayList<ContactDetailsActivity> contactlist;
    LayoutInflater inflter;


    public Adapter(Context applicationContext,  ArrayList<ContactDetailsActivity> l) {
        this.context = context;
        this.contactlist = l;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return contactlist.size() ;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflter.inflate(R.layout.activity_contact_details, null);
        TextView TvName = (TextView) view.findViewById(R.id.TV_Nom);
        TextView  tvPrenom = (TextView) view.findViewById(R.id.TV_Prenom);
        //TextView  tvTelephone = (TextView) view.findViewById(R.id.TV_tel);
        TvName.setText(contactlist.get(position).getNom());
        tvPrenom.setText(contactlist.get(position).getPrenom());
        //tvTelephone.setText(contactlist.get(position).getTelephone());


        return view;
    }

}
