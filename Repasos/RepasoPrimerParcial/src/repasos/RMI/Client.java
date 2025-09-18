/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import repasos.RMI.interfaces.IOperation;

/**
 *
 * @author Animetx
 */
public class Client {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        try {
            IOperation operation = (IOperation) Naming.lookup("rmi://localhost/operations");

            int op = 0;
            int a = 0;
            int b = 0;

            while (op != 5) {

                System.out.println("1.Sumar");
                System.out.println("2.Restar");
                System.out.println("3.Multiplicar");
                System.out.println("4.Dividir");
                System.out.println("5. Salir");
                System.out.print("Elegir una opcion");
                op = scaner.nextInt();

                System.out.println("Introduir el primer valor:");
                a = scaner.nextInt();
                System.out.println("Introducir segundo valor:");
                b = scaner.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("La suma es:" + operation.add(a, b));
                        break;
                    case 2:
                        System.out.println("La resta es:" + operation.rest(a, b));
                        break;
                    case 3:
                        System.out.println("La multiplicacion es:" + operation.multiply(a, b));
                        break;
                    case 4:
                        System.out.println("La division es:" + operation.divide(a, b));
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
