package org.example;

import java.util.Scanner;

public class View {

    public int mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Gestió d'Animals ---");
        System.out.println("1. Afegir animal");
        System.out.println("2. Mostrar tots els animals");
        System.out.println("3. Cercar per data");
        System.out.println("4. Sortir");
        System.out.print("Escull una opció: ");
        return sc.nextInt();
    }

}
