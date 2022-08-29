package org.eccel.test3;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriority implements Runnable{
    private int countDown = 5;
    private volatile double d;
    private final int priority;

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 1; i < 100_000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0){
                    Thread.yield();
                }
                System.out.println(this);
                if (--countDown == 0)
                    return;
            }
        }
    }



    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < 5; i++) {
                executorService.execute(new SimplePriority(Thread.MIN_PRIORITY));
                executorService.execute(new SimplePriority(Thread.MAX_PRIORITY));

                executorService.shutdown();
            }
    }
}
