package org.eccel.test6;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class AtomicIntegerTest implements Runnable{
    private AtomicInteger i = new AtomicInteger(0);

    public AtomicInteger getI() {
        return i;
    }

    private void evenIncrement(){
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        AtomicIntegerTest test = new AtomicIntegerTest();
        service.execute(test);
        while (true){
            int val = test.getI().incrementAndGet();
            if (val % 2 !=0 )
                System.out.println(val);
            System.exit(0);
        }
    }
}
