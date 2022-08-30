package org.eccel.test4_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()){
            int val = intGenerator.next();
            if (val % 2 != 0){
                System.out.println(val + " нечетное");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count){
        System.out.println("Нажмите Ctrl + C что б завершить программу");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(generator,i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator generator){
        test(generator,10);
    }
}
