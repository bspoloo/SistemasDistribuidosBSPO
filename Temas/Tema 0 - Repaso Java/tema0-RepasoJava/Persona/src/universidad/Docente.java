package universidad;

import persona.Persona;
import persona.Sexo;

public class Docente extends Persona {

    String nit;
    Carrera carrera;
    Materia[] listaMaterias;

    public Docente(String nombres, String apellidos, String numeroDocumento, Sexo sexo) {
        super(nombres, apellidos, numeroDocumento, sexo);
    }
}
