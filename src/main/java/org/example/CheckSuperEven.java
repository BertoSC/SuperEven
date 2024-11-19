package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckSuperEven implements Callable {
    private Number num;
    private ExecutorService pool;

    public CheckSuperEven (Number i) {
        this.num=i;
        this.pool= Executors.newFixedThreadPool(2);
    }

    @Override
    public Number call() throws Exception {
        char[] number = String.valueOf(num.getNum()).toCharArray();
        for (char c : number) {
            Future<Boolean> b = pool.submit(new CheckEven(Character.getNumericValue(c)));
            boolean res = b.get();
            if (!res) {
                num.setSupereven(false);
            }
        }

        pool.shutdown();
        return num;
    }

    /*
    @Override
    public String call() throws Exception {
        char[] number = String.valueOf(num.getNum()).toCharArray();
        for (char c : number) {
            Future<Boolean> b = pool.submit(new CheckEven(Character.getNumericValue(c)));
            boolean res = b.get();

            if (!res) {
               num.setSupereven(false);
            }
        }


        String result;

        if (num.getSuperEven()) {
            result = num.getNum() + " is super even";
        } else {
            result = num.getNum() + " is not super even";
        }

        pool.shutdown();
        return result;
    }

     */

}