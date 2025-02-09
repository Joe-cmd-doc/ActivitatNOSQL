package org.example;


import com.mongodb.client.*;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class Model {

    MongoDatabase con;
    MongoCollection<Document> Animals;

    //Obtenir animal
    public void getAnimalByname(String name){

        con = ConectionManager.getConnection();
        Animals = con.getCollection("Animals");

        Document doc =Animals.find(eq("nom_comu",name)).first();
        Document Caracteristiques=doc.get("caracteristiques",Document.class);
        System.out.println(doc);
        }

        //Metode per inserir animal
        public void InsertAnimal(Animals animal){
        con =ConectionManager.getConnection();
        Animals= con.getCollection("Animals");
        Document Animalss = toDocument(animal);
        Animals.insertOne(Animalss);

        }

    //Metode de conversio de l'objecte animal a document
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

    //Metode per obtenir tots els animals
    public void getAllAnimalls() {
        con = ConectionManager.getConnection();
        Animals = con.getCollection("Animals");

        FindIterable<Document> documents = Animals.find();

        for (Document animal : documents) {
            System.out.println(animal.getString("nom_comu"));
        }


    }

    {
    }









}

