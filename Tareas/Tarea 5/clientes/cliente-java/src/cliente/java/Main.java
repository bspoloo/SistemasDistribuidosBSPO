/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cliente.java;

import cliente.java.classes.JSON;
import cliente.java.classes.LoginInput;
import cliente.java.classes.Persona;
import cliente.java.classes.Session;
import cliente.java.classes.User;
import cliente.java.classes.services.LoginService;
import cliente.java.classes.services.PersonService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author Animetx
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Session session = new Session();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService("http://localhost:8000/api");
        PersonService personService = new PersonService("http://localhost:8000/api/personas");
        try {
            while (true) {
                if (session.getToken() == null) {
                    System.out.println("-------LOGIN--------");
                    System.out.println("Inserte su Email:");
                    String email = scanner.nextLine();
                    System.out.println("Inserte su Password:");
                    String password = scanner.nextLine();

                    System.out.println(loginService.Authenticate(email, password));

                } else {
                    int option = printMentu();
                    switch (option) {
                        case 1:
                            System.out.println(personService.getAllPersonas());
                            break;
                        case 2:
                            System.out.println("Inserte el Id de la persona a buscar");
                            String id = scanner.nextLine();
                            System.out.println(personService.getPersonaById(id));
                            break;
                        case 3:

                            System.out.println("Nombres: ");
                            String nombres = scanner.nextLine();

                            System.out.println("Apellidos: ");
                            String apellidos = scanner.nextLine();

                            System.out.println("CI: ");
                            String ci = scanner.nextLine();

                            System.out.println("Direccion: ");
                            String direccion = scanner.nextLine();

                            System.out.println("Telefono: ");
                            String telefono = scanner.nextLine();

                            System.out.println("Email: ");
                            String email = scanner.nextLine();

                            Persona persona = new Persona(nombres, apellidos, ci, direccion, telefono, email);

                            System.out.println(personService.createPersona(persona));
                            break;
                        case 4:
                            Persona personaUpdate = new Persona();
                            System.out.println("Inserte el Id de la persona a actualizar");
                            String idUpadte = scanner.nextLine();

                            System.out.println("Nombres: ");
                            personaUpdate.setNombres(scanner.nextLine());

                            System.out.println("Apellidos: ");
                            personaUpdate.setApellidos(scanner.nextLine());

                            System.out.println("CI: ");
                            personaUpdate.setCi(scanner.nextLine());

                            System.out.println("Direccion: ");
                            personaUpdate.setDireccion(scanner.nextLine());

                            System.out.println("Telefono: ");
                            personaUpdate.setTelefono(scanner.nextLine());

                            System.out.println("Email: ");
                            personaUpdate.setEmail(scanner.nextLine());

                            System.out.println(personService.updatePersonaById(idUpadte, personaUpdate));
                            break;
                        case 5:
                            System.out.println("Inserte el id de la persona a eliminar:");
                            String idDelete = scanner.nextLine();
                            System.out.println(personService.deletePersonaById(idDelete));
                            break;
                        case 6:
                            System.exit(option);
                            break;
                        default:
                            System.out.println("input mal introducido");
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int printMentu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------AGENDA-------------");
        System.out.println("1.- Ver Personas");
        System.out.println("2.- Ver Persona");
        System.out.println("3.- Insertar Persona");
        System.out.println("4.- Actualizar Persona");
        System.out.println("5.- Eliminar Persona");
        System.out.println("6.- Salir");

        System.out.println("Escoja una opcion....");
        return scanner.nextInt();
    }
}
