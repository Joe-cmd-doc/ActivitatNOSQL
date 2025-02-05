package org.example;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Model {

    public Animals getAnimals(){
        try(MongoClient con = ConectionManager.getConnection()){
            MongoDatabase Database = con.getDatabase("Fauna");
            MongoCollection<Document> Animals = Database.getCollection("Animals");
            Document doc = Animals.find(eq("habitat","ocean")).first();
            Document Caracteristiques=doc.get("caracteristiques",Document.class);
            Caracteristiques caracteristiques = new Caracteristiques(Caracteristiques.getString("longitud"),Caracteristiques.getString("pes"), Caracteristiques.getString("esperanca_vida"));

            return new Animals(doc.getString("_id"),doc.getString("nom_comu"),doc.getString("nom_cientific"),doc.getString("descripcio"),doc.getString("habitat"),doc.getString("dieta"),doc.getString("comportament"),caracteristiques,doc.getString("data_creacio"));
        }

    }
}
