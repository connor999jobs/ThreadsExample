package org.shield.cyclicbar;


public class BarAction implements Runnable{
    @Override
    public void run() {
        System.out.println("Барьер достигнут");
    }
}
