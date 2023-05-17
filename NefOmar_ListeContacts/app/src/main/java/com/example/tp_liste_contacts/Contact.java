package com.example.tp_liste_contacts;

public class Contact {
    private String nom;
    private String prenom;
    private String telephone;
    private int imageResId;

    public Contact(String nom, String prenom, String telephone, int imageResId) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.imageResId = imageResId;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getImageResId() {
        return imageResId;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
