package com.example.yassine.testreseau.models;

import java.util.List;

public class User {

    private List<Voiture> voitures = null;
    private String nom;
    private String prenom;
    private Integer age;
    private Boolean permis;

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getPermis() {
        return permis;
    }

    public void setPermis(Boolean permis) {
        this.permis = permis;
    }

}
