import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Updatecustomer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JButton b1,b2;

    Updatecustomer(String username) {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,50,700,600);

        JLabel l11=new JLabel("UPDATE CUSTOMER DETAILS");
        l11.setFont(new Font("Tahoma",Font.BOLD,18));
        l11.setBounds(50,0,300,25);
        add(l11);

        JLabel l1=new JLabel("Username  :");
        l1.setBounds(20,40,100,40);
        l1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l1);

        t1=new JTextField();
        t1.setBounds(200,50,150,25);
        add(t1);


        JLabel l2=new JLabel("ID  :");
        l2.setBounds(20,80,100,40);
        l2.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l2);

        t9=new JTextField();
        t9.setBounds(200,90,150,25);
        add(t9);

        JLabel l3=new JLabel("Number :");
        l3.setBounds(20,130,100,40);
        l3.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l3);

        t2=new JTextField();
        t2.setBounds(200,140,150,25);
        add(t2);

        JLabel l4=new JLabel("Name :");
        l4.setBounds(20,180,100,40);
        l4.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l4);

        t3=new JTextField();
        t3.setBounds(200,190,150,25);
        add(t3);

        JLabel l5=new JLabel("Gender :");
        l5.setBounds(20,230,100,40);
        l5.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l5);

        t8=new JTextField();
        t8.setBackground(Color.WHITE);
        t8.setFont(new Font("TAHOMA",Font.PLAIN,16));
        t8.setBounds(200,240,150,25);
        add(t8);



        JLabel l6=new JLabel("Country  :");
        l6.setBounds(20,280,100,40);
        l6.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l6);

        t4=new JTextField();
        t4.setBounds(200,285,150,25);
        add(t4);

        JLabel l7=new JLabel("Address  :");
        l7.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l7.setBounds(20,330,100,40);
        add(l7);

        t5=new JTextField();
        t5.setBounds(200,335,150,25);
        add(t5);


        JLabel l8=new JLabel("Phone  :");
        l8.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l8.setBounds(20,380,100,40);
        add(l8);

        t6=new JTextField();
        t6.setBounds(200,390,150,25);
        add(t6);

        JLabel l9=new JLabel("Email  :");
        l9.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l9.setBounds(20,430,100,40);
        add(l9);

        t7=new JTextField();
        t7.setBounds(200,440,150,25);
        add(t7);


        b1=new JButton("UPDATE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setLayout(null);
        b1.setFont(new Font("TAHOMA", Font.PLAIN,16));
        b1.setBounds(70,500,100,40);
        b1.addActionListener(this);
        add(b1);


        b2=new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setLayout(null);
        b2.setFont(new Font("TAHOMA", Font.PLAIN,16));
        b2.setBounds(220,500,100,40);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2=i1.getImage().getScaledInstance(350,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l10=new JLabel(i3);
        l10.setBounds(350,80,350,400);
        add(l10);

        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
            while(rs.next()){
                t1.setText(rs.getString("username"));
                t9.setText(rs.getString("id"));
                t2.setText(rs.getString("number"));
                t3.setText(rs.getString("name"));
                t8.setText(rs.getString("gender"));
                t4.setText(rs.getString("country"));
                t5.setText(rs.getString("address"));
                t6.setText(rs.getString("phone"));
                t7.setText(rs.getString("email"));
            }
        }catch (Exception e){
        }



    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1)
        {
            String username = t1.getText();
            String id = t9.getText();
            String number = t2.getText();
            String name = t3.getText();
            String radio = t8.getText();
            String country = t4.getText();
            String address = t5.getText();
            String phone = t6.getText();
            String email = t7.getText();
            String query = "update customer set username='"+username+"',id='"+id+"', number='" + number + "',name='" +name + "',gender='" + radio + "',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
            try{
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
                this.setVisible(false);

            }catch (Exception e){}
        }

        else if(ae.getSource()==b2){
            this.setVisible(false);
        }


    }

    public static void main(String args[]){

        new Updatecustomer("").setVisible(true);
    }
}


