/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.clases;

import java.io.Serializable;
import primerparcial.enums.Banco;

/**
 *
 * @author USUARIO
 */
public class Cuenta implements Serializable{
    private String ci;
    private String nombres;
    private String apellidos;
    private String nro_cuenta;
    private double saldo;
    private Banco banco;

    public Cuenta(String ci, String nombres, String apellidos, String nro_cuenta, double saldo, Banco banco) {
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nro_cuenta = nro_cuenta;
        this.saldo = saldo;
        this.banco = banco;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
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

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    
}
