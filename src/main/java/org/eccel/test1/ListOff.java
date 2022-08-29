package org.eccel.test1;





public class ListOff implements Runnable{
    protected int count = 10;
    private static int countDown = 0;
    private final int id = countDown++;

    public ListOff() {
    }

    public ListOff(int count) {
        this.count = count;
    }

    public String status(){
        return "# " + id + "(" + (count > 0 ? count : "ListOff") + ") ";
    }

    @Override
    public void run() {
        while (count-- > 0){
            System.out.println(status());
//            Thread.yield();
        }
    }
}
