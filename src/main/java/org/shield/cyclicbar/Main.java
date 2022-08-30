package org.shield.cyclicbar;

import java.util.concurrent.CyclicBarrier;

public class Main   {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new BarAction());
        System.out.println("Запуск потоков");

        new MyThread(barrier,"A").start();
        new MyThread(barrier, "B").start();
        new MyThread(barrier,"C").start();

        new MyThread(barrier,"z").start();
        new MyThread(barrier, "x").start();
        new MyThread(barrier,"c").start();

    }
}
