import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener  {

        JButton b1,b2,b3;
        JTextField t1,t2,t3,t4;
        Choice c1;

    signup() {
        setBounds(200, 250, 800, 380);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JPanel p2=new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setBounds(250,0,280,400);
        p2.setLayout(null);
        add(p2);

        JLabel l1=new JLabel("Username");
        l1.setBounds(50,20,100,25);
        l1.setFont(new Font("SAN-SERIF",Font.BOLD,14));
        p1.add(l1);

        t1=new JTextField();
        t1.setBounds(190,20,180,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);


        JLabel l2=new JLabel("Name");
        l2.setBounds(50,60,125,25);
        l2.setFont(new Font("SAN-SERIF",Font.BOLD,14));
        p1.add(l2);

        t2=new JTextField();
        t2.setBounds(190,60,180,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);

        JLabel l3=new JLabel("Password");
        l3.setBounds(50,100,125,25);
        l3.setFont(new Font("SAN-SERIF",Font.BOLD,14));
        p1.add(l3);

        t3=new JTextField();
        t3.setBounds(190,100,180,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);

        JLabel l5=new JLabel("Security Question");
        l5.setBounds(50,140,125,25);
        l5.setFont(new Font("SAN-SERIF",Font.BOLD,14));
        p1.add(l5);

        c1=new Choice();
        c1.add("Your fav sports?");
        c1.add("Captain america or ");
        c1.add("What is your Nickname?");
        c1.add("What is your Date ?");
        c1.setBounds(190,140,180,25);
        p1.add(c1);



        JLabel l6=new JLabel("Answer");
        l6.setBounds(50,180,125,25);
        l6.setFont(new Font("SAN-SERIF",Font.BOLD,14));
        p1.add(l6);

        t4=new JTextField();
        t4.setBounds(190,180,180,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l4=new JLabel(i3);
        l4.setBounds(520,50,250,250);
        p2.add(l4);

        b1=new JButton("Create");
        b1.setBounds(40,260,150,30);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setFont(new Font("TAHOMA",Font.BOLD,16));
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(133,193,233));
        b1.addActionListener(this);
        p1.add(b1);


        b2=new JButton("Back");
        b2.setBounds(220,260,150,30);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setFont(new Font("TAHOMA",Font.BOLD,16));
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(133,193,233));
        b2.addActionListener(this);
        p1.add(b2);







        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();
            String answer = t4.getText();



            try {

                String query = "insert into account values('" + username + "','" + name + "','" + password + "','" + security + "','" + answer + "')";
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account created Successfully");

                this.setVisible(false);
                new login().setVisible(true);


            } catch (Exception e) {

            }
        }
        else if (ae.getSource() == b2)
        {
                new login().setVisible(true);
                this.setVisible(false);
        }
        else if(ae.getSource() == b3){

        }

    }

    public static void main(String[] args) {
        new signup().setVisible(true);

    }


}
