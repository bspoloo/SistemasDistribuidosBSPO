/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.Clases.Operaciones;

/**
 *
 * @author Admin
 */
public class Fibonacci implements IOperacion{

    @Override
    public int getResultado(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getResultado(n-1) + getResultado(n-2);
    }
}
