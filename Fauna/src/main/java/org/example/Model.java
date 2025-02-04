package org.example;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Model {

    public Document getAnimals(){
        try(MongoClient con = ConectionManager.getConnection()){
            MongoDatabase Database = con.getDatabase("Fauna");
            MongoCollection<Document> Animals = Database.getCollection("Animals");
            Document doc = Animals.find(eq("habitat","ocean")).first();
            return doc;
        }

    }
}
