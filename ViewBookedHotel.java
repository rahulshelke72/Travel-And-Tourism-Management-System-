import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JLabel l1,l2,l3, l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22;
    JButton b1;


    ViewBookedHotel(String username) {


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,100,800,550);

        l2=new JLabel("View Booked Hotel Details");
        l2.setFont(new Font("TAHOMA",Font.BOLD,24));
        l2.setBounds(80,0,350,40);
        add(l2);

        l3=new JLabel("Username");
        l3.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l3.setBounds(20,60,100,40);
        add(l3);

        l10=new JLabel();
        l10.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l10.setBounds(180,60,100,40);
        add(l10);

        l4=new JLabel("Hotel Name");
        l4.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l4.setBounds(20,100,160,40);
        add(l4);

        l15=new JLabel();
        l15.setFont(new Font("TAHOMA",Font.PLAIN,16));
        l15.setBounds(180,110,200,30);
        add(l15);

        l5=new JLabel("Total Persons");
        l5.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l5.setBounds(20,140,200,40);
        add(l5);

        l16=new JLabel();
        l16.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l16.setBounds(180,150,200,30);
        add(l16);

        l6=new JLabel("Total Days");
        l6.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l6.setBounds(20,180,200,40);
        add(l6);

        l11=new JLabel();
        l11.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l11.setBounds(180,180,100,40);
        add(l11);

        l7=new JLabel("AC Included?");
        l7.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l7.setBounds(20,220,200,40);
        add(l7);

        l12=new JLabel();
        l12.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l12.setBounds(180,220,100,40);
        add(l12);

        l8=new JLabel("Food Included?");
        l8.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l8.setBounds(20,260,200,40);
        add(l8);

        l13=new JLabel();
        l13.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l13.setBounds(180,260,100,40);
        add(l13);

        l9=new JLabel("ID");
        l9.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l9.setBounds(20,300,200,40);
        add(l9);

        l14=new JLabel();
        l14.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l14.setBounds(180,300,200,40);
        add(l14);


        l17=new JLabel("Number");
        l17.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l17.setBounds(20,340,200,40);
        add(l17);

        l18=new JLabel();
        l18.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l18.setBounds(180,340,200,40);
        add(l18);

        l19=new JLabel("Phone");
        l19.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l19.setBounds(20,380,200,40);
        add(l19);

        l20=new JLabel();
        l20.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l20.setBounds(180,380,200,40);
        add(l20);

        l21=new JLabel("Total Price");
        l21.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l21.setBounds(20,420,200,40);
        add(l21);

        l22=new JLabel();
        l22.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l22.setBounds(180,420,200,40);
        add(l22);




        b1=new JButton("Back");
        b1.setLayout(null);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        b1.setBounds(80,460,120,30);
        b1.addActionListener(this);
        add(b1);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(380,350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l1=new JLabel(i3);
        l1.setBounds(380,60,380,350);
        add(l1);


        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from bookhotel where username='"+username+"'");
            while(rs.next()){
                l10.setText(rs.getString("username"));
                l15.setText(rs.getString("hotel"));
                l16.setText(rs.getString("persons"));
                l11.setText(rs.getString("days"));
                l12.setText(rs.getString("ac"));
                l13.setText(rs.getString("food"));
                l14.setText(rs.getString("id"));
                l18.setText(rs.getString("number"));
                l20.setText(rs.getString("phone"));
                l22.setText(rs.getString("cost"));
            }
        }catch (Exception e){
        }



    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){

        new ViewBookedHotel("").setVisible(true);
    }
}
