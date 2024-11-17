package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckSuperEven implements Callable {
    private Number num;
    private static final ExecutorService EX = Executors.newFixedThreadPool(2);

    public CheckSuperEven (Number i){
        this.num=i;
    }

    @Override
    public String call() throws Exception {
        char[] number = String.valueOf(num.getNum()).toCharArray();
        for (char c : number) {
            Future<Boolean> b = EX.submit(new CheckEven(Character.getNumericValue(c)));
            boolean res = b.get();
            if (!res) {
                num.setSupereven(false);
                break;
            }
        }

        EX.shutdown();

        String result;
        if (num.getSuperEven()) {
            result = num.getNum() + " is super even";
        } else {
            result = num.getNum() + " is not super even";
        }
        return result;
    }
}
