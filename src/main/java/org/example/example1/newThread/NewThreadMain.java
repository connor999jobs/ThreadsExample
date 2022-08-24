package org.example.example1.newThread;

public class NewThreadMain {
    public static void main(String[] args) {
        NewThread nt = new NewThread();
        nt.newThread();
    }
}

class NewThread{
    public void newThread(){
        Thread threadNEW = new Thread(() ->{});
        System.out.println("New Thread: " + threadNEW.getState());
    }
}
