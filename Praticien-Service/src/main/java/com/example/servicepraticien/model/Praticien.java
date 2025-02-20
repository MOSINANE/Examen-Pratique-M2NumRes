package com.example.servicepraticien.model;

public class Praticien {
    private int id;
    private String nom;
    private String specialite;
    private String telephone;
    private String adresse;



    public Praticien() {

    }

    public Praticien(int id, String nom, String specialite, String telephone, String adresse) {
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
