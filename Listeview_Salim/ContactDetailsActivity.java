package com.example.listeview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailsActivity extends AppCompatActivity {
    public String nom;
    public String prenom;
    public String telephone;
    public ContactDetailsActivity(String aNom, String aPrenom, String aTelephone) {
        nom = aNom;
        prenom = aPrenom;
        telephone = aTelephone;
    }
    public String getNom() {return nom;}
    public void setNom() {this.nom=nom;}
    public String getPrenom() {return prenom;}
    public void setPrenom() {this.prenom=prenom;}
    public String getTelephone() {return telephone;}
    public void setTelephone() {this.telephone=telephone;}
}
