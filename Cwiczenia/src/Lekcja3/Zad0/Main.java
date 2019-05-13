package Lekcja3.Zad0;

public class Main {
    public static void main(String[] args) {


        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println(i);
                }

            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i=0;i<100;i++){
                System.err.println(i);
            }

        });
        thread0.start();
        thread1.start();
    }
}