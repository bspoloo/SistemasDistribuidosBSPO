/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.classes;

import ejercicio2.enums.Status;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Animetx
 */
public class ClientHandler extends Thread {

    private final SensorMannager sensorMannager;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final Socket s;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.sensorMannager = new SensorMannager();
    }

    public void sentMessage(String message) throws IOException {
        dos.writeUTF(message);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = dis.readUTF();
                System.out.println(received);

                //añadir:<id>-<status>
                //reporte
                String[] parts = received.split(":");
                if (parts.length < 1) {
                    dos.writeUTF("Formato incorrecto, siga el formato -> <id>:<status> o reporte");
                    continue;
                }

                String command = parts[0];
                String data = parts[1];
                switch (command) {
                    case "agregar":
                        String id = data.split("-")[0];
                        Status status = Status.valueOf(data.split("-")[1].toUpperCase());
                        boolean response = this.sensorMannager.addSensor(new Sensor(id, status));
                        if (response) {
                            this.sentMessage("message:"+id + " " + "añadido correctamente");
                        } else {
                            this.sentMessage("message:error en añadir " + id);
                        }
                        break;
                    case "reporte":
                        try {
                            Sensor sensor = this.sensorMannager.getCriticStatus();
                            if (sensor != null) {
                                this.sentMessage("reporte: El sensor con estado critico es ->" +sensor.getId()+" " +sensor.getStatus());
                            } else {
                                this.sentMessage("message:Usted aun no tiene sensores con estado critico registrados");
                            }
                        } catch (NumberFormatException e) {
                            this.sentMessage("message:" + data + " no es el id de una sensor");
                        }
                        break;
                    default:
                        dos.writeUTF("Comando inválido");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Cliente " + s + " cerró la conexión.");
        }
    }
}
