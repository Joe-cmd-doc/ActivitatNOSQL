package org.example;


public class Main {
    public static void main(String[] args) {


        CRUD AnimalsDAO = new CRUD();
        View view = new View();
        int option = view.mostrarMenu();

        switch (option){
            case 1:
                AnimalsDAO.showAnimalnames();
                AnimalsDAO.InsertAnimal(view.insertAnimal());
                break;
            case 2:

                view.ShowAllAnimals(AnimalsDAO.getAllAnimalls());
                break;
            case 3:
                AnimalsDAO.showAnimalnames();
                view.showAnimalByName(AnimalsDAO.getAnimalByname(view.AskAnimalName()));
                break;
            case 4:

                String[] dates = view.askAnimalByDate();
                view.showAnimalByDate(AnimalsDAO.searchAnimalBydate(dates[0], dates[1]));

            case 5:
                System.exit(0);
            default:
                System.out.println("Opcion no valida");

        }

    }
}