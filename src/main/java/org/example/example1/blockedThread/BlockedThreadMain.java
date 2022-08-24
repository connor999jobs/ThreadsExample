package org.example.example1.blockedThread;

import lombok.SneakyThrows;

public class BlockedThreadMain {
    public static void main(String[] args) {
        BlockedThread blockedThread = new BlockedThread();
        blockedThread.blockedThread();
    }
}



class BlockedThread{
    @SneakyThrows
    public void blockedThread(){
        Thread t1 = new Thread(new SyncCode());
        Thread t2 = new Thread(new SyncCode());

        t1.start();
        Thread.sleep(2000);
        t2.start();
        Thread.sleep(2000);

        System.out.println("Blocked Thread t1: " + t1.getState() + "(" + t1.getName() + ")");
        System.out.println("Blocked Thread t2: " + t2.getState() + "(" + t2.getName() + ")");
        System.exit(0);
    }

    public static class SyncCode implements Runnable {
        @Override
        public void run() {
            System.out.println("Нить " + Thread.currentThread().getName() + " находиться в методе run() ");
            syncMethod();
        }

        public static synchronized void syncMethod() {
            System.out.println("Нить " + Thread.currentThread().getName() + " находиться в методе syncMethod");
            while (true){
// Так как у нас беск цикл один поток будет постоянно Runnable а другой Blocked так как метод синхронизированый
            }
        }


    }
}
