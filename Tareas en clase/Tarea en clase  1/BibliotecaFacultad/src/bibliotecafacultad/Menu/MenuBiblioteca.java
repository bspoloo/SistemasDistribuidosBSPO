package bibliotecafacultad.Menu;

import bibliotecafacultad.Clases.Armarios.Armario;
import bibliotecafacultad.Clases.Armarios.ArmarioEnum;
import bibliotecafacultad.Clases.Biblioteca.Biblioteca;
import bibliotecafacultad.Database.BibliotecaDAO;

import java.util.List;
import java.util.Scanner;

public class MenuBiblioteca implements IMenu{
    private BibliotecaDAO bibliotecaDAO;
    public MenuBiblioteca(){
        this.bibliotecaDAO = new BibliotecaDAO("jdbc:mysql://localhost:3306/db_bibliotecas", "root", "root");
    }
    @Override
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("\n===== MENÚ BIBLIOTECA =====");
            System.out.println("1.- Mostrar Bibliotecas");
            System.out.println("2.- Insertar Biblioteca");
            System.out.println("3.- Añadir armario a biblioteca");
            System.out.println("0.- Salir");
            System.out.print("Opción: ");

            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    List<Biblioteca> bibliotecas = bibliotecaDAO.listarBilbliotecas();
                    for (Biblioteca biblioteca : bibliotecas) {
                        System.out.println("==========================================================");
                        System.out.println("Id: " + biblioteca.getId());
                        System.out.println("Nombre: " + biblioteca.getNombre());
                        System.out.println("Tamaño en m2: " + biblioteca.getTamaño());
                    }
                    System.out.println("==========================================================");
                    break;
                case 2:
                    Biblioteca biblioteca = new Biblioteca();
                    biblioteca.setId(0);

                    scanner.nextLine(); // Limpia el buffer
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    biblioteca.setNombre(nombre);

                    System.out.print("Tamaño: ");
                    int tamaño = scanner.nextInt();
                    biblioteca.setTamaño(tamaño);

                    bibliotecaDAO.insertarBiblioteca(biblioteca);
                    break;
                case 3:
                    Armario armario = new Armario();
                    scanner.nextLine();

                    System.out.print("Codigo: ");
                    String codigo = scanner.nextLine();
                    armario.setCodigo(codigo);

                    System.out.print("Tipo: ");
                    String tipoText = scanner.nextLine();
                    ArmarioEnum tipo = ArmarioEnum.valueOf(tipoText);
                    armario.setTipo(tipo);

                    System.out.print("Id de la biblioteca: ");
                    int bibliotecaId = scanner.nextInt();
                    armario.setBibliotecaId(bibliotecaId);

                    bibliotecaDAO.insertarArmario(armario);
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}