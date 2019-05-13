package Lekcja3.Zad3;

public class Main {
    public static void main(String[] args) {
        Account account1=new Account();
        Account account2=new Account();
        System.out.println(account1);
        System.out.println(account2);
        for (int i=0;i<100;i++){
        AddingThread at0 = new AddingThread(account1,account2,(int)(Math.random()*account1.balance));
        at0.start();
        AddingThread at1 = new AddingThread(account1,account2,(int)(Math.random()*account1.balance));
        at1.start();
        AddingThread at2 = new AddingThread(account2,account1,(int)(Math.random()*account2.balance));
        at2.start();}


    }
}
class AddingThread extends Thread {

    private Account c,d;
    private long value;

    public AddingThread(Account c,Account d, long value) {
        this.c = c;
        this.d=d;
        this.value=value;
    }

    public void run() {
        c.transaction(d,value);
        }
    }


class Account {
    long balance = 10000;
    synchronized void  transaction (Account acc,long value) {
        if (this.balance>=value) {
            this.balance -= value;

            acc.balance += value;

        }
        System.out.println(this.balance);
        System.out.println(acc.balance);
        System.out.println(this.balance+acc.balance);

    }
    public String toString() {
        return balance + "";
    }
}