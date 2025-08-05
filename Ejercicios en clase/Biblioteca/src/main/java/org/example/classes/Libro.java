package org.example.classes;

public class Libro extends Publicacion{
    private String autor;
    private String editorial;
    private int año;
    public Libro(String nombre, String autor, String editorial, int año) {
        super(nombre);
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.año = año;
    }
}