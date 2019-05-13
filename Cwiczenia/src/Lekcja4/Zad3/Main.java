package Lekcja4.Zad3;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Window okno = new Window(1024, 768, "Hello World", true);
            okno.move();
        });
    }
}

class Window extends JFrame {
    int x,y,radius;

    public Window(int width, int height, String title, boolean visible) {
        super();
        super.setVisible(visible);
        super.setSize(width, height);
        super.setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        x=getWidth()/2;
        y=getHeight()/2;
        radius=100;


    }

    public void move() {
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean x1=true;
                boolean y1=true;
                while (true) {

                    if ((x)==getWidth()) x1=false;
                    if (x==0+radius) x1=true;
                    if ((y)==getHeight()) y1=false;
                    if (y==0+radius) y1=true;
                    if (x1 && y1){
                        x++;
                        y++;
                    }
                    else if (x1 && !y1){
                        x++;
                        y--;
                    }
                    else if (!x1 && y1){
                        x--;
                        y++;
                    }
                    else {
                        x--;
                        y--;
                    }




                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        b.start();
    }

    public void paint(Graphics g) {
        g.setColor(new Color(255, 1, 100));
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawOval(x-radius, y-radius, radius, radius);


    }


}

