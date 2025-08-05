package org.example;

import org.example.classes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1; // Inicializamos fuera del rango válido

        int n = 0;
        int result = 0;

        while (option != 0) {
            Menu menu = new Menu();
            menu.showMenu();

            System.out.println("Elija una opción (0 para salir): ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Introduzca el número: ");
                    n = scanner.nextInt();
                    break;
                case 2:
                    IOperation factorial = new Factorial();
                    result = factorial.executeResult(n);
                    System.out.println("El resultado es: " + result);
                    break;
                case 3:
                    IOperation sumatoria = new Sumatoria();
                    result = sumatoria.executeResult(n);
                    System.out.println("El resultado es: " + result);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

            System.out.println();
        }

        scanner.close();
    }
}
