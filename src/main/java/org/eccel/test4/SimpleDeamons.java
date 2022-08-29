package org.eccel.test4;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class SimpleDeamons implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread deamon = new Thread(new SimpleDeamons());
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("Все демоны запущены");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
