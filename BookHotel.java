import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookHotel extends JFrame implements ActionListener {

    JLabel l1,l2,l3, l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
    Choice c1,c2,c3;
    JButton b1,b2,b3;
    JTextField t1,t2;

    BookHotel(String username) {


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(150,100,800,600);

        l2=new JLabel("BOOK Hotel");
        l2.setFont(new Font("TAHOMA",Font.BOLD,24));
        l2.setBounds(80,5,200,40);
        add(l2);

        l3=new JLabel("Username:");
        l3.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l3.setBounds(20,60,100,40);
        add(l3);

        l10=new JLabel();
        l10.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l10.setBounds(180,60,100,40);
        add(l10);

        l4=new JLabel("Select Hotel:");
        l4.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l4.setBounds(20,100,160,40);
        add(l4);

        c1=new Choice();
        try{
            conn c = new conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next()){
                c1.add(rs.getString("name"));
            }
        }catch (Exception e){}
        c1.setBounds(180,110,200,25);
        add(c1);

        l5=new JLabel("Total Persons:");
        l5.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l5.setBounds(20,140,200,40);
        add(l5);

        t1=new JTextField("1");
        t1.setBounds(180,150,200,25);
        add(t1);

        l15=new JLabel("No. Of Days:");
        l15.setFont(new Font("Tahoma",Font.PLAIN,18));
        l15.setBounds(20,180,200,40);
        add(l15);

        t2=new JTextField("");
        t2.setBounds(180,190,200,25);
        add(t2);

        l16=new JLabel("AC / Non.AC:");
        l16.setFont(new Font("Tahoma",Font.PLAIN,18));
        l16.setBounds(20,220,150,40);
        add(l16);

        c2=new Choice();
        c2.add("Yes");
        c2.add("No");
        c2.setBounds(180,230,200,25);
        add(c2);

        l17=new JLabel("Food Included:");
        l17.setFont(new Font("Tahoma",Font.PLAIN,18));
        l17.setBounds(20,260,150,40);
        add(l17);

        c3=new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(180,270,200,25);
        add(c3);

        l6=new JLabel("Id:");
        l6.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l6.setBounds(20,300,200,40);
        add(l6);

        l11=new JLabel();
        l11.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l11.setBounds(180,310,200,25);
        add(l11);

        l7=new JLabel("Number:");
        l7.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l7.setBounds(20,340,200,40);
        add(l7);

        l12=new JLabel();
        l12.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l12.setBounds(180,350,200,25);
        add(l12);

        l8=new JLabel("Phone:");
        l8.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l8.setBounds(20,380,200,40);
        add(l8);

        l13=new JLabel();
        l13.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l13.setBounds(180,390,200,25);
        add(l13);

        l9=new JLabel("Total Price:");
        l9.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l9.setBounds(20,420,200,40);
        add(l9);

        l14=new JLabel();
        l14.setFont(new Font("TAHOMA",Font.PLAIN,18));
        l14.setForeground(Color.red);
        l14.setBounds(180,430,250,25);
        add(l14);



        b1=new JButton("Check Price");
        b1.setLayout(null);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        b1.setBounds(40,480,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Book Hotel");
        b2.setLayout(null);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("TAHOMA",Font.PLAIN,16));
        b2.setBounds(200,480,140,30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setLayout(null);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("TAHOMA",Font.PLAIN,16));
        b3.setBounds(380,480,120,30);
        b3.addActionListener(this);
        add(b3);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
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

            try {
                conn c=new conn();
                ResultSet rs=c.s.executeQuery("select * from hotel where name ='"+c1.getSelectedItem()+"'");

                while(rs.next()){
                    int cost=Integer.parseInt(rs.getString("cost_per_day"));
                    int food=Integer.parseInt(rs.getString("food_charges"));
                    int ac=Integer.parseInt(rs.getString("ac_charges"));

                    int persons=Integer.parseInt(t1.getText());
                    int days=Integer.parseInt(t2.getText());

                    String acprice=c2.getSelectedItem();
                    String foodprice=c3.getSelectedItem();

                    if(persons * days >0)
                    {
                        int total=0;
                        total+=acprice.equals("Yes") ? ac:0;
                        total+=foodprice.equals("Yes") ? food:0;
                        total+=cost;

                        total=total*days*persons;

                        l14.setText(""+total);
                    }else {
                        l14.setText("Please Enter a Valid Number");
                    }

                }



            }catch (Exception e){
            }
        }
        else  if(ae.getSource()==b2){

            try{
                String query = "insert into bookHotel values('" + l10.getText() + "','" +c1.getSelectedItem()+"','" + t1.getText() + "','"+t2.getText()+"','" +c2.getSelectedItem()+"','"+c3.getSelectedItem()+"','" +l11.getText() + "','" + l12.getText() + "','"+l13.getText()+"','"+l14.getText()+"')";
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                this.setVisible(false);

            }catch (Exception e){}
        }else if(ae.getSource()==b3){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){

        new BookHotel("").setVisible(true);
    }
}
