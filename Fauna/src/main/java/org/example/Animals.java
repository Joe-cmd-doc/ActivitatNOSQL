package org.example;

public class Animals {
    private String id;
    private String nomComu;
    private String nomCientific;
    private String descripcio;
    private String habitat;
    private String dieta;
    private String comportament;
    private Caracteristiques caracteristiques;
    private String dataCreacio;

    // Constructor
    public Animals(String id, String nomComu, String nomCientific, String descripcio,
                   String habitat, String dieta, String comportament,
                   Caracteristiques caracteristiques, String dataCreacio) {

        this.id = id;
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
    public String getId() {
        return id;
    }

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
    public void setId(String id) {
        this.id = id;
    }

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

    // toString
    @Override
    public String toString() {
        return "Animals{" +
                "id='" + id + '\'' +
                ", nomComu='" + nomComu + '\'' +
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
