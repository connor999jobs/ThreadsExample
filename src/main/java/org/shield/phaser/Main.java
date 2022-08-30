package org.shield.phaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currPhase;

        System.out.println("Старт потоков");
        System.out.println();
        new PhaserThreads(phaser,"A").start();
        new PhaserThreads(phaser,"B").start();
        new PhaserThreads(phaser,"C").start();

        currPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currPhase + " завершена");
        System.out.println();

        currPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currPhase + " завершена");
        System.out.println();

        currPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currPhase + " завершена");
        System.out.println();

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()){
            System.out.println("End");
        }
    }
}
