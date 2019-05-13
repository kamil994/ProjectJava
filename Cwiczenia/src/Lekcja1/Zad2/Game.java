package Lekcja1.Zad2;

public class Game extends OnlineGame {
    boolean logged;
    boolean login(String name, String password){
        logged=true;
        return logged;
    }
    public void play(){
        if (logged) System.out.println("Playing with friends");
        else System.out.println("Not logged");
    }

}
