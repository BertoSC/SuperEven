package org.example;

import java.util.concurrent.Callable;

public class CheckEven implements Callable {
    private int i;

    public CheckEven(int n){
        this.i=n;
    }

    @Override
    public Object call() throws Exception {
        return i % 2 == 0;
    }
}