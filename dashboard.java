import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    String username;

    dashboard(String username){

        this.username=username;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1024,55);
        p1.setBackground(new Color(0,0,102));
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image i3=i1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i3);
        JLabel l1=new JLabel(i2);
        l1.setBounds(5,0,40,40);
        p1.add(l1);

        JLabel l3=new JLabel("Dashboard");
        l3.setBounds(70,0,150,40);
        l3.setFont(new Font("TAHOMA",Font.BOLD,25));
        l3.setForeground(Color.WHITE);
        p1.add(l3);

        JPanel p2=new JPanel();
        p2.setBounds(0,50,150,768);
        p2.setBackground(new Color(0,0,102));
        add(p2);

        b1=new JButton("    Add Personal Details                               ");
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("TAHOMA",Font.PLAIN,13));
        b1.setBackground(new Color(0,0,102));
        b1.setMargin(new Insets(0,0,0,10));
        b1.setBounds(0,0,0,30);
        b1.addActionListener(this);
        p2.add(b1);

        b2=new JButton("Update Personal Details");
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b2.setBackground(new Color(0,0,102));
        b2.setBounds(0,80,150,30);
        b2.addActionListener(this);
        p2.add(b2);

        b3=new JButton("   View Details    ");
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b3.setBackground(new Color(0,0,102));
        b3.setMargin(new Insets(0,0,0,58));
        b3.setBounds(0,110,150,30);
        b3.addActionListener(this);
        p2.add(b3);


        b5=new JButton("Delete Personal Details");
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b5.setBackground(new Color(0,0,102));
        b5.setBounds(0,140,150,30);
        b5.addActionListener(this);
        p2.add(b5);

        b6=new JButton("       Check Package      ");
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b6.setBackground(new Color(0,0,102));
        b6.setMargin(new Insets(0,0,0,50));
        b6.setBounds(0,170,150,30);
        b6.addActionListener(this);
        p2.add(b6);

        b7=new JButton("       Book Package       ");
        b7.setForeground(Color.WHITE);
        b7.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b7.setBackground(new Color(0,0,102));
        b7.setMargin(new Insets(0,0,0,50));
        b7.setBounds(0,200,150,30);
        b7.addActionListener(this);
        p2.add(b7);

        b8=new JButton("        View Package       ");
        b8.setForeground(Color.WHITE);
        b8.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b8.setBackground(new Color(0,0,102));
        b8.setMargin(new Insets(0,0,0,55));
        b8.setBounds(0,230,150,30);
        b8.addActionListener(this);
        p2.add(b8);

        b9=new JButton("       View Hotels       ");
        b9.setForeground(Color.WHITE);
        b9.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b9.setBackground(new Color(0,0,102));
        b9.setMargin(new Insets(0,0,0,60));
        b9.setBounds(0,260,150,30);
        b9.addActionListener(this);
        p2.add(b9);

        b10=new JButton("       Book Hotels       ");
        b10.setForeground(Color.WHITE);
        b10.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b10.setBackground(new Color(0,0,102));
        b10.setMargin(new Insets(0,0,0,60));
        b10.setBounds(0,290,150,30);
        b10.addActionListener(this);
        p2.add(b10);

        b11=new JButton("   View Booked Hotels   ");
        b11.setForeground(Color.WHITE);
        b11.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b1.setMargin(new Insets(0,100,0,0));
        b11.setBackground(new Color(0,0,102));
        b11.setMargin(new Insets(0,0,0,16));
        b11.setBounds(0,320,150,30);
        b11.addActionListener(this);
        p2.add(b11);

        b12=new JButton("       Destinations       ");
        b12.setForeground(Color.WHITE);
        b12.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b12.setBackground(new Color(0,0,102));
        b12.setMargin(new Insets(0,0,0,58));
        b12.setBounds(0,350,150,30);
        b12.addActionListener(this);
        p2.add(b12);


        b13=new JButton("         Payment         ");
        b13.setForeground(Color.WHITE);
        b13.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b13.setBackground(new Color(0,0,102));
        b13.setMargin(new Insets(0,0,0,75));
        b13.setBounds(0,380,150,30);
        b13.addActionListener(this);
        p2.add(b13);

        b14=new JButton("         Calculator         ");
        b14.setForeground(Color.WHITE);
        b14.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b14.setBackground(new Color(0,0,102));
        b14.setMargin(new Insets(0,0,0,70));
        b14.setBounds(0,410,150,30);
        b14.addActionListener(this);
        p2.add(b14);

        b15=new JButton("          Notepad         ");
        b15.setForeground(Color.WHITE);
        b15.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b15.setBackground(new Color(0,0,102));
        b15.setMargin(new Insets(0,0,0,75));
        b15.setBounds(0,440,150,100);
        b15.addActionListener(this);
        p2.add(b15);

        b16=new JButton("                  About                   ");
        b16.setForeground(Color.WHITE);
        b16.setFont(new Font("TAHOMA",Font.PLAIN,12));
        b16.setBackground(new Color(0,0,102));
        b16.setMargin(new Insets(0,10,0,95));
        b16.setBounds(0,470,1500,30);
        b16.addActionListener(this);
        p2.add(b16);

        JLabel l4=new JLabel("Travel And Tourism Management System");
        l4.setBounds(250,0,800,200);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("TAHOMA",Font.PLAIN,40));
        add(l4);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1024,768,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l2=new JLabel(i6);
        l2.setBounds(0,0,1024,768);
        add(l2);

    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b14){
           try {
               Runtime.getRuntime().exec("calc.exe");

           }catch (Exception e){}
       }
       else if(ae.getSource()==b15){
           try{
               Runtime.getRuntime().exec("notepad.exe");
           }catch (Exception e){}
       }
       else if(ae.getSource()==b1){
           new addcustomer(username).setVisible(true);
       }
       else if(ae.getSource()==b2){
           new Updatecustomer(username).setVisible(true);
       }else if(ae.getSource()==b3){
           new viewCustomer(username).setVisible(true);
       }else if (ae.getSource()==b6){
           new CheckPackage().setVisible(true);
       }
       else if(ae.getSource()==b7){
           new BookPackage(username).setVisible(true);
       }else if(ae.getSource()==b9){
           new CheckHotel().setVisible(true);
       }else if(ae.getSource()==b12){
           new Destinations().setVisible(true);
       }else if(ae.getSource()==b10){
           new BookHotel(username).setVisible(true);
       }else if(ae.getSource()==b11){
           new ViewBookedHotel(username).setVisible(true);
       }else if(ae.getSource()==b16){
           new About().setVisible(true);
       }else if(ae.getSource()==b5){
           new DeleteCustomer(username).setVisible(true);
       }else if(ae.getSource()==b8){
           new viewPackage(username).setVisible(true);
       }
    }

    public static void main(String args[]){

        new dashboard("").setVisible(true);
    }
}
