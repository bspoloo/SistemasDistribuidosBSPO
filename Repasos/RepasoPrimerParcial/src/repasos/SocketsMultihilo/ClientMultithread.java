/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.SocketsMultihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Animetx
 */
public class ClientMultithread {

    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);

            InetAddress ip = InetAddress.getByName("localhost");
            Socket socket = new Socket(ip, 5056);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println(dis.readUTF());
                String toSend = scanner.nextLine();
                dos.writeUTF(toSend);

                if (toSend.equals("Exit")) {
                    System.out.println("Closing this connection: " + socket);
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                String received = dis.readUTF();
                System.out.println(received);
            }
            scanner.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
