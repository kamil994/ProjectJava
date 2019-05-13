package Lekcja5.Zad0;

public class Main {
    public static void main(String[] args) {
        Wrapper a=new Wrapper(50);
        System.out.println(a);
        Wrapper b=new Wrapper("Kamil");
        System.out.println(b);
    }
}

class Wrapper<T>{
    T value;
    Wrapper ( T value){
        this.value=value;
    }
    public String toString(){
        return ""+this.value;
    }
}