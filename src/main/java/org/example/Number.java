package org.example;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Number {
    private AtomicInteger num;
    private AtomicBoolean supereven;

    public Number(int i){
        this.num = new AtomicInteger(i);
        this.supereven = new AtomicBoolean(true);
    }

    public int getNum(){
        return num.get();
    }

    public void setNum(int n) {
        this.num = new AtomicInteger(n);
    }

    public boolean getSuperEven(){
        return supereven.get();
    }

    public void setSupereven(boolean even) {
        this.supereven.getAndSet(even);
    }
}