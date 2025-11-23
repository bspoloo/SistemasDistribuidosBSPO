/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import ejercicio3.interfaces.ICadena;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Animetx
 */
public class Client {

    public static void main(String[] args) {
        Scanner scannerText = new Scanner(System.in);
        Scanner scannerNumber = new Scanner(System.in);

        try {
            ICadena cadena = (ICadena) Naming.lookup("rmi://localhost/cadenas"); // instanciar un objeto 

            int op = 0;
            String frase = "";
            while (op != 5) {
                System.out.println("1.- Guardar Frase");
                System.out.println("2.- Convertir a mayusculas");
                System.out.println("3.- Duplicar espacios");
                System.out.println("4.- Concatenar");
                System.out.println("5.- salir");
                System.out.println("Elegir una opcion");
                op = scannerNumber.nextInt();

                switch (op) {
                    case 1:
                        System.out.println("Introduzca la frase: ");
                        String newfrase = scannerText.nextLine();
                        
                        boolean response = cadena.guardarFrase(newfrase);
                        if (response) {
                            System.out.println("Exito en guardar la frase");
                        } else {
                            System.out.println("Existio un error en guardar la frases");
                        }
                        break;
                    case 2:
                        System.out.println("convirtiendo a mayusculas");
                        frase = cadena.convertirMayusculas();
                        System.out.println("Su frase es: " + frase);
                        break;
                    case 3:
                        System.out.println("Introduzca la cantidad de los espacios a duplicar: ");
                        int n = scannerNumber.nextInt();

                        frase = cadena.duplicarEspacios(n);
                        System.out.println("Su frase duplicada es: " + frase);
                        break;
                    case 4:
                        System.out.println("Introduzca el extra: ");
                        frase = scannerText.nextLine();
                        String concatenado = cadena.concatenar(frase);
                        System.out.println("El concatenado es: " + concatenado);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error en opciones");
                        break;
                }
            }

        } catch (NotBoundException ex) {
            System.getLogger(Client.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (MalformedURLException ex) {
            System.getLogger(Client.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (RemoteException ex) {
            System.getLogger(Client.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
