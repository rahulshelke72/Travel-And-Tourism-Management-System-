import javax.swing.*;
import java.awt.*;
public class CheckPackage extends JFrame {
    CheckPackage(){

        setBounds(160,50,800,550);

        String[] package3=new String[]{"BRONZE PACKAGE","6 Days and 7 Nights ","Airport Assistance","Half Day City Tour","Daily Buffet","Welcome Drinks on Arrival","Full Day 3 Island Cruise","English Speaking Guide","BOOK NOW","SUMMER SPECIAL","20000/-","package1.jpg"};
        String[] package2=new String[]{"SILVER PACKAGE","5 Days and 6 Nights ","Toll Free and Entrance Free Tickets","Meet and Greet at Airport","Welcome Drinks on Arrival","Night Safari","Full Day 3 Island Cruise","Cruise with Dinner","BOOK NOW","WINTER SPECIAL","35000/-","package2.jpg"};
        String[] package1=new String[]{"GOLD PACKAGE","6 Days and 5 Nights ","Return Airfare","Free Clubbing,Horse Riding  and ...","Welcome Drinks on Arrival","Daily Buffet","Stay in Five Star Hotel","BBQ Dinner","BOOK NOW","WINTER SPECIAL","50000/-","package3.jpg"};

        JTabbedPane pane=new JTabbedPane();

        JPanel p1=createpackage(package1);
        pane.addTab("Package 1",null,p1);

        JPanel p2=createpackage(package2);
        pane.addTab("Package 2",null,p2);


        JPanel p3= createpackage(package3);
        pane.addTab("Package 3",null,p3);



        add(pane , BorderLayout.CENTER);

    }

    public static JPanel createpackage(String[] pack){
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel l1=new JLabel(pack[0]);
        l1.setBounds(200,10,300,30);
        l1.setFont(new Font("TAHOMA",Font.PLAIN,24));
        p1.add(l1);

        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(20,50,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("TAHOMA",Font.PLAIN,18));
        p1.add(l2);


        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(20,100,300,30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("TAHOMA",Font.PLAIN,18));
        p1.add(l3);

        JLabel l4=new JLabel(pack[3]);
        l4.setBounds(20,150,300,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("TAHOMA",Font.PLAIN,18));
        p1.add(l4);

        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(20,200,300,30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("TAHOMA",Font.PLAIN,18));
        p1.add(l5);

        JLabel l6=new JLabel(pack[5]);
        l6.setBounds(20,250,300,30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("TAHOMA",Font.PLAIN,18));
        p1.add(l6);

        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(20,300,300,30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("TAHOMA",Font.PLAIN,18));
        p1.add(l7);

        JLabel l8=new JLabel(pack[7]);
        l8.setBounds(20,350,300,30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("TAHOMA",Font.PLAIN,18));
        p1.add(l8);

        JLabel l10=new JLabel(pack[8]);
        l10.setBounds(20,430,300,30);
        l10.setForeground(Color.BLUE);
        l10.setFont(new Font("TAHOMA",Font.PLAIN,24));
        p1.add(l10);

        JLabel l11=new JLabel(pack[9]);
        l11.setBounds(250,430,200,30);
        l11.setForeground(Color.RED);
        l11.setFont(new Font("TAHOMA",Font.PLAIN,24));
        p1.add(l11);


        JLabel l12=new JLabel(pack[10]);
        l12.setBounds(550,430,200,30);
        l12.setForeground(Color.RED);
        l12.setFont(new Font("TAHOMA",Font.PLAIN,26));
        p1.add(l12);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
        Image i2=i1.getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(300,80,450,300);
        p1.add(l9);


        return p1;
    }


    public static void main(String[] args){
        new CheckPackage().setVisible(true);
    }
}
