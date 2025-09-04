package multihilos.Ejercicio2;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import multihilos.Ejercicio2.classes.Pregunta;

public class ServerPreguntas {

    public static List<ClientHandler> clients = new ArrayList<>();
    public static List<Pregunta> preguntas = new ArrayList<>();
    public static int clientId = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);
        System.out.println("Servidor iniciado en puerto 5056...");

        initPreguntas();
        
        new Thread(() -> {
            try {
                while (true) {
                    Socket s = ss.accept();
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                    ClientHandler client = new ClientHandler(s, dis, dos, clientId++);
                    clients.add(client);
                    client.start();
                    client.sentMessage("setting:Su id de jugador es"+client.getIdCliente()+":"+client.getIdCliente());
                    System.out.println("Cliente conectado: ID " + client.getIdCliente());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-----------PREGUNTAS------------");
            for (int i = 0; i < preguntas.size(); i++) {
                System.out.println(i + ".- " + preguntas.get(i).getTitulo());
            }
            System.out.println("Seleccione una pregunta a enviar: ");
            int option = scanner.nextInt();

            if (option < 0 || option >= preguntas.size()) {
                System.out.println("Opcion fuera de rango");
                continue;
            }

            broadcastPregunta(option);
        }
    }

    private static void initPreguntas() {
        Pregunta pregunta1 = new Pregunta("Que es GPT");
        pregunta1.addOpcion("Una inteligencia artificial");
        pregunta1.addOpcion("Una persona");
        pregunta1.addOpcion("Una casal");
        pregunta1.setOpcionCorrecta(1);

        Pregunta pregunta2 = new Pregunta("Que es anime");
        pregunta2.addOpcion("Dibujos japoneses");
        pregunta2.addOpcion("Series casuales");
        pregunta2.addOpcion("Dibujos por personas");
        pregunta2.setOpcionCorrecta(1);

        Pregunta pregunta3 = new Pregunta("Quien es The Score");
        pregunta3.addOpcion("Banda de reguetón");
        pregunta3.addOpcion("Banda de jazz");
        pregunta3.addOpcion("Banda de rock");
        pregunta3.setOpcionCorrecta(3);

        preguntas.add(pregunta1);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);
    }

    public static void broadcastPregunta(int preguntaIndex) {
        Pregunta p = preguntas.get(preguntaIndex);
        String mensaje = "pregunta:" + p.getTitulo() + ":" + String.join(",", p.getOpciones());

        for (ClientHandler c : clients) {
            try {
                c.sentMessage(mensaje);
                c.setPreguntaActual(p); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
