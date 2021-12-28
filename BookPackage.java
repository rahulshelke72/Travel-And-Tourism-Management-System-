import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    JLabel l1,l2,l3, l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1;

    BookPackage(String username) {


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,120,800,500);

        l2=new JLabel("BOOK PACKAGE");
        l2.setFont(new Font("TAHOMA",Font.BOLD,24));
        l2.setBounds(80,5,200,40);
        add(l2);

        l3=new JLabel("Username");
        l3.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l3.setBounds(20,60,100,40);
        add(l3);

        l10=new JLabel();
        l10.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l10.setBounds(180,60,100,40);
        add(l10);

        l4=new JLabel("Select Package");
        l4.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l4.setBounds(20,100,160,40);
        add(l4);

        c1=new Choice();
        c1.add("GOLD PACKAGE");
        c1.add("SILVER PACKAGE");
        c1.add("BRONZE PACKAGE");
        c1.setBounds(180,110,200,25);
        add(c1);

        l5=new JLabel("Total Persons");
        l5.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l5.setBounds(20,140,200,40);
        add(l5);

        t1=new JTextField("1");
        t1.setBounds(180,150,200,25);
        add(t1);

        l6=new JLabel("Id");
        l6.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l6.setBounds(20,180,200,40);
        add(l6);

        l11=new JLabel();
        l11.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l11.setBounds(180,180,100,40);
        add(l11);

        l7=new JLabel("Number");
        l7.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l7.setBounds(20,220,200,40);
        add(l7);

        l12=new JLabel();
        l12.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l12.setBounds(180,220,100,40);
        add(l12);

        l8=new JLabel("Phone");
        l8.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l8.setBounds(20,260,200,40);
        add(l8);

        l13=new JLabel();
        l13.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l13.setBounds(180,260,100,40);
        add(l13);

        l9=new JLabel("Total Price");
        l9.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l9.setBounds(20,300,200,40);
        add(l9);

        l14=new JLabel();
        l14.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l14.setForeground(Color.red);
        l14.setBounds(180,300,200,40);
        add(l14);



        b1=new JButton("Check Price");
        b1.setLayout(null);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        b1.setBounds(40,380,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Book Package");
        b2.setLayout(null);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("TAHOMA",Font.PLAIN,16));
        b2.setBounds(200,380,140,30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setLayout(null);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("TAHOMA",Font.PLAIN,16));
        b3.setBounds(380,380,120,30);
        b3.addActionListener(this);
        add(b3);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l1=new JLabel(i3);
        l1.setBounds(400,40,350,300);
        add(l1);


        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
            while(rs.next()){
                l10.setText(rs.getString("username"));
                l11.setText(rs.getString("id"));
                l12.setText(rs.getString("number"));
                l13.setText(rs.getString("phone"));
            }
        }catch (Exception e){
        }



    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){

           String p=c1.getSelectedItem();
           int cost=0;
            if(p.equals("GOLD PACKAGE")){
               cost+=50000;
            }else if(p.equals("SILVER PACKAGE")){
                cost+=35000;
            }else if(p.equals("BRONZE PACKAGE")){
                cost+=20000;
            }
            int persons=Integer.parseInt(t1.getText());
            cost*=persons;
            l14.setText("Rs "+cost);
        }
        else  if(ae.getSource()==b2){

                try{
                    String query = "insert into bookPackage values('" + l10.getText() + "','" +c1.getSelectedItem()+"','" + t1.getText() + "','" +l11.getText() + "','" + l12.getText() + "','"+l13.getText()+"','"+l14.getText()+"')";
                    conn c = new conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                    this.setVisible(false);

                }catch (Exception e){}
        }else if(ae.getSource()==b3){
       this.setVisible(false);
        }
    }
    public static void main(String[] args){

        new BookPackage("").setVisible(true);
    }
}
