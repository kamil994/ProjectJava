package ProjectI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

//            Window okno = new Window(1024, 768, "Hello World", true);
//            try {
//                okno.createFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            okno.move();
            Show show=new Show(1024,768,"Hello World",true);
            try {
                show.show2();
            } catch (IOException e) {
                e.printStackTrace();
            }
            show.move();


        });
    }
}

class Window extends JFrame {

    float xScale;
    float yScale;
    HashMap<Integer, double[]> triangle = new HashMap<Integer, double[]>();
    HashMap<Integer, double[]> elipse = new HashMap<Integer, double[]>();
    HashMap<Integer, double[]> rectangle = new HashMap<Integer, double[]>();
    int indexElipse=0;

    int indexRectangle=0;
    int indexTriangle=0;
    public Window(int width, int height, String title, boolean visible) {
        super();
        super.setVisible(visible);
        super.setSize(width, height);
        super.setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        xScale=getWidth();
        yScale=getHeight();


    }


    public void move() {
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {


                    while(true){



                    repaint(10000);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}

            }
        });
//        Thread b2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//
//                }
//            }
//        });

        b.start();
//        b2.start();
    }
    public void createFile() throws IOException{
        BufferedWriter writer=new BufferedWriter(new FileWriter("figures.txt"));
        writer.write("");
        writer.close();


    }
    public void toFile(String string)
        throws IOException{
        BufferedWriter writer=new BufferedWriter(new FileWriter("figures.txt",true));

        writer.append(string);
        writer.newLine();
        writer.close();

    }
    public double round2Decimals(double a){
        double b=100*a;
        b=Math.round(b);
        b=b/100;
        return b;
    }
//    public void scale(Graphics g) throws IOException{
////        FileReader fileReader=new FileReader("figures.txt");
////        BufferedReader bufferedReader=new BufferedReader(fileReader);
////        String textLine = bufferedReader.readLine();
////        do {
////            Pattern p = Pattern.compile("\\d\\p{Punct}\\d[^\\s]");
////            Matcher m = p.matcher(textLine);
//////            Pattern p2=Pattern.compile("\\d\\p{Punct}\\d[^\\s]");
//////            Matcher m2=p2.matcher(textLine);
////
////            while (m.find()){
//////                System.out.print(m2.group());
////                System.out.print((Float.parseFloat(m.group())));
////                System.out.print((Float.parseFloat(m.group())));
////                System.out.println();
////
////            }
////
////            textLine = bufferedReader.readLine();
////        } while(textLine != null);
////
////        bufferedReader.close();
////
//        for (int i=0;i<indexElipse;i++){
//            g.setColor(new Color((int)elipse.get(i)[6],(int)elipse.get(i)[7],(int)elipse.get(i)[8]));
//            g.drawOval((int)(elipse.get(i)[0]*elipse.get(i)[4]),(int)(elipse.get(i)[1]*elipse.get(i)[5]),(int)(elipse.get(i)[2]*elipse.get(i)[4]),(int)(elipse.get(i)[3]*elipse.get(i)[5]));
//        }
//    }

    public void paint(Graphics g) {
        int figure=(int)(Math.random()*3);
        int x,y,r2,g2,b2;
        r2=(int)(Math.random()*256);
        g2=(int)(Math.random()*256);
        b2=(int)(Math.random()*256);
        g.setColor(new Color(r2,g2,b2));
        //g.drawRect(10,35,getWidth()-20,getHeight()-50);
        double getXScale,getYScale;
        getXScale=getWidth()/xScale;
        getYScale=getHeight()/yScale;
        switch(figure){
            case 0:
                int radius1,radius2;
                double[] tabElipse=new double[9];
                radius1=(int)(Math.random()*(xScale-30));
                radius2=(int)(Math.random()*(yScale-85));
                x=(int)(Math.random()*(xScale-radius1-30)+10);
                y=(int)(Math.random()*(yScale-radius2-85)+35);
                g.drawOval((int)(x*getXScale),(int)(y*getYScale),(int)(radius1*getXScale),(int)(radius2*getYScale));
                try {
                    toFile("Elipse "+x+" "+y+" "+radius1+" "+radius2+" "+r2+" "+g2+" "+b2+" Scale: "+ round2Decimals(getXScale)+" "+round2Decimals(getYScale));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tabElipse[0]=x;tabElipse[1]=y;tabElipse[2]=radius1;tabElipse[3]=radius2;tabElipse[4]=getXScale;tabElipse[5]=getYScale;tabElipse[6]=r2;tabElipse[7]=g2;tabElipse[8]=b2;
                System.out.println(getYScale);
                System.out.println(getXScale);
                elipse.put(indexElipse++,tabElipse);
                //System.out.println(elipse.get(indexElipse-1));
                break;
            case 1:
                double[] tabRectangle=new double[9];
                int width,height;
                width=(int)(Math.random()*(xScale-30));
                height=(int)(Math.random()*(yScale-85));
                x=(int)(Math.random()*(xScale-width-30)+10);
                y=(int)(Math.random()*(yScale-height-85)+35);
                g.drawRect((int)(x*getXScale),(int)(y*getYScale),(int)(width*getXScale),(int)(getYScale*height));
                try {
                    toFile("Rectangle "+x+" "+y+" "+width+" "+height+ " "+r2+" "+g2+" "+b2+" Scale: "+ round2Decimals(getXScale)+" "+round2Decimals(getYScale));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tabRectangle[0]=x;tabRectangle[1]=y;tabRectangle[2]=width;tabRectangle[3]=height;tabRectangle[4]=getXScale;tabRectangle[5]=getYScale;tabRectangle[6]=r2;tabRectangle[7]=g2;tabRectangle[8]=b2;

                rectangle.put(indexRectangle++,tabRectangle);
                //System.out.println(rectangle.get(indexRectangle-1));
                break;
            case 2:
                double[] tabTriangle=new double[11];
                int[] a=new int[2];
                int[] b=new int[2];
                int[] c=new int[2];
                a[1]=(int)(Math.random()*(yScale-85))+35;
                a[0]=(int)(Math.random()*(xScale-30))+10;
                b[1]=(int)(Math.random()*(yScale-85))+35;
                b[0]=(int)(Math.random()*(xScale-30))+10;
                c[1]=(int)(Math.random()*(yScale-85))+35;
                c[0]=(int)(Math.random()*(xScale-30))+10;
                g.drawLine((int)(a[0]*getXScale),(int)(a[1]*getYScale),(int)(b[0]*getXScale),(int)(b[1]*getYScale));
                g.drawLine((int)(b[0]*getXScale),(int)(b[1]*getYScale),(int)(c[0]*getXScale),(int)(c[1]*getYScale));
                g.drawLine((int)(a[0]*getXScale),(int)(a[1]*getYScale),(int)(c[0]*getXScale),(int)(c[1]*getYScale));
                try {
                    toFile("Triangle "+a[0]+" "+a[1]+" "+b[0]+" "+b[1]+" "+c[0]+" "+c[1]+" "+r2+" "+g2+" "+b2+" Scale: "+ round2Decimals(getXScale)+" "+round2Decimals(getYScale));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tabTriangle[0]=a[0];tabTriangle[1]=a[1];tabTriangle[2]=b[0];tabTriangle[3]=b[1];tabTriangle[4]=c[0];tabTriangle[5]=c[1];tabTriangle[6]=getXScale;tabTriangle[7]=getYScale;tabTriangle[8]=r2;tabTriangle[9]=g2;tabTriangle[10]=b2;

                triangle.put(indexTriangle++,tabTriangle);
                //System.out.println(triangle.get(indexTriangle-1)[0]);
                break;
            default:



        }
        for (int i=0;i<indexElipse;i++){
            g.setColor(new Color((int)elipse.get(i)[6],(int)elipse.get(i)[7],(int)elipse.get(i)[8]));
            g.drawOval((int)(elipse.get(i)[0]*(getWidth()/xScale)),(int)(elipse.get(i)[1]*(getHeight()/yScale)),(int)(elipse.get(i)[2]*(getWidth()/xScale)),(int)(elipse.get(i)[3]*(getHeight()/yScale)));
        }
        for (int i=0;i<indexTriangle;i++){
            g.setColor(new Color((int)triangle.get(i)[8],(int)triangle.get(i)[9],(int)triangle.get(i)[10]));
            g.drawLine((int)(triangle.get(i)[0]*(getWidth()/xScale)),(int)(triangle.get(i)[1]*(getHeight()/yScale)),(int)(triangle.get(i)[2]*(getWidth()/xScale)),(int)(triangle.get(i)[3]*(getHeight()/yScale)));
            g.drawLine((int)(triangle.get(i)[0]*(getWidth()/xScale)),(int)(triangle.get(i)[1]*(getHeight()/yScale)),(int)(triangle.get(i)[4]*(getWidth()/xScale)),(int)(triangle.get(i)[5]*(getHeight()/yScale)));
            g.drawLine((int)(triangle.get(i)[4]*(getWidth()/xScale)),(int)(triangle.get(i)[5]*(getHeight()/yScale)),(int)(triangle.get(i)[2]*(getWidth()/xScale)),(int)(triangle.get(i)[3]*(getHeight()/yScale)));
        }
        for (int i=0;i<indexRectangle;i++){
            g.setColor(new Color((int)rectangle.get(i)[6],(int)rectangle.get(i)[7],(int)rectangle.get(i)[8]));
            g.drawRect((int)(rectangle.get(i)[0]*(getWidth()/xScale)),(int)(rectangle.get(i)[1]*(getHeight()/yScale)),(int)(rectangle.get(i)[2]*(getWidth()/xScale)),(int)(rectangle.get(i)[3]*(getHeight()/yScale)));
        }

        }






}

class Show extends JFrame{

    float xScale;
    float yScale;
    HashMap<Integer, double[]> triangle = new HashMap<Integer, double[]>();
    HashMap<Integer, double[]> elipse = new HashMap<Integer, double[]>();
    HashMap<Integer, double[]> rectangle = new HashMap<Integer, double[]>();
    int indexElipse=0;

    int indexRectangle=0;
    int indexTriangle=0;
    double[] tabTriangle=new double[11];
    public Show(int width, int height, String title, boolean visible) {
        super();
        super.setVisible(visible);
        super.setSize(width, height);
        super.setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        xScale=getWidth();
        yScale=getHeight();


    }
    public void move() {
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {


                while(true){



                    repaint();
                    }

            }
        });
//        Thread b2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//
//                }
//            }
//        });

        b.start();
//        b2.start();
    }

    public void paint(Graphics g){
//        System.out.println(indexElipse);
//        System.out.println(indexTriangle);
//        System.out.println(indexRectangle);
        for (int i=0;i<indexElipse;i++){
            g.setColor(new Color((int)elipse.get(i)[6],(int)elipse.get(i)[7],(int)elipse.get(i)[8]));
            g.drawOval((int)(elipse.get(i)[0]*(getWidth()/xScale)),(int)(elipse.get(i)[1]*(getHeight()/yScale)),(int)(elipse.get(i)[2]*(getWidth()/xScale)),(int)(elipse.get(i)[3]*(getHeight()/yScale)));
        }
        for (int i=0;i<indexTriangle;i++){
            g.setColor(new Color((int)triangle.get(i)[8],(int)triangle.get(i)[9],(int)triangle.get(i)[10]));
            g.drawLine((int)(triangle.get(i)[0]*(getWidth()/xScale)),(int)(triangle.get(i)[1]*(getHeight()/yScale)),(int)(triangle.get(i)[2]*(getWidth()/xScale)),(int)(triangle.get(i)[3]*(getHeight()/yScale)));
            g.drawLine((int)(triangle.get(i)[0]*(getWidth()/xScale)),(int)(triangle.get(i)[1]*(getHeight()/yScale)),(int)(triangle.get(i)[4]*(getWidth()/xScale)),(int)(triangle.get(i)[5]*(getHeight()/yScale)));
            g.drawLine((int)(triangle.get(i)[4]*(getWidth()/xScale)),(int)(triangle.get(i)[5]*(getHeight()/yScale)),(int)(triangle.get(i)[2]*(getWidth()/xScale)),(int)(triangle.get(i)[3]*(getHeight()/yScale)));
        }
        for (int i=0;i<indexRectangle;i++){
            g.setColor(new Color((int)rectangle.get(i)[6],(int)rectangle.get(i)[7],(int)rectangle.get(i)[8]));
            g.drawRect((int)(rectangle.get(i)[0]*(getWidth()/xScale)),(int)(rectangle.get(i)[1]*(getHeight()/yScale)),(int)(rectangle.get(i)[2]*(getWidth()/xScale)),(int)(rectangle.get(i)[3]*(getHeight()/yScale)));
        }
    }
        public void show2() throws IOException{
        FileReader fileReader=new FileReader("figures.txt");
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String textLine = bufferedReader.readLine();

            int index;
        do {
//            Pattern p = Pattern.compile("\\d\\p{Punct}\\d[^\\s]");
//            Matcher m = p.matcher(textLine);
//            Pattern p2=Pattern.compile("\\d\\p{Punct}\\d[^\\s]");
//            Matcher m2=p2.matcher(textLine);
            Pattern p=Pattern.compile("(\\d{1,4}\\h)|(\\d\\p{Punct}\\d{1,})");
            Matcher m=p.matcher(textLine);

            index=0;
            double[] tabElipse=new double[9];
            double[] tabRectangle=new double[9];
            double[] tabTriangle=new double[11];
            while (m.find()){


                if (textLine.charAt(0)=='T'){
                    tabTriangle[index++]=Double.parseDouble(m.group());
                }
                else if(textLine.charAt(0)=='E'){
                    tabElipse[index++]=Double.parseDouble(m.group());
                }
                else{
                    tabRectangle[index++]=Double.parseDouble(m.group());
                }
//                System.out.print(m2.group());
//                System.out.print((Float.parseFloat(m.group())));
//                System.out.print((Float.parseFloat(m.group())));
//                System.out.println();


            }
            if (textLine.charAt(0)=='T'){

                triangle.put(indexTriangle++,tabTriangle);
            }
            else if(textLine.charAt(0)=='E'){

                elipse.put(indexElipse++,tabElipse);
            }
            else{

                rectangle.put(indexRectangle++,tabRectangle);
            }



            textLine = bufferedReader.readLine();
        } while(textLine != null);
        for (int i=0;i<indexTriangle;i++){
            for (int j=0;j<triangle.get(i).length;j++){
                System.out.print(triangle.get(i)[j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        bufferedReader.close();


    }

}


