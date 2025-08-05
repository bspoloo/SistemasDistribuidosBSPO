package org.example.classes;

public class Fibonacci implements IOperation{
    @Override
    public int executeResult(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return executeResult(n-1) +(n-2);
    }
}
