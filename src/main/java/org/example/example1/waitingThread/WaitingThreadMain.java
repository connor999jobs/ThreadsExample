package org.example.example1.waitingThread;

import lombok.SneakyThrows;

public class WaitingThreadMain {

    public void waitingThread()    {
        new Thread( () -> {
            Thread t1 = Thread.currentThread();

            Thread t2 = new Thread( () -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("WaitingThread t1: " + t1.getState());
            });

            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


    public static void main(String[] args) {
        WaitingThreadMain waitingThreadMain = new WaitingThreadMain();
        waitingThreadMain.waitingThread();
    }

}


