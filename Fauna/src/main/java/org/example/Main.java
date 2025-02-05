package org.example;

import com.mongodb.client.MongoClient;
import org.bson.Document;


public class Main {
    public static void main(String[] args) {


        Model AnimalsDAO = new Model();
        Animals animal = AnimalsDAO.getAnimals();
        System.out.println(animal);

    }
}