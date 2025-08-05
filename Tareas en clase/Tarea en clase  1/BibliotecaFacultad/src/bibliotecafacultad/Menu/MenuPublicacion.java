package bibliotecafacultad.Menu;

import bibliotecafacultad.Clases.Biblioteca.Biblioteca;
import bibliotecafacultad.Clases.Publicaciones.*;
import bibliotecafacultad.Database.BibliotecaDAO;

import java.util.List;
import java.util.Scanner;

public class MenuPublicacion implements IMenu{
    private BibliotecaDAO bibliotecaDAO;
    public MenuPublicacion(){
        this.bibliotecaDAO = new BibliotecaDAO("jdbc:mysql://localhost:3306/db_bibliotecas", "root", "root");
    }
    @Override
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("\n===== MENÚ Publicacion =====");

            System.out.println("1.- Mostrar Publicaciones");
            System.out.println("2.- Insertar Publicacion");
            System.out.println("3.- Salim");
            System.out.print("Opción: ");

            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    List<Publicacion> publicaciones = bibliotecaDAO.listarPublicaciones();
                    for (Publicacion biblioteca : publicaciones) {
                        System.out.println("==========================================================");
                        System.out.println("Id: " + biblioteca.getId());
                        System.out.println("Nombre: " + biblioteca.getNombre());
                        System.out.println("Codigo armario: " + biblioteca.getArmarioCodigo());
                    }
                    System.out.println("==========================================================");
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Seleccione el tipo de publicación (LIBRO / REVISTA / PERIODICO): ");
                    String tipo = scanner.nextLine().toUpperCase();

                    Publicacion publicacion = null;

                    switch (tipo) {
                        case "LIBRO":
                            System.out.print("Autor: ");
                            String autor = scanner.nextLine();

                            System.out.print("Editorial: ");
                            String editorial = scanner.nextLine();

                            System.out.print("Año: ");
                            int anioLibro = scanner.nextInt();

                            publicacion = new Libro(nombre, autor, editorial, anioLibro);
                            break;

                        case "REVISTA":
                            System.out.print("Mes: ");
                            String mes = scanner.nextLine();

                            System.out.print("Año: ");
                            int anioRevista = scanner.nextInt();
                            scanner.nextLine(); // limpiar Enter pendiente

                            System.out.print("Tipo de revista (CIENTIFICA / TECNICA / DIVULGATIVA): ");
                            String tipoRevistaStr = scanner.nextLine().toUpperCase();

                            try {
                                PeriodicoEnum tipoRevista = PeriodicoEnum.valueOf(tipoRevistaStr);
                                Revista revista = new Revista(nombre);
                                revista.setMes(mes);
                                revista.setAño(anioRevista);
                                revista.setTipo(tipoRevista);
                                publicacion = revista;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Tipo de revista inválido.");
                            }
                            break;

                        case "PERIODICO":
                            System.out.print("Fecha (YYYY-MM-DD): ");
                            String fecha = scanner.nextLine();

                            Periodico periodico = new Periodico(nombre);
                            periodico.setFecha(fecha);

                            publicacion = periodico;
                            break;

                        default:
                            System.out.println("Tipo de publicación inválido.");
                    }
                    if (publicacion != null) {
                        bibliotecaDAO.insertarPublicacion(publicacion);
                        System.out.println("Publicación insertada correctamente.");
                    } else {
                        System.out.println("No se pudo insertar la publicación.");
                    }
                    break;
                default:
                    System.out.println("Error en escoger una opcion");
            }
        }
    }
}
