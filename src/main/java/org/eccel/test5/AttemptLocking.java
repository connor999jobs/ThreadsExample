package org.eccel.test5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private ReentrantLock reentrantLock = new ReentrantLock();
    public void unlimited(){
        boolean capture = reentrantLock.tryLock();
        try {
            System.out.println("tryLock(): " + capture);
        } finally {
            if (capture)
                reentrantLock.lock();
        }
    }

    public void timed(){
        boolean capture = false;
        try {
            capture = reentrantLock.tryLock(2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.MILLISECONDS): " + capture);
        } finally {
            if (capture)
                reentrantLock.lock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking attemptLocking = new AttemptLocking();
        attemptLocking.unlimited();
        attemptLocking.timed();

        new Thread(() -> {
            attemptLocking.reentrantLock.lock();
            System.out.println("acquired");
        }).start();

        Thread.yield();

        attemptLocking.unlimited();
        attemptLocking.timed();
    }
}
