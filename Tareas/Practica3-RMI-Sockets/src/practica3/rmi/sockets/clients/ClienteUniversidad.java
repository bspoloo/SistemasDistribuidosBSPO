package practica3.rmi.sockets.clients;

import java.rmi.Naming;
import java.util.Scanner;
import practica3.rmi.sockets.classes.Diploma;
import practica3.rmi.sockets.interfaces.IServerUniversidad;

public class ClienteUniversidad {
    public static void main(String[] args) {
        try {
            // Buscar el servidor Universidad en el registro RMI
            IServerUniversidad servidorUniversidad = (IServerUniversidad)
                    Naming.lookup("rmi://localhost:1099/ServidorUniversidad");

            Scanner scanner = new Scanner(System.in);

            System.out.println("=== SISTEMA DE EMISIÓN DE DIPLOMAS ===");
            System.out.print("CI: ");
            String ci = scanner.nextLine();

            System.out.print("Nombres: ");
            String nombres = scanner.nextLine();

            System.out.print("1er Apellido: ");
            String primerApellido = scanner.nextLine();

            System.out.print("2do Apellido: ");
            String segundoApellido = scanner.nextLine();

            System.out.print("Fecha nacimiento (dd-mm-aaaa): ");
            String fechaNacimiento = scanner.nextLine();

            System.out.print("Carrera: ");
            String carrera = scanner.nextLine();

            // Solicitar emisión de diploma
            Diploma diploma = servidorUniversidad.emitirDiploma(ci, nombres, primerApellido,
                    segundoApellido, fechaNacimiento, carrera);

            System.out.println("\n=== RESULTADO ===");
            if (diploma.getMensaje().isEmpty()) {
                System.out.println("DIPLOMA EMITIDO EXITOSAMENTE");
                System.out.println("Nombre: " + diploma.getNombreCompleto());
                System.out.println("Carrera: " + diploma.getCarrera());
                System.out.println("Fecha de emisión: " + diploma.getFecha());
            } else {
                System.out.println("✗ ERRORES ENCONTRADOS:");
                System.out.println(diploma.getMensaje());
            }

            scanner.close();

        } catch (Exception e) {
            System.err.println("Error en cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
