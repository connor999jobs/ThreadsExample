package org.example.example1.terminatedThread;

import lombok.SneakyThrows;

public class TerminatedThread {
    public static void main(String[] args) {
        TerminatedThread thread = new TerminatedThread();
        thread.terminatedThread();
    }



    @SneakyThrows
    public void terminatedThread (){
        Thread thread = new Thread( () -> {});
        thread.start();

        Thread.sleep(1000);

        System.out.println("Thread t:"  + thread.getState());
    }
}
