/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.java.classes;

/**
 *
 * @author Animetx
 */
public class Persona {

    private String nombres;
    private String apellidos;
    private String ci;
    private String direccion;
    private String telefono;
    private String email;
    
    public Persona() {}
    public Persona(String nombres, String apellidos, String ci, String direccion, String telefono, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getBodyText() {
        return "{"
                + "\"nombres\": \"" + this.nombres + "\","
                + "\"apellidos\": \"" + this.apellidos + "\","
                + "\"ci\": \"" + this.ci + "\","
                + "\"direccion\": \"" + this.direccion + "\","
                + "\"telefono\": \"" + this.telefono + "\","
                + " \"email\": \"" + this.email + "\" "
                + "}";
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
