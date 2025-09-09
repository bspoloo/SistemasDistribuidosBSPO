package practica3.rmi.sockets.clients;

import java.io.*;
import java.net.Socket;

public class ClienteSEDUCA {

    public static String verificarBachiller(String rude) {
        try (Socket socket = new Socket("localhost", 12345); PrintWriter out = new PrintWriter(socket.getOutputStream(), true); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("verificar-rude:" + rude);
            return in.readLine();

        } catch (IOException e) {
            return "no:Error de conexión con SEDUCA";
        }
    }
}
