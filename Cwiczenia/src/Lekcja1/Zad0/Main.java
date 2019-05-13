package Lekcja1.Zad0;

public class Main {
    public static void main(String[] args) {
        CosCoJedzie auto=new CosCoJedzie(){
            public void Jedz(){
                System.out.println("jade");

            }
        };
        auto.Jedz();
    }
}
