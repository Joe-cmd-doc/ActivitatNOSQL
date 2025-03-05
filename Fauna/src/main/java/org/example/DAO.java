package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DAO {
    private static final String BASE_URL = "https://joelapi.vercel.app";

    private final HttpClient client;

    public DAO() {
        this.client = HttpClient.newHttpClient();
    }

    // Mètode per inserir un animal a la base de dades
    public void InsertAnimal(Animal animal) {
        try {

            String json = animal.tojson();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/add"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();


            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Animal afegit: " + response.body());
        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
        }
    }


    // Mètode per obtenir tots els animals
    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL + "/list"))
                    .GET()
                    .build();

            CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            responseFuture.thenAccept(response -> {
                String responseBody = response.body();
                System.out.println("Resposta de l'API: " + responseBody);

                JSONArray jsonArray = new JSONArray(responseBody);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Caracteristiques caracteristiques = new Caracteristiques(
                            jsonObject.getJSONObject("caracteristiques").getString("longitud"),
                            jsonObject.getJSONObject("caracteristiques").getString("pes"),
                            jsonObject.getJSONObject("caracteristiques").getString("esperanca_vida")
                    );

                    Animal animal = new Animal(
                            jsonObject.getString("nom_comu"),
                            jsonObject.getString("nom_cientific"),
                            jsonObject.getString("descripcio"),
                            jsonObject.getString("habitat"),
                            jsonObject.getString("dieta"),
                            jsonObject.getString("comportament"),
                            caracteristiques,
                            jsonObject.getString("data_creacio")
                    );

                    animals.add(animal);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                return null;
            }).join();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }

    // Mètode per buscar animals dins un rang de dates
    public List<Animal> searchAnimalByDate(String first, String last) {
        List<Animal> animals = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL + "/list/" + first + "/" + last))
                    .GET()
                    .build();

            CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            responseFuture.thenAccept(response -> {
                String responseBody = response.body();
                System.out.println("Resposta de l'API: " + responseBody);

                JSONArray jsonArray = new JSONArray(responseBody);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Caracteristiques caracteristiques = new Caracteristiques(
                            jsonObject.getJSONObject("caracteristiques").getString("longitud"),
                            jsonObject.getJSONObject("caracteristiques").getString("pes"),
                            jsonObject.getJSONObject("caracteristiques").getString("esperanca_vida")
                    );

                    Animal animal = new Animal(
                            jsonObject.getString("nom_comu"),
                            jsonObject.getString("nom_cientific"),
                            jsonObject.getString("descripcio"),
                            jsonObject.getString("habitat"),
                            jsonObject.getString("dieta"),
                            jsonObject.getString("comportament"),
                            caracteristiques,
                            jsonObject.getString("data_creacio")
                    );

                    animals.add(animal);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                return null;
            }).join();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }
}
