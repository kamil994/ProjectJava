package Lekcja4.Zad2;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Window okno=new Window(1024,768,"Hello World",true);
            okno.move();
        });
    }
}

class Window extends JFrame{


    public Window(int width, int height, String title,boolean visible){
        super();


        super.setVisible(visible);
        super.setSize(width,height);
        super.setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }
    public void move(){
        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                repaint();
            }
        });
        b.start();
    }

    public void paint(Graphics g){
        g.setColor(new Color(255, 1, 100));
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawOval(getWidth()/2-40, getHeight()/2-40, 40, 40);


    }


}

