package org.eccel.test2;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures =new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            futures.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : futures){
            System.out.println(fs.get());
            exec.shutdown();
        }
    }
}
