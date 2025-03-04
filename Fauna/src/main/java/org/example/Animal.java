package org.example;

import org.bson.Document;


public class Animal {
    private String nomComu;
    private String nomCientific;
    private String descripcio;
    private String habitat;
    private String dieta;
    private String comportament;
    private Caracteristiques caracteristiques;
    private String dataCreacio;

    // Constructor
    public Animal(String nomComu, String nomCientific, String descripcio,
                  String habitat, String dieta, String comportament,
                  Caracteristiques caracteristiques, String dataCreacio) {

        this.nomComu = nomComu;
        this.nomCientific = nomCientific;
        this.descripcio = descripcio;
        this.habitat = habitat;
        this.dieta = dieta;
        this.comportament = comportament;
        this.caracteristiques = caracteristiques;
        this.dataCreacio = dataCreacio;
    }

    // Getters
    public String getNomComu() {
        return nomComu;
    }

    public String getNomCientific() {
        return nomCientific;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDieta() {
        return dieta;
    }

    public String getComportament() {
        return comportament;
    }

    public Caracteristiques getCaracteristiques() {
        return caracteristiques;
    }

    public String getDataCreacio() {
        return dataCreacio;
    }

    // Setters
    public void setNomComu(String nomComu) {
        this.nomComu = nomComu;
    }

    public void setNomCientific(String nomCientific) {
        this.nomCientific = nomCientific;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public void setComportament(String comportament) {
        this.comportament = comportament;
    }

    public void setCaracteristiques(Caracteristiques caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public void setDataCreacio(String dataCreacio) {
        this.dataCreacio = dataCreacio;
    }


    public Document toDocument() {
        Document document = new Document()
                .append("nom_comu", this.nomComu)
                .append("nom_cientific", this.nomCientific)
                .append("descripcio", this.descripcio)
                .append("habitat", this.habitat)
                .append("dieta", this.dieta)
                .append("comportament", this.comportament)
                .append("caracteristiques", this.caracteristiques.toDocument())
                .append("data_creacio", this.dataCreacio);

        return document;
    }


    public static Animal fromDocument(Document doc) {
        String nomComu = doc.getString("nom_comu");
        String nomCientific = doc.getString("nom_cientific");
        String descripcio = doc.getString("descripcio");
        String habitat = doc.getString("habitat");
        String dieta = doc.getString("dieta");
        String comportament = doc.getString("comportament");
        String dataCreacio = doc.getString("data_creacio");
        Document caracteristiquesDoc = (Document) doc.get("caracteristiques");
        Caracteristiques caracteristiques = Caracteristiques.fromDocument(caracteristiquesDoc);

        return new Animal(nomComu, nomCientific, descripcio, habitat, dieta, comportament, caracteristiques, dataCreacio);
    }





    // Método toString para representar el objeto Animal como cadena
    @Override
    public String toString() {
        return "Animal{" +
                "nomComu='" + nomComu + '\'' +
                ", nomCientific='" + nomCientific + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", habitat='" + habitat + '\'' +
                ", dieta='" + dieta + '\'' +
                ", comportament='" + comportament + '\'' +
                ", caracteristiques=" + caracteristiques +
                ", dataCreacio='" + dataCreacio + '\'' +
                '}';
    }
}
