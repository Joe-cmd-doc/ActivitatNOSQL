package org.example;

public class Caracteristiques {
    private String longitud;
    private String pes;
    private String espVida; // Cambié "EspVida" a "espVida" para seguir la convención de nombres en Java


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


    @Override
    public String toString() {
        return "Caracteristiques{" +
                "longitud='" + longitud + '\'' +
                ", pes='" + pes + '\'' +
                ", espVida='" + espVida + '\'' +
                '}';
    }
}
