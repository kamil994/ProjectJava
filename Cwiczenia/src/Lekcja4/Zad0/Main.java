package Lekcja4.Zad0;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window okno1=new Window(1024,768,"Hello World");
            JFrame okno = new JFrame();
            okno.setSize(okno1.width, okno1.height);
            okno.setTitle(okno1.title);
            okno.setVisible(true);
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

    }
}