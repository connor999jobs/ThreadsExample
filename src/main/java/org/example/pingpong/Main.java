package org.example.pingpong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class Main {

    private final static Semaphore ping = new Semaphore(1);
    private final static Semaphore pong = new Semaphore(0);
    private static final int count = 3;


    @SneakyThrows
    public static void main(String[] args) {
        PingPongSemaphore semaphorePing = new PingPongSemaphore("Ping", ping,pong, count);
        PingPongSemaphore semaphorePong = new PingPongSemaphore("Pong", pong,ping,count);
        System.out.println("Start game");
        semaphorePing.start();
        semaphorePong.start();
        semaphorePing.join();
        semaphorePong.join();
        System.out.println("Game Over");
    }
}

