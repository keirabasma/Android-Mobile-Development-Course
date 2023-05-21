package com.example.listeviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class Contact {
    public String nom;
    public String prenom;
    public String telephone;
    public Contact(String NomC, String PrenomC, String TelephoneC) {
        nom = NomC;
        prenom = PrenomC;
        telephone = TelephoneC;
    }
    public String getNom() {return nom;}
    public void setNom() {this.nom=nom;}
    public String getPrenom() {return prenom;}
    public void setPrenom() {this.prenom=prenom;}
    public String getTelephone() {return telephone;}
    public void setTelephone() {this.telephone=telephone;}
}
