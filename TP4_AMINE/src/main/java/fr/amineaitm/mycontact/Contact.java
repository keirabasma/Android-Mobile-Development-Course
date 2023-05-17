package fr.amineaitm.mycontact;

public class Contact {
    private String nom;
    private String prenom;
    private String numero;
    private int photoId;

    public Contact(String nom, String prenom, String numero, int photoId) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.photoId = photoId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}

