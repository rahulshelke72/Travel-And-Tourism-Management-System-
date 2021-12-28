import javax.swing.*;
import java.awt.*;

public class loadingframe extends JFrame implements Runnable{

    JProgressBar p;
    Thread t;
    String username;


    public void run(){
        try {

            for(int i=1;i<=101;i++) {
                int m = p.getMaximum();
                int n = p.getValue();

                if (n < m) {

                    p.setValue(p.getValue() + 1);
                }
                else
                {
                    n = 101;
                    setVisible(false);
                    new dashboard(username).setVisible(true);
                }
                Thread.sleep(50);
            }

        }catch (Exception e){}
    }



    loadingframe(String user){

        setBounds(100,100,600,300);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        username=user;

        t=new Thread(this);

        JLabel l1=new JLabel("Travel And Tourism Application");
        l1.setBounds(100,0,400,50);
        l1.setFont(new Font("Tahoma",Font.BOLD,24));
        l1.setForeground(Color.BLUE);
        add(l1);

        p=new JProgressBar();
        p.setStringPainted(true);
        p.setBounds(200,70,200,25);
        add(p);


        JLabel l2=new JLabel("Please Wait....");
        l2.setBounds(250,80,120,70);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.red);
        add(l2);

        JLabel l3=new JLabel("Welcome "+username);
        l3.setBounds(20,200,120,50);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.red);
        add(l3);


        t.start();
        setVisible(true);

    }
    public static void main(String args[]){

        new loadingframe("").setVisible(true);
    }
}
