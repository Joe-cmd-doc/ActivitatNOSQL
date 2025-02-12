package org.example;


import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class CRUD {

    MongoDatabase con;
    MongoCollection<Document> Animals;

    //Obtenir animal
    public Animal getAnimalByname(String name){

        con = ConectionManager.getConnection();
        Animals = con.getCollection("animals");

        Document doc =Animals.find(eq("nom_comu",name)).first();
        Animal animal = Animal.fromDocument(doc);
        return animal;

        }

        //Metode per inserir animal
        public void InsertAnimal(Animal animal){
        con =ConectionManager.getConnection();
        Animals= con.getCollection("animals");
        Document Animalss = animal.toDocument();
        Animals.insertOne(Animalss);

        }


    //Metode per obtenir tots els animals
    public List<Animal> getAllAnimalls() {
        List<Animal> animals = new ArrayList<Animal>();
        con = ConectionManager.getConnection();
        Animals = con.getCollection("animals");

        FindIterable<Document> documents = Animals.find();

        for (Document animal : documents) {
            animals.add(Animal.fromDocument(animal));
        }
        return animals;
    }

    public List<Animal> searchAnimalBydate(String first, String last){

        con = ConectionManager.getConnection();
        Animals = con.getCollection("animals");
        List<Animal> animals= new ArrayList<>();

        Bson filter = Filters.and(
                Filters.gte("data_creacio", first),
                Filters.lte("data_creacio", last)
        );

        FindIterable<Document> docs = Animals.find(filter);
        for (Document animal : docs) {
            animals.add(Animal.fromDocument(animal));
        }
        return animals;

    }

    public void showAnimalnames(){
        con = ConectionManager.getConnection();
        Animals = con.getCollection("animals");
        FindIterable<Document> documents = Animals.find();
        List<String> animalnames = new ArrayList<>();
        for (Document animal : documents) {
            animalnames.add(animal.getString("nom_comu"));
        }
     System.out.println(animalnames);
    }
    

    {
    }









}

