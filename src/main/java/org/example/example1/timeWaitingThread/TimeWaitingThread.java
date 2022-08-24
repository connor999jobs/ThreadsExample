package org.example.example1.timeWaitingThread;

import lombok.SneakyThrows;

public class TimeWaitingThread {
    public static void main(String[] args) {
        TimeWaitingThread thread = new TimeWaitingThread();
        thread.timeWaitingThread();
    }



    @SneakyThrows
    public void timeWaitingThread(){
        Thread thread = new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(5000);
        System.out.println("TimeWaitingThread t: " + thread.getState());
    }
}
