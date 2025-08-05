/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import calculadora.Clases.Menu.Menu;
import calculadora.Clases.Operaciones.Factorial;
import calculadora.Clases.Operaciones.Fibonacci;
import calculadora.Clases.Operaciones.IOperacion;
import calculadora.Clases.Operaciones.Sumatoria;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        int n = 0;
        int resultado = 0;
        int opcion = -1;

        while (opcion != 0){
            menu.mostrarMenu();

            System.out.println("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Introduzca el número: ");
                    n = scanner.nextInt();
                    break;
                case 2:
                    IOperacion fibonacci = new Fibonacci();
                    resultado = fibonacci.getResultado(n);
                    System.out.println("El resultado es para la opcion "+ opcion + " es: " +resultado);
                    break;
                case 3:
                    IOperacion factorial = new Factorial();
                    resultado = factorial.getResultado(n);
                    System.out.println("El resultado es para la opcion "+ opcion + " es: " +resultado);
                    break;
                case 4:
                    IOperacion sumatoria = new Sumatoria();
                    resultado = sumatoria.getResultado(n);
                    System.out.println("El resultado es para la opcion "+ opcion + " es: " +resultado);
                    break;
                default:
                    System.out.println("Opcion introducida inconrrecta...");
            System.out.println();
            }
        }
        scanner.close();
    }
}
