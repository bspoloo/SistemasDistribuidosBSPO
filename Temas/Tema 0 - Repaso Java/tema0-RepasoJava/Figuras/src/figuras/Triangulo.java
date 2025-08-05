/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

/**
 *
 * @author Dell
 */
public class Triangulo implements IFigura{
    int lado;

    public Triangulo(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    @Override
    public int area() {
        return (lado * lado) /2 ;
    }

    @Override
    public int perimetro() {
        return lado*3;
    }
    
}
