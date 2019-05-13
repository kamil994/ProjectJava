package Lekcja4.Zad1;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window okno=new Window(1024,768,"Hello World");

             });
    }
}

class Window extends JFrame{
    int width,height;
    String title;

    public Window(int width, int height, String title){
        this.width=width;
        this.height=height;
        this.title=title;
        JFrame okno=new JFrame();
        okno.setSize(this.width, this.height);
        okno.setTitle(this.title);
        okno.setVisible(true);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }
}