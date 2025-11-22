/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3.classes;

import ejercicio3.interfaces.ICadena;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Animetx
 */
public class Cadena extends UnicastRemoteObject implements ICadena {

    private String cadena;

    public Cadena() throws RemoteException {
        super();
        this.cadena = "CADENA DEFAULT";
    }

    @Override
    public boolean guardarFrase(String frase) {
        if (frase.trim().isEmpty()) {
            return false;
        }
        this.cadena = frase;
        return true;
    }

    @Override
    public String convertirMayusculas() {
        return this.cadena.toUpperCase();
    }

    @Override
    public String duplicarEspacios(int n) {
        String[] parts = this.cadena.split(" ");
        String newCadena = "";
        for (String part : parts) {
            for (int i = 0; i < n; i++) {
                part += " ";
            }
            newCadena += part;
        }
        return newCadena;
    }

    @Override
    public String concatenar(String extra) {
        return this.cadena + extra;
    }
}
