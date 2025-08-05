/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.Clases.Operaciones;

/**
 *
 * @author Admin
 */
public class Factorial implements IOperacion{

    @Override
    public int getResultado(int n) {
        int result = 1;
        for (int i = 1; i<= n; i++){
            result *= i;
        }
        return result;
    }
}
