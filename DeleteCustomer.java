import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteCustomer extends JFrame implements ActionListener {
    JLabel l12,l13,l14,l15,l16,l17,l18,l19,l20;
    JButton b1,b2;

    String username;

    DeleteCustomer(String username) {

        this.username=username;

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,50,700,600);

        JLabel l11=new JLabel("DELETE CUSTOMER DETAILS");
        l11.setFont(new Font("Tahoma",Font.BOLD,18));
        l11.setBounds(50,0,300,25);
        add(l11);

        JLabel l1=new JLabel("Username  :");
        l1.setBounds(20,40,100,40);
        l1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l1);

        l12=new JLabel();
        l12.setFont(new Font("Tahoma",Font.PLAIN,14));
        l12.setBounds(200,50,150,25);
        add(l12);


        JLabel l2=new JLabel("ID  :");
        l2.setBounds(20,80,100,40);
        l2.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l2);

        l13=new JLabel();
        l13.setFont(new Font("Tahoma",Font.PLAIN,14));
        l13.setBounds(200,90,150,25);
        add(l13);

        JLabel l3=new JLabel("Name :");
        l3.setBounds(20,130,100,40);
        l3.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l3);

        l14=new JLabel();
        l14.setFont(new Font("Tahoma",Font.PLAIN,14));
        l14.setBounds(200,140,150,25);
        add(l14);

        JLabel l4=new JLabel("Number :");
        l4.setBounds(20,180,100,40);
        l4.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l4);

        l15=new JLabel();
        l15.setFont(new Font("Tahoma",Font.PLAIN,14));
        l15.setBounds(200,190,150,25);
        add(l15);

        JLabel l5=new JLabel("Gender :");
        l5.setBounds(20,230,100,40);
        l5.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l5);

        l16=new JLabel();
       // l16.setBackground(Color.WHITE);
        l16.setFont(new Font("TAHOMA",Font.PLAIN,14));
        l16.setBounds(200,240,150,25);
        add(l16);



        JLabel l6=new JLabel("Country  :");
        l6.setBounds(20,280,100,40);
        l6.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l6);

        l17=new JLabel();
        l17.setFont(new Font("Tahoma",Font.PLAIN,14));
        l17.setBounds(200,285,150,25);
        add(l17);

        JLabel l7=new JLabel("Address  :");
        l7.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l7.setBounds(20,330,100,40);
        add(l7);

        l18=new JLabel();
        l18.setFont(new Font("Tahoma",Font.PLAIN,14));
        l18.setBounds(200,335,150,25);
        add(l18);


        JLabel l8=new JLabel("Phone  :");
        l8.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l8.setBounds(20,380,100,40);
        add(l8);

        l19=new JLabel();
        l19.setFont(new Font("Tahoma",Font.PLAIN,14));
        l19.setBounds(200,390,150,25);
        add(l19);

        JLabel l9=new JLabel("Email  :");
        l9.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l9.setBounds(20,430,100,40);
        add(l9);

        l20=new JLabel();
        l20.setFont(new Font("Tahoma",Font.PLAIN,14));
        l20.setBounds(200,440,150,25);
        add(l20);


        b1=new JButton("DELETE");
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

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(350,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l10=new JLabel(i3);
        l10.setBounds(350,80,350,400);
        add(l10);

        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
            while(rs.next()){
                l12.setText(rs.getString("username"));
                l13.setText(rs.getString("id"));
                l15.setText(rs.getString("number"));
                l14.setText(rs.getString("name"));
                l16.setText(rs.getString("gender"));
                l17.setText(rs.getString("country"));
                l18.setText(rs.getString("address"));
                l19.setText(rs.getString("phone"));
                l20.setText(rs.getString("email"));
            }
        }catch (Exception e){
        }



    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1)
        {

            try{
                conn c = new conn();
                c.s.executeUpdate("delete from account where username='"+username+"'");
                c.s.executeUpdate("delete from bookhotel where username='"+username+"'");
                c.s.executeUpdate("delete from bookpackage where username='"+username+"'");
                c.s.executeUpdate("delete from customer where username='"+username+"'");

                JOptionPane.showMessageDialog(null,"Customer Details Deleted Successfully");
                System.exit(0);

            }catch (Exception e){}
        }

        else if(ae.getSource()==b2){
            this.setVisible(false);
        }


    }

    public static void main(String args[]){

        new DeleteCustomer("").setVisible(true);
    }
}


