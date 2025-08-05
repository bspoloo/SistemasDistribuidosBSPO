package org.example.classes;

public class Sumatoria implements IOperation{

    @Override
    public int executeResult(int n) {
        int result = 0;
        for (int i = 0; i < n; i++){
            result += i;
        }
        return result;
    }
}
