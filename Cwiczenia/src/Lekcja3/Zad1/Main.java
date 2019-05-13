package Lekcja3.Zad1;

public class Main {
    public static void main(String[] args) {
        long[] tab = new long[4];
        long time = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long time2=System.currentTimeMillis();
                for (int i = 0; i < 1000000; i += 2) {
                    System.out.println(i);
                    if (i==999998){
                        System.out.println(System.currentTimeMillis()-time2);
                    }


                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long time2=System.currentTimeMillis();
                for (int i = 1; i < 1000000; i += 2) {
                    System.err.println(i);
                    if (i==999999){
                        System.out.println(System.currentTimeMillis()-time2);
                    }

                }
            }
        });

        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }
        tab[0] = System.currentTimeMillis() - time;
        time = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        tab[1] = System.currentTimeMillis() - time;
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);

        }
        ;


    }
}
