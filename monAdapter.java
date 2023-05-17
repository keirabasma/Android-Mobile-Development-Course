package com.example.contacte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class monAdapter extends ArrayAdapter<Contact> {
    Context cn;
    ArrayList<Contact> listeContact;
    LayoutInflater flter;


    public monAdapter(Context c,int ressource,  ArrayList<Contact> l) {
        super(c , ressource,l);
        this.cn = c;
        this.listeContact = l;
        flter = (LayoutInflater.from(c));
    }

    @Override
    public int getCount() {
        return listeContact.size() ;
    }

    @Override
    public Contact getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView( int position,View view, ViewGroup parent) {

        view = flter.inflate(R.layout.activity_contact, null);
        TextView Name = (TextView) view.findViewById(R.id.TNom);
        TextView  Prenom = (TextView) view.findViewById(R.id.TPrenom);
        TextView telephone = (TextView) view.findViewById(R.id.telmun);
        Name.setText(listeContact.get(position).getNom());
        Prenom.setText(listeContact.get(position).getPrenom());
        telephone.setText(listeContact.get(position).getTelephone());



        return view;
    }

}

