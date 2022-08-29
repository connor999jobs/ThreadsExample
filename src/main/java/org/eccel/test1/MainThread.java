package org.eccel.test1;

public class MainThread {
    public static void main(String[] args) {
//        ListOff listOff = new ListOff();
//        listOff.run();

//        Thread thread = new Thread(new ListOff());
        for (int i = 0; i < 5; i++) {
           new Thread(new ListOff()).start();
        }

        System.out.print("Waiting for List Off");
    }
}
