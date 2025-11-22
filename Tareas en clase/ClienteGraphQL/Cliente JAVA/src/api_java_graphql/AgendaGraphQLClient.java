/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api_java_graphql;

/**
 *
 * @author elmer
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AgendaGraphQLClient {
    private static final String API_URL = "http://127.0.0.1:8000/api";
    private static final String GRAPHQL_URL = "http://127.0.0.1:8000/graphql";
    private static String token = "";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("=== Agenda GraphQL Client ===");
            login();
            menu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Login REST para obtener token
    public static void login() throws Exception {
        System.out.print("Email (admin@test.com): ");
        String email = scanner.nextLine();
        if (email.isEmpty()) email = "admin@test.com";
        
        System.out.print("Password (password123): ");
        String password = scanner.nextLine();
        if (password.isEmpty()) password = "password123";

        String loginJson = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";

        URL url = new URL(API_URL + "/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Enviar datos
        try (OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream())) {
            writer.write(loginJson);
        }

        // Leer respuesta
        String response = readResponse(conn);
        
        if (response.contains("\"token\"")) {
            // Extraer token manualmente
            String[] parts = response.split("\"token\":\"");
            if (parts.length > 1) {
                token = parts[1].split("\"")[0];
                System.out.println("Login exitoso");
            }
        } else {
            System.out.println("Error en login: " + response);
            System.exit(1);
        }
    }

    // GraphQL Request Helper
    public static String graphqlRequest(String query) throws Exception {
        // Escapar comillas en la query
        String escapedQuery = query.replace("\"", "\\\"").replace("\n", " ");
        String graphqlJson = "{\"query\":\"" + escapedQuery + "\"}";

        URL url = new URL(GRAPHQL_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);

        // Enviar datos
        try (OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream())) {
            writer.write(graphqlJson);
        }

        return readResponse(conn);
    }

    // Leer respuesta HTTP
    public static String readResponse(HttpURLConnection conn) throws Exception {
        BufferedReader reader;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

    // Menu principal
    public static void menu() throws Exception {
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Listar personas (GraphQL)");
            System.out.println("2. Crear persona (GraphQL)");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            
            String opcion = scanner.nextLine();
            
            switch (opcion) {
                case "1": 
                    listarPersonas(); 
                    break;
                case "2": 
                    crearPersona(); 
                    break;
                case "3": 
                    System.out.println("bye");
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    // Listar personas con GraphQL
    public static void listarPersonas() throws Exception {
        String query = "query { personas { id nombres apellidos ci email } }";
        
        String response = graphqlRequest(query);
        System.out.println("\n=== Lista de Personas ===");
        
        // Parse manual simple
        if (response.contains("\"personas\"")) {
            String[] personas = response.split("\\{\"id\":");
            for (int i = 1; i < personas.length; i++) {
                String persona = personas[i];
                
                // Extraer campos manualmente
                String id = extractValue(persona, "", ",");
                String nombres = extractValue(persona, "\"nombres\":\"", "\"");
                String apellidos = extractValue(persona, "\"apellidos\":\"", "\"");
                String ci = extractValue(persona, "\"ci\":\"", "\"");
                String email = extractValue(persona, "\"email\":\"", "\"");
                
                System.out.println("ID: " + id + " - " + nombres + " " + apellidos + 
                                 " - CI: " + ci + " - Email: " + email);
            }
        } else {
            System.out.println("No se encontraron personas o error: " + response);
        }
    }

    // Crear persona con GraphQL
    public static void crearPersona() throws Exception {
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("CI: ");
        String ci = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        String mutation = "mutation { createPersona(nombres: \\\"" + nombres + 
                         "\\\", apellidos: \\\"" + apellidos + 
                         "\\\", ci: \\\"" + ci + 
                         "\\\", email: \\\"" + email + 
                         "\\\") { id nombres apellidos ci email } }";

        String response = graphqlRequest(mutation);
        
        if (response.contains("\"createPersona\"") && response.contains("\"id\"")) {
            System.out.println(" Persona creada exitosamente");
        } else {
            System.out.println("Error al crear persona: " + response);
        }
    }

    // Helper para extraer valores del JSON manualmente
    public static String extractValue(String text, String start, String end) {
        try {
            int startIndex = start.isEmpty() ? 0 : text.indexOf(start) + start.length();
            if (startIndex == -1 + start.length()) return "";
            
            int endIndex = text.indexOf(end, startIndex);
            if (endIndex == -1) endIndex = text.length();
            
            return text.substring(startIndex, endIndex);
        } catch (Exception e) {
            return "";
        }
    }
}
