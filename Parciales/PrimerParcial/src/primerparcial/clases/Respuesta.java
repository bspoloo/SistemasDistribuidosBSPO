/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.clases;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Respuesta implements Serializable{
    private boolean error;
    private String mensajeError;
    private List<Cuenta> cuentas;

    public Respuesta(boolean error, String mensajeError, List<Cuenta> cuentas) {
        this.error = error;
        this.mensajeError = mensajeError;
        this.cuentas = cuentas;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }   
}
