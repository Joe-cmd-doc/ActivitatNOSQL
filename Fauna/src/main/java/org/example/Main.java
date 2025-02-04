package org.example;

import com.mongodb.client.MongoClient;
import org.bson.Document;


public class Main {
    public static void main(String[] args) {

        ConectionManager.getConnection();

        Model Animals = new Model();
        Animals.getAnimals();
        System.out.println(Animals);

    }
}