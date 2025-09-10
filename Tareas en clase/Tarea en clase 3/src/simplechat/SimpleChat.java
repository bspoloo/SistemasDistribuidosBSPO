package simplechat;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class SimpleChat extends ReceiverAdapter {

    JChannel channel; // Canal para el grupo de comunicación
    private String user_name; // atributo para el usuario
    final List<String> state = new LinkedList<>();

    public SimpleChat(String user_name) {
        this.user_name = user_name;
    }

    public void viewAccepted(View new_view) {
        System.out.println("Vista del grupo actualizada: " + new_view);
    }

    public void receive(Message msg) {
        
        System.out.println("PRocesando Mensajes");
        String voto = (String) msg.getObject();
        synchronized (state) {
            state.add(voto);
        }

        
        int tutofinal = 0;
        int rodrigofinal = 0;
        for(String st:state){
         
            String[] conteo = st.split("\\|");
            String[] votos = conteo[1].split(",");
            tutofinal = tutofinal + Integer.parseInt(votos[0]);
            rodrigofinal = rodrigofinal + Integer.parseInt(votos[1]);

            System.out.println(st);
        }
        System.out.println("====================== ");
        System.out.println("VOTOS TOTALES");
        System.out.println("TUTO:" + tutofinal);
        System.out.println("RODRIGO:" + rodrigofinal);
    }

    public void getState(OutputStream output) throws Exception {
        synchronized (state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    @SuppressWarnings("unchecked")
    public void setState(InputStream input) throws Exception {
        List<String> list = (List<String>) Util.objectFromStream(new DataInputStream(input));
        synchronized (state) {
            state.clear();
            state.addAll(list);
        }
        System.out.println("estado recibido (" + list.size() + " mensajes en la historia del chat ):");
        for (String str : list) {
            System.out.println(str);
        }
    }

    public void start() throws Exception {
        // Crear el canal y conectar al grupo
        channel = new JChannel();  // Utiliza UDP por defecto
        channel.setReceiver(this); // El objeto que recibirá los mensajes
        //channel.getProtocolStack().getTransport().setValue("bind_addr", java.net.InetAddress.getByName("10.126.84.166")); // tu IP local
        channel.connect("ChatCluster");  // Conecta al grupo ChatCluster
        channel.getState(null, 10000); // Opcional, para obtener estado compartido si lo hay
        eventLoop(); // Comienza a leer y enviar mensajes
        channel.close(); // Cierra el canal cuando se termine
    }

    private void eventLoop() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
       while (true) {
            try {
                System.out.print("Mesa:");
                System.out.flush();
                String line = in.readLine().toLowerCase();
                if (line.startsWith("quit") || line.startsWith("exit")) {
                    break; //finaliza el bucle
                }
                System.out.print("Tuto:");
                System.out.flush();
                String line1 = in.readLine().toLowerCase();
                System.out.print("Rodrigo");
                System.out.flush();
                String line2 = in.readLine().toLowerCase();
                if (line.startsWith("quit") || line.startsWith("exit")) {
                    break; //finaliza el bucle
                }
                line = "conteo:" + line + "|"+line1+","+line2;
                // Envía el mensaje al grupo
                Message msg = new Message(null, line); //crea mensaje
                channel.send(msg);  // envia al grupo
            } catch (Exception e) {
           }
        }
    }

}