package org.shield.phaser;

import lombok.SneakyThrows;

import java.util.concurrent.Phaser;

public class PhaserThreads extends Thread{
    Phaser phaser;
    String name;

    public PhaserThreads(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    @SneakyThrows
    public void run() {
//        System.out.println("Поток " + name + " начинает первую фазу");
//        phaser.arriveAndAwaitAdvance();
//        Thread.sleep(10);
//
//        System.out.println("Поток " + name + " начинает вторую фазу");
//        phaser.arriveAndAwaitAdvance();
//        Thread.sleep(10);
//
//        System.out.println("Поток " + name + " начинает третьью фазу");
//        phaser.arriveAndDeregister();


        while (!phaser.isTerminated()){
            System.out.println("Поток " + name + " начинает фазу " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

        }

    }
}
