package org.example;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    private final static int NUM_THREADS= 4;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Random rm = new Random();

        int num1 = rm.nextInt(1, 10001);
        int num2 = rm.nextInt(1, 10001);

        int minNum= Math.min(num1, num2);
        int maxNum= Math.max(num1, num2);

        ExecutorService pool1 = Executors.newFixedThreadPool(NUM_THREADS);
        Set <Future> results = new HashSet<>();
        for (int i = minNum; i<= maxNum; i++){
            Number n = new Number(i);
            Callable<Integer> check = new CheckSuperEven(n);
            Future<Integer> fut= pool1.submit(check);
            results.add(fut);
        }

        for (Future f:results){
            System.out.println(f.get());
        }

        pool1.shutdown();

    }
}