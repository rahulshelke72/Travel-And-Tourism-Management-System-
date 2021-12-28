import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Stack;

public class addcustomer extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JComboBox c1;
    JRadioButton r1,r2;
    JButton b1,b2;

    addcustomer(String username) {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,50,700,600);

        JLabel l1=new JLabel("Username  :");
        l1.setBounds(20,20,100,40);
        l1.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(l1);

        t1=new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);


        JLabel l2=new JLabel("ID  :");
        l2.setBounds(20,70,100,40);
        l2.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(l2);

        c1=new JComboBox(new String[] {"Passport","Adhar Card","Pan Card","Ration Card"});
        c1.setBounds(200,75,150,30);
        add(c1);

        JLabel l3=new JLabel("Number :");
        l3.setBounds(20,120,100,40);
        l3.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(l3);

        t2=new JTextField();
        t2.setBounds(200,125,150,30);
        add(t2);

        JLabel l4=new JLabel("Name :");
        l4.setBounds(20,170,100,40);
        l4.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(l4);

        t3=new JTextField();
        t3.setBounds(200,175,150,30);
        add(t3);

        JLabel l5=new JLabel("Gender :");
        l5.setBounds(20,220,100,40);
        l5.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(l5);

        r1=new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        r1.setBounds(200,220,80,45);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("TAHOMA",Font.PLAIN,16));
        r2.setBounds(280,220,80,45);
        add(r2);

        JLabel l6=new JLabel("Country  :");
        l6.setBounds(20,270,100,40);
        l6.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(l6);

        t4=new JTextField();
        t4.setBounds(200,275,150,30);
        add(t4);

        JLabel l7=new JLabel("Address  :");
        l7.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l7.setBounds(20,320,100,40);
        add(l7);

        t5=new JTextField();
        t5.setBounds(200,325,150,30);
        add(t5);


        JLabel l8=new JLabel("Phone  :");
        l8.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l8.setBounds(20,370,100,40);
        add(l8);

        t6=new JTextField();
        t6.setBounds(200,375,150,30);
        add(t6);

        JLabel l9=new JLabel("Email  :");
        l9.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l9.setBounds(20,420,100,40);
        add(l9);

        t7=new JTextField();
        t7.setBounds(200,425,150,30);
        add(t7);


        b1=new JButton("Add");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setLayout(null);
        b1.setFont(new Font("TAHOMA", Font.PLAIN,16));
        b1.setBounds(70,490,100,40);
        b1.addActionListener(this);
        add(b1);


        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setLayout(null);
        b2.setFont(new Font("TAHOMA", Font.PLAIN,16));
        b2.setBounds(220,490,100,40);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l10=new JLabel(i3);
        l10.setBounds(330,20,400,600);
        add(l10);
        System.out.println(username);

        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from account where username='"+username+"'");
            while(rs.next()){
                t1.setText(rs.getString("username"));
                t3.setText(rs.getString("name"));
            }
        }catch (Exception e){}



    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
                String username = t1.getText();
                String id = (String) c1.getSelectedItem();
                String number = t2.getText();
                String name = t3.getText();
                String radio = null;
                if(r1.isSelected()){
                    radio="Male";
                }
                else if (r2.isSelected()){
                    radio="Female";
                }

                String country = t4.getText();
                String address = t5.getText();
                String phone = t6.getText();
                String email = t7.getText();
            try{
                String query = "insert into customer values('" + username + "','" + id + "','" + number + "','" +name + "','" + radio + "','"+country+"','"+address+"','"+phone+"','"+email+"')";
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");



            }catch (Exception e){}
        }

        if(ae.getSource()==b2){
            this.setVisible(false);
        }


    }

    public static void main(String args[]){
        new addcustomer("").setVisible(true);
    }
}
