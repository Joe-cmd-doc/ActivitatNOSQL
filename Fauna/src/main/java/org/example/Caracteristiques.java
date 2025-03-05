package org.example;

import org.json.JSONObject;

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


    public String tojson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("longitud", longitud);
        jsonObject.put("pes", pes);
        jsonObject.put("espVida", espVida);
        return jsonObject.toString();
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
