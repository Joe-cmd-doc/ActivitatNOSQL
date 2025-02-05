package org.example;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Model {

    MongoDatabase con;
    MongoCollection<Document> Animals;

    public Animals getAnimals(){

        con = ConectionManager.getConnection();
        Animals = con.getCollection("Animals");

        Document doc = Animals.find(eq("habitat","ocean")).first();
        Document Caracteristiques=doc.get("caracteristiques",Document.class);
        Caracteristiques caracteristiques = new Caracteristiques(Caracteristiques.getString("longitud"),Caracteristiques.getString("pes"), Caracteristiques.getString("esperanca_vida"));

        return new Animals(doc.getString("_id"),doc.getString("nom_comu"),doc.getString("nom_cientific"),doc.getString("descripcio"),doc.getString("habitat"),doc.getString("dieta"),doc.getString("comportament"),caracteristiques,doc.getString("data_creacio"));
        }

        public void InsertAnimal(Animals animal){
        Document Animalss = toDocument(animal);
        Animals.insertOne(Animalss);

        }

    public Document toDocument(Animals animal) {
        Document caracteristiquesDoc = new Document()
                .append("longitud", animal.getCaracteristiques().getLongitud())
                .append("pes", animal.getCaracteristiques().getPes())
                .append("esperanca_vida", animal.getCaracteristiques().getEspVida());

        return new Document("_id", animal.getId())
                .append("nom_comu", animal.getNomComu())
                .append("nom_cientific", animal.getNomCientific())
                .append("descripcio", animal.getDescripcio())
                .append("habitat", animal.getHabitat())
                .append("dieta", animal.getDieta())
                .append("comportament", animal.getComportament())
                .append("caracteristiques", caracteristiquesDoc)
                .append("data_creacio", animal.getDataCreacio());
    }





}

