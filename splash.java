import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class splash {

    public static void main(String[] args) {
        // write your code here
        Splashframe frame = new Splashframe();
        frame.setVisible(true);
        int x=1;
        for (int i = 1; i <= 700; i+=5,x++) {
            frame.setLocation(500-(x+i)/2 ,200-i/4);
            frame.setSize(i+x, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {}

        }


    }

     static  class Splashframe extends JFrame implements Runnable {

            Thread t1;

            Splashframe() {
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
                Image i2 = i1.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel l1 = new JLabel(i3);
                add(l1);

                //          setBounds(200,200,1600,700);
                setUndecorated(true);
                t1 = new Thread(this);
                t1.start();

            }

            public void run() {
                try {
                    Thread.sleep(5000);
                    this.setVisible(false);
                    new login().setVisible(true);
                } catch (Exception e) {
                }
            }
        }
    }
