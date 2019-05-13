package Lekcja3.Zad2;

class AddingThread extends Thread {

    private Counter c;

     public AddingThread(Counter c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            c.inc(i);
        }
    }
}

class Counter {
    private int x = 0;
    synchronized void  inc (int value) {
        int sum = x + value;
        x = sum;
    }
    public String toString() {
        return x + "";
    }
}

public class Main {

    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.println(c);
        AddingThread at0 = new AddingThread(c);
        at0.start();
        AddingThread at1 = new AddingThread(c);
        at1.start();
        AddingThread at2 = new AddingThread(c);
        at2.start();
        System.out.println("Counter.x=" + c);
    }
}