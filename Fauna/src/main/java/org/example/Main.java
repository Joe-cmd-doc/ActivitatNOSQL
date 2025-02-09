package org.example;


public class Main {
    public static void main(String[] args) {


        Model AnimalsDAO = new Model();
        View view = new View();
        int option = view.mostrarMenu();

        switch (option){
            case 1:
                //Afegir animal
                AnimalsDAO.InsertAnimal(view.AfegirAnimal());
                break;
            case 2:
                //Cercar tots els animals
                AnimalsDAO.getAllAnimalls();
                break;
            case 3:
                AnimalsDAO.getAllAnimalls();
                AnimalsDAO.getAnimalByname(view.mostrarAnimalperNom());
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Opcion no valida");

        }

    }
}