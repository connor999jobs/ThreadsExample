package org.shield.cyclicbar;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@AllArgsConstructor
public class MyThread extends Thread{
    CyclicBarrier barrier;
    String name;

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(name);
        barrier.await();
    }
}
