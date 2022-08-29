package org.example.pingpong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;


@AllArgsConstructor
public class PingPongSemaphore extends Thread {
    private String startPlay;
    private Semaphore first;
    private Semaphore second;
    private int count;

    @Override
    @SneakyThrows
    public void run() {
        while (count > 0){
            first.acquire();
            System.out.println(startPlay);
            Thread.sleep(1000);
            second.release();
            count--;
        }
    }
}
