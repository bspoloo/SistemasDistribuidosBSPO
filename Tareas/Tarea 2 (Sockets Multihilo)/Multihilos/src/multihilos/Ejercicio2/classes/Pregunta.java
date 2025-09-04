/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihilos.Ejercicio2.classes;

import java.util.ArrayList;

/**
 *
 * @author Animetx
 */
public class Pregunta {

    private String titulo;
    private int opcionCorrecta;
    private ArrayList<String> opciones;

    public Pregunta(String titulo) {
        this.titulo = titulo;
        this.opciones = new ArrayList<>();
    }

    public void addOpcion(String opcion) {
        this.opciones.add(opcion);
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getOpciones() {
        return this.opciones;
    }

    public void setOpcionCorrecta(int opcionCorrecta) {
        if (opcionCorrecta < 0 && opcionCorrecta > this.opciones.size()) {
            System.out.println("Opcion " + opcionCorrecta + " fuera de rango");
            return;
        }
        this.opcionCorrecta = opcionCorrecta;
    }

    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public boolean verificarOpcionCorrecta(int opcion) {
        if (this.opcionCorrecta == opcion) {
            System.out.println("Opcion correcta");
            return true;
        }
        return false;
    }
}
