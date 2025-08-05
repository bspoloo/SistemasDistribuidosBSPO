package org.example.classes;

public class Factorial implements IOperation{
    @Override
    public int executeResult(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }
}
