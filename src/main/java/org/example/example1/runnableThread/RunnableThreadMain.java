package org.example.example1.runnableThread;

public class RunnableThreadMain {
    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread();
        runnableThread.runnableThread();
    }
}

class RunnableThread {
    public void runnableThread() {
        Thread threadRunnable = new Thread(() -> {
        });
        System.out.println("Runnable thread: " + threadRunnable.getState());
    }
}
