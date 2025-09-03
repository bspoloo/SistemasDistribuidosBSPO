/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketmutihilo.clases;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ProcesadorProtocolo {

    String numeros = "";
    private final Socket s;

    public ProcesadorProtocolo(Socket s, String numeros) {
        this.numeros = numeros;
        this.s = s;
    }

    public String procesar(String mensaje) {
        String[] protocolo = mensaje.split(":");

        String respuesta;
        System.out.println("El mensaje del cliente es: " + mensaje);
        try {
            if (!this.existenNumeros() && !protocolo[1].equals("introducir")) {
                return "mensaje:no enviio los a y b";
            }
            if (protocolo[1].equals("introducir")) {
                this.numeros = protocolo[2];
                System.out.println("numeros: "+protocolo[2]);
                if (numeros != null) {
                    respuesta = "mensaje: guardado datos";
                }else{
                    respuesta = "mesaje: no se guardaron los numeros";
                }
            } else if (protocolo[1].equals("sumar")) {
                respuesta = "mensaje:" + (Integer.parseInt(numeros.split(",")[0]) + Integer.parseInt(numeros.split(",")[1]));
            } else if (protocolo[1].equals("restar")) {
                respuesta = "mensaje:" + (Integer.parseInt(numeros.split(",")[0]) - Integer.parseInt(numeros.split(",")[1]));
            } else if (protocolo[1].equals("multiplicar")) {
                respuesta = "mensaje:" + (Integer.parseInt(numeros.split(",")[0]) * Integer.parseInt(numeros.split(",")[1]));
            } else if (protocolo[1].equals("dividir")) {
                respuesta = "mensaje:" + (Integer.parseInt(numeros.split(",")[0]) / Integer.parseInt(numeros.split(",")[1]));
            } else if (protocolo[1].equals("salir")) {
                respuesta = "mensaje: cerrando servidor";
                this.s.close();
            } else {
                respuesta = "mensaje: comando incorrecto";
            }
        } catch (IOException e) {
            e.printStackTrace();
            respuesta = "message: error en procesar informacion";
        }
        return respuesta;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }

    private boolean existenNumeros() {
        if (this.numeros == null || "".equals(this.numeros.trim())) {
            return false;
        }
        return true;
    }
}
