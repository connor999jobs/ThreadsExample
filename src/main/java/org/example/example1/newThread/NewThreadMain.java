package org.example.example1.newThread;

public class NewThreadMain {
}

class NewThread{
    public void newThread(){
        Thread threadNEW = new Thread(() ->{});
        System.out.println("New Thread: " + threadNEW.getState());
    }
}
