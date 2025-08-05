package bibliotecafacultad.Menu;

import bibliotecafacultad.Clases.Armarios.Armario;
import bibliotecafacultad.Clases.Armarios.ArmarioEnum;
import bibliotecafacultad.Clases.Publicaciones.*;
import bibliotecafacultad.Database.BibliotecaDAO;

import java.util.List;
import java.util.Scanner;

public class MenuArmario implements IMenu {

    private final BibliotecaDAO bibliotecaDAO;

    public MenuArmario() {
        this.bibliotecaDAO = new BibliotecaDAO("jdbc:mysql://localhost:3306/db_bibliotecas", "root", "root");
    }

    @Override
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 4) {
            System.out.println("\n===== MENÚ ARMARIO =====");
            System.out.println("1.- Mostrar Armarios");
            System.out.println("2.- Insertar Armario");
            System.out.println("3.- Añadir publicación");
            System.out.println("4.- Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    List<Armario> armarios = bibliotecaDAO.listarArmarios();
                    for (Armario armario : armarios) {
                        System.out.println("------------------------------------------------");
                        System.out.println("Código: " + armario.getCodigo());
                        System.out.println("Tipo: " + armario.getTipo());
                        System.out.println("Biblioteca: " + armario.getBibliotecaId());
                        System.out.println("------------------------------------------------");
                    }
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese código del armario: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Ingrese tipo de armario (Metalico o Madera): ");
                    String tipoTexto = scanner.nextLine();

                    System.out.print("Ingrese el Id de la biblioteca: ");
                    int bibliotecaId = scanner.nextInt();

                    try {
                        ArmarioEnum tipo = ArmarioEnum.valueOf(tipoTexto);
                        Armario armario = new Armario(codigo, tipo, bibliotecaId);

                        bibliotecaDAO.insertarArmario(armario);
                        System.out.println("Armario insertado correctamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo inválido. Los valores válidos son: BIOLOGIA, INGENIERIA, LITERATURA, etc.");
                    }

                    break;

                case 3:
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

                case 4:
                    System.out.println("Saliendo del menú de armarios...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
