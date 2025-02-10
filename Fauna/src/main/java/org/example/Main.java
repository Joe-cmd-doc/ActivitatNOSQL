package org.example;


public class Main {
    public static void main(String[] args) {


        Model AnimalsDAO = new Model();
        View view = new View();
        int option = view.mostrarMenu();

        switch (option){
            case 1:

                AnimalsDAO.InsertAnimal(view.AfegirAnimal());
                break;
            case 2:

                AnimalsDAO.getAllAnimalls();
                break;
            case 3:
                AnimalsDAO.getAllAnimalls();
                AnimalsDAO.getAnimalByname(view.mostrarAnimalperNom());
                break;
            case 4:

                String[] dates = view.AnimalperDate();
                AnimalsDAO.searchAnimalBydate(dates[0], dates[1]);

            case 5:
                System.exit(0);
            default:
                System.out.println("Opcion no valida");

        }

    }
}