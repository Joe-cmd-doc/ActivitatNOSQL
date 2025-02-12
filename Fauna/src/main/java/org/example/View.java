package org.example;

import java.util.List;
import java.util.Scanner;

public class View {

    public int mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Gestió d'Animals ---");
        System.out.println("1. Afegir animal");
        System.out.println("2. Mostrar tots els animals");
        System.out.println("3. Ver animals per nom");
        System.out.println("4. Cercar per data");
        System.out.println("5. Sortir");
        System.out.print("Escull una opció: ");
        return sc.nextInt();
    }

    public Animal insertAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom de l'animal:");
        String nom=sc.nextLine();
        System.out.println("Introdueix el nom de  cientific l'animal:");
        String nomC=sc.nextLine();
        System.out.println("Introdueix una breu descripcio de l'animal:");
        String breu=sc.nextLine();
        System.out.println("Introdueix el habitat de l'animal");
        String hab=sc.nextLine();
        System.out.println("Introdueix la dieta de l'animal:");
        String dieta=sc.nextLine();
        System.out.println("Introdueix el comportament de l'animal:");
        String comp=sc.nextLine();
        System.out.println("Introdueix les caracteristiques de l'animal");
        System.out.println("Introdueix el pes de l'animal:");
        String pes=sc.nextLine();
        System.out.println("Introdueix la longitud de l'animal:");
        String longit=sc.nextLine();
        System.out.println("Introdueix la esperança de vida de l'animal:");
        String vida=sc.nextLine();
        Caracteristiques caracteristiques = new Caracteristiques(longit,pes,vida);
        System.out.println("Introdueix la data de creacio de l'animal:");
        String creacio=sc.nextLine();

        return new Animal(nom,nomC,breu,hab,dieta,comp,caracteristiques,creacio);



    }
    //Mostrar tots els animals amb la data especificada
    public void showAnimalByDate(List<Animal> animals) {
        System.out.println("-----Els animals amb la data que  has especificat-----");
        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }

    //Preguntar el rang de dates dels Animals
    public String[] askAnimalByDate() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix la data de creació de l'animal (1r rang, format: YYYY-MM-DD):");
        String first = sc.nextLine();

        System.out.println("Introdueix la data de creació de l'animal (2n rang, format: YYYY-MM-DD):");
        String last = sc.nextLine();

        return new String[]{first, last};
    }


    //Mostrem tots els animals
   public void ShowAllAnimals(List<Animal> animal){
        System.out.println("Llista de tots els animals");
        for (Animal Animals : animal ){
            System.out.println(Animals);
        }
   }

//Demanem el nom de l'animal i el retornem
   public String AskAnimalName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom de l'animal:");
        String name= sc.nextLine();
        return name;
   }

   //Mostrem l'animal que ens dona la bbdd
    public void showAnimalByName(Animal animal){
        System.out.println(animal);
    }




}
