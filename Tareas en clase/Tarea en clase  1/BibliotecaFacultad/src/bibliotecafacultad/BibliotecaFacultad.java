/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecafacultad;

import bibliotecafacultad.Clases.Biblioteca.Biblioteca;
import bibliotecafacultad.Database.BibliotecaDAO;
import bibliotecafacultad.Menu.*;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BibliotecaFacultad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO("jdbc:mysql://localhost:3306/db_bibliotecas", "root", "root");
        Scanner scanner = new Scanner(System.in);

        IMenu menuInitial = new MenuInitial();

        menuInitial.mostrarMenu();

        int option = -1;

        while (option!=0){
            System.out.println("Seleccione una opcion: ");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    IMenu menuBiblioteca = new MenuBiblioteca();
                    menuBiblioteca.mostrarMenu();
                    break;
                case 2:
                    IMenu menuArmario = new MenuArmario();
                    menuArmario.mostrarMenu();
                    break;
                case 3:
                    IMenu menuPublicacion = new MenuPublicacion();
                    menuPublicacion.mostrarMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Error en escoger la opcion...");
            }
        }
        scanner.close();
    }
}
