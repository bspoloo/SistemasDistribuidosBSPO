package bibliotecafacultad.Clases.Biblioteca;

import bibliotecafacultad.Clases.Armarios.Armario;

import java.util.ArrayList;

public class Biblioteca {
    private int id;
    private String nombre;
    private float tamaño;
    private ArrayList<Armario> armarios;

    public Biblioteca() {}
    public Biblioteca(int id, String nombre, float tamaño) {
        this.id = id;
        this.nombre = nombre;
        this.tamaño = tamaño;
    }
    public String getNombre() { return this.nombre;}
    public float getTamaño() { return this.tamaño;}
    public int getId() {return id;}
    public void setId(int id) {this. id = id; }
    public void setNombre(String nombre) {this.nombre = nombre; }
    public void setTamaño(float tamaño) {this.tamaño = tamaño; }

    public void añadirArmario(Armario armario) {
        this.armarios.add(armario);
    }
}
