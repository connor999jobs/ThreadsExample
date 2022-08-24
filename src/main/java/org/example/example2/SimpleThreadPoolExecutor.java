package org.example.example2;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor

public class SimpleThreadPoolExecutor implements Runnable {
    private final int taskId;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(2000);
        System.out.println("Исполнение операции " + taskId + " с помощью " + Thread.currentThread().getName());
    }

    @SneakyThrows
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);
        final AtomicInteger counter = new AtomicInteger();

        ThreadFactory threadFactory = (Runnable r) -> {
            System.out.println("Создание новой нити Cool-Thread " + counter.incrementAndGet());

            return new Thread(r, "Cool-Thread " + counter.get());
        };

        RejectedExecutionHandler rejectedExecutionHandler = (Runnable r, ThreadPoolExecutor executor) ->{
            if (r instanceof SimpleThreadPoolExecutor){
                SimpleThreadPoolExecutor task = (SimpleThreadPoolExecutor) r;
                System.out.println("Отклонение операции " + task.taskId);
            }
        };

        ThreadPoolExecutor executor  = new ThreadPoolExecutor(10,20,1,TimeUnit.SECONDS,
                queue, threadFactory, rejectedExecutionHandler);

        for (int i = 0; i < 50; i++) {
            executor.execute(new SimpleThreadPoolExecutor(i));
        }
        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}
