import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewCustomer extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
    JButton b2;

    viewCustomer(String username) {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,50,700,590);

        JLabel l10=new JLabel("UPDATE CUSTOMER DETAILS");
        l10.setFont(new Font("Tahoma",Font.BOLD,18));
        l10.setBounds(50,0,300,25);
        add(l10);

        JLabel l1=new JLabel("Username  :");
        l1.setBounds(20,40,100,40);
        l1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l1);

        l11=new JLabel();
        l11.setFont(new Font("Tahoma",Font.PLAIN,15));
        l11.setBounds(125,45,100,30);
        add(l11);


        JLabel l2=new JLabel("ID  :");
        l2.setBounds(350,40,100,40);
        l2.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l2);

        l12=new JLabel();
        l12.setFont(new Font("Tahoma",Font.PLAIN,15));
        l12.setBounds(455,45,100,30);
        add(l12);

        JLabel l3=new JLabel("Number :");
        l3.setBounds(20,100,100,40);
        l3.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l3);

        l13=new JLabel();
        l13.setFont(new Font("Tahoma",Font.PLAIN,15));
        l13.setBounds(125,105,100,30);
        add(l13);

        JLabel l4=new JLabel("Name :");
        l4.setBounds(350,100,100,40);
        l4.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l4);

        l14=new JLabel();
        l14.setFont(new Font("Tahoma",Font.PLAIN,15));
        l14.setBounds(455,105,100,30);
        add(l14);

        JLabel l5=new JLabel("Gender :");
        l5.setBounds(20,160,100,40);
        l5.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l5);

        l15=new JLabel();
        l15.setFont(new Font("Tahoma",Font.PLAIN,15));
        l15.setBounds(125,165,100,30);
        add(l15);



        JLabel l6=new JLabel("Country  :");
        l6.setBounds(350,160,100,40);
        l6.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(l6);

        l16=new JLabel();
        l16.setFont(new Font("Tahoma",Font.PLAIN,15));
        l16.setBounds(455,165,100,30);
        add(l16);

        JLabel l7=new JLabel("Address  :");
        l7.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l7.setBounds(20,220,100,40);
        add(l7);

        l17=new JLabel();
        l17.setFont(new Font("Tahoma",Font.PLAIN,15));
        l17.setBounds(125,225,100,30);
        add(l17);


        JLabel l8=new JLabel("Phone  :");
        l8.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l8.setBounds(350,220,100,40);
        add(l8);

        l18=new JLabel();
        l18.setFont(new Font("Tahoma",Font.PLAIN,15));
        l18.setBounds(455,225,100,30);
        add(l18);

        JLabel l9=new JLabel("Email  :");
        l9.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l9.setBounds(20,280,100,40);
        add(l9);

        l19=new JLabel();
        l19.setFont(new Font("Tahoma",Font.PLAIN,15));
        l19.setBounds(125,285,100,30);
        add(l19);


        b2=new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setLayout(null);
        b2.setFont(new Font("TAHOMA", Font.PLAIN,16));
        b2.setBounds(300,300,100,40);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l20=new JLabel(i3);
        l20.setBounds(20,320,400,250);
        add(l20);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5=i4.getImage().getScaledInstance(460,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l21=new JLabel(i6);
        l21.setBounds(400,320,460,250);
        add(l21);


        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
            while(rs.next()){
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("id"));
                l13.setText(rs.getString("number"));
                l14.setText(rs.getString("name"));
                l15.setText(rs.getString("gender"));
                l16.setText(rs.getString("country"));
                l17.setText(rs.getString("address"));
                l18.setText(rs.getString("phone"));
                l19.setText(rs.getString("email"));
            }
        }catch (Exception e){
        }

    }

    public void actionPerformed(ActionEvent ae){


        if(ae.getSource()==b2){
            this.setVisible(false);
        }


    }

    public static void main(String args[]){

        new viewCustomer("").setVisible(true);
    }
}


