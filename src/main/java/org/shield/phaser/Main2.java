package org.shield.phaser;

public class Main2 {
    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser(1,4);
        System.out.println("Start");
        new PhaserThreads(phaser,"A").start();
        new PhaserThreads(phaser,"B").start();
        new PhaserThreads(phaser,"C").start();

        while (!phaser.isTerminated()){
            phaser.arriveAndAwaitAdvance();

        }

        System.out.println("End");
    }
}
