package org.example.example2;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor

public class ThreadPoolExecutor implements Runnable {
    private final int taskId;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(2000);
        System.out.println("Исполнение операции " + taskId + " с помощью " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);
        final AtomicInteger counter = new AtomicInteger();

        ThreadFactory threadFactory = (Runnable r) -> {
            System.out.println("Создание новой нити Cool-Thread " + counter.incrementAndGet());

            return new Thread(r, "Cool-Thread " + counter.get());
        };

        RejectedExecutionHandler rejectedExecutionHandler = (Runnable r, Threadp)
    }
}
