package org.example.classes;

import java.util.ArrayList;

public class Bilbioteca {
    private String nombre;
    private int tamano;
    private ArrayList<Armario> armarios;

    public  Bilbioteca(String nombre, int tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getTamano() {
        return this.tamano;
    }
    public void añadirArmario(Armario armario) {
        this.armarios.add(armario);
    }
}
