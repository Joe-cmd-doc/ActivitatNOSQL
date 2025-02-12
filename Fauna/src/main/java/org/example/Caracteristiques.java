package org.example;

import org.bson.Document;

public class Caracteristiques {
    private String longitud;
    private String pes;
    private String espVida;


    public Caracteristiques(String longitud, String pes, String espVida) {
        this.longitud = longitud;
        this.pes = pes;
        this.espVida = espVida;
    }


    public String getLongitud() {
        return longitud;
    }

    public String getPes() {
        return pes;
    }

    public String getEspVida() {
        return espVida;
    }


    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setPes(String pes) {
        this.pes = pes;
    }

    public void setEspVida(String espVida) {
        this.espVida = espVida;
    }

    public Document toDocument(){
        return new Document("longitud", this.longitud).append("pes", this.pes).append("espVida", this.espVida);
    }

    @Override
    public String toString() {
        return "Caracteristiques{" +
                "longitud='" + longitud + '\'' +
                ", pes='" + pes + '\'' +
                ", espVida='" + espVida + '\'' +
                '}';
    }

    public static Caracteristiques fromDocument(Document doc) {
        String longitud = doc.getString("longitud");
        String pes = doc.getString("pes");
        String espVida = doc.getString("espVida");

        return new Caracteristiques(longitud, pes, espVida);
    }
}
