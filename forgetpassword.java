import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class forgetpassword extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1 , t2,t3,t4,t5;
    JButton b1,b2,b3;

    forgetpassword(){

        setBounds(100,150,900,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(5,10,600,340);
        add(p1);

        l1=new JLabel("Username");
        l1.setBounds(20,20,100,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l1);

        t1=new JTextField();
        t1.setBounds(230,20,200,30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);

        b1=new JButton("Search");
        b1.setBounds(450,20,130,35);
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma",Font.BOLD,16));
        b1.addActionListener(this);
        p1.add(b1);

        l2=new JLabel("Name");
        l2.setBounds(20,70,100,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l2);

        t2=new JTextField();
        t2.setBounds(230,70,200,30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);

        l3=new JLabel("Your Security Question");
        l3.setBounds(20,120,200,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l3);

        t3=new JTextField();
        t3.setBounds(230,120,300,30);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);

        l4=new JLabel("Answer");
        l4.setBounds(20,170,100,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l4);

        t4=new JTextField();
        t4.setBounds(230,170,200,30);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        b2=new JButton("Retrieve");
        b2.setBounds(450,170,130,35);
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma",Font.BOLD,16));
        b2.addActionListener(this);
        p1.add(b2);

        l5=new JLabel("Password");
        l5.setBounds(20,220,100,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l5);

        t5=new JTextField();
        t5.setBounds(230,220,200,30);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t5);

        b3=new JButton("Back");
        b3.setBounds(140,270,130,35);
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Tahoma",Font.BOLD,16));
        b3.addActionListener(this);
        p1.add(b3);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l6=new JLabel(i3);
        l6.setBounds(625,20,250,300);
        add(l6);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        conn c = new conn();

        if(ae.getSource() == b1 )
        {
          try {
              String sql = "select * from account where username= '" + t1.getText() + "'";
              ResultSet rs = c.s.executeQuery(sql);
              while (rs.next()){
                  t2.setText(rs.getString("name"));
                  t3.setText(rs.getString("security"));
              }


          }catch (Exception e){}
        }
        else if (ae.getSource() == b2 ){
            try {
                String sql = "select * from account where answer= '" + t4.getText() + "' AND username= '" + t1.getText() + "'";
                ResultSet rs = c.s.executeQuery(sql);
                while(rs.next()) {
                    t5.setText(rs.getString("password"));

                }
            }catch (Exception e){}

        }
        else if(ae.getSource() == b3 ){

            this.setVisible(false);
            new login().setVisible(true);

        }
    }

    public static void main(String args[]){
        forgetpassword fp=new forgetpassword();
    }
}
