using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de EstudiantesDao
/// </summary>
public class EstudiantesDao
{
    private List<Estudiante> estudiantes;
    public EstudiantesDao()
    {
        this.estudiantes = new List<Estudiante>();
        this.InitEstudiantes();
    }
    private void InitEstudiantes()
    {
        this.estudiantes.Add(new Estudiante() { CI="12345678", Nombres="Juan Jose", Apellidos="Perez limona", Carrera="Ciencias", Promedio=12.322});
        this.estudiantes.Add(new Estudiante() { CI="23232423", Nombres="Elias", Apellidos="Cayo Lites", Carrera="Quimica", Promedio=23.32});
        this.estudiantes.Add(new Estudiante() { CI="21321314", Nombres="Brayan Pepe", Apellidos="Polo Orellana", Carrera="Sistemas", Promedio=43.32});
        this.estudiantes.Add(new Estudiante() { CI="65656565", Nombres="Ariel Juan", Apellidos="Palacios Rodas", Carrera="Psycologia", Promedio=1.23});
        this.estudiantes.Add(new Estudiante() { CI="87687667", Nombres="Maria Jose", Apellidos="Amurrio Palma", Carrera="Telecomunicaciones", Promedio=90.23});
        this.estudiantes.Add(new Estudiante() { CI="67676754", Nombres="Ana Lia", Apellidos="Paco Jorge", Carrera="Diseño", Promedio=23.434});
    }
    public List<Estudiante> GetEstudiantes()
    {
        return this.estudiantes;
    }
    public Estudiante ObtenerDatosAcademicos(String CI)
    {
        Estudiante estudianteFounded = null;
        foreach(Estudiante estudiante in this.estudiantes)
        {
            if(estudiante.CI.Equals(CI))
            {
                estudianteFounded = estudiante;
                break;
            }
        }
        return estudianteFounded;
    }
    public Tutor ObtenerDatosTutor(String CI)
    {
        return new Tutor() { NombreEstudiante = "Juan Perez", CorreoTutor = "animetx098@gmail.com", TelefonoTutor = "72886425", TutorAsignado = "Elias Lopez" };
    }
}