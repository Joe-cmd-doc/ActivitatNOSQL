package org.example;


import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;


public class ConectionManager {

    public static String connectionString = "mongodb+srv://joelortizrivas:aa1234aa@castellet.uxh5e.mongodb.net/?retryWrites=true&w=majority&appName=Castellet";

    public static MongoClient Client = null;

    public static MongoClient getConnection() {

        if (Client == null) {

        try {

        Client= MongoClients.create(connectionString);

        System.out.println("Connected");

       } catch(MongoException e){

        e.printStackTrace();
        }
        }
        return Client;
    }

}





