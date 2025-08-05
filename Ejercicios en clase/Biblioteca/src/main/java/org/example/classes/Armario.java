package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Armario {
    protected String codigo;
    protected List<Publicacion> publicaciones;

    public Armario(String codigo) {
        this.codigo = codigo;
    }
    public void añadirPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
    }
}
