package Lekcja1.Zad1;

public class Game implements IsGame, IsShooter {
    public void play(){
        System.out.println("Play");
    }
    public void shoot(){
        System.out.println("Shoot");
    }
}
