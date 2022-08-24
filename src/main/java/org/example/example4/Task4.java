package org.example.example4;

import org.example.example3.AssemblyLine;

import java.util.Random;
import java.util.concurrent.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Task4 {
    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());

    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int MAX_PROD_BULBS = 1500;

    private static final Random rnd = new Random();
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private static final Consumer consumer = new Consumer();

    private static long startTime;
    private static ExecutorService consumerService;

    public Task4() {
        throw new AssertionError("There is a single assembly line!");
    }

    private static class Consumer implements Runnable{
        @Override
        public void run() {
            String bubl =  queue.poll();
            if (bubl != null){
                logger.info( () -> "Packed: " + bubl + " by consumer: " + Thread.currentThread().getName() );
            }

            if (queue.isEmpty()){
                logger.info( () -> "The consumers team packed all bubl in " + (System.currentTimeMillis() - startTime)
                + " ms");

                logger.info("Note: It is possible to see the above message multiple times...");

                System.exit(0);
            }
        }
    }


    public static void starAssemblyLine(){
        simulatingProducers();
        startConsumers();
    }

    private static void startConsumers(){
        logger.info( () -> "We have a consumers team of "
                + PROCESSORS + " members ...");

        consumerService = Executors.newWorkStealingPool();
        int queueSize = queue.size();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < queueSize; i++) {
            consumerService.execute(consumer);
        }

        consumerService.shutdown();

        try {
            consumerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex){
            Logger.getLogger(Task4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void simulatingProducers(){
        logger.info("Simulating the job of the producers overnight ...");
        logger.info(() -> "The producers checked " + MAX_PROD_BULBS + " bulbs ...");

        for (int i = 0; i < MAX_PROD_BULBS; i++) {
            queue.offer("bulb-" + rnd.nextInt(1000));
        }
    }
}
