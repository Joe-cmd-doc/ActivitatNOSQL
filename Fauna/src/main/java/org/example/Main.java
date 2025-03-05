package org.example;


public class Main {
    public static void main(String[] args) {


        DAO AnimalsDAO = new DAO();
        View view = new View();
        int option = view.mostrarMenu();

        switch (option){
            case 1:
                AnimalsDAO.InsertAnimal(view.insertAnimal());
                break;
            case 2:

                view.ShowAllAnimals(AnimalsDAO.getAllAnimals());
                break;
            case 3:
                String[] dates = view.askAnimalByDate();
                view.showAnimalByDate(AnimalsDAO.searchAnimalByDate(dates[0], dates[1]));
                break;

            default:
                System.out.println("Opcion no valida");

        }

    }
}