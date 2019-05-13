package Lekcja1.Zad1;

public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        game.play();
        game.shoot();
    }
}
interface IsGame{
    void play();
}
interface IsStrategic{
    void nextTurn();
}
interface IsRPG{
    void takeQuest();
}
interface IsShooter{
    void shoot();
}

