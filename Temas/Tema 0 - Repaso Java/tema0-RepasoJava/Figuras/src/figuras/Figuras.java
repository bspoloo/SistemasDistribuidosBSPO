/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figuras;

import java.util.ArrayList;
import java.util.function.IntFunction;

/**
 *
 * @author Dell
 */
public class Figuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<IFigura> listaFiguras = new ArrayList<>();

        IFigura triangulo = new Triangulo(4);
        IFigura circulo = new Circulo(4);
        IFigura cuadrado = new Cuadrado(4);

        listaFiguras.add(triangulo);
        listaFiguras.add(circulo);
        listaFiguras.add(cuadrado);

        for (IFigura figura : listaFiguras){
            System.out.println("La figura tiene un area de: " + figura.area() + " y un perimetro de: " + figura.perimetro());
        }
    }
    
}
