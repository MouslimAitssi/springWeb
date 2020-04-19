package com.spring.website;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class product {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private int id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "prix", nullable = false)
    private int prix;
    @Column(name = "prixachat", nullable = false)
    private int prixachat;

    public product() {}

    public product(int id, String nom, int prix, int prixachat) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prixachat = prixachat;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", prixachat=" + prixachat +
                '}';
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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getprixachat() {
        return prixachat;
    }

    public void setprixachat(int prixachat) {
        this.prixachat = prixachat;
    }
}
