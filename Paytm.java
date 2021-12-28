import javax.swing.*;

public class Paytm extends JFrame {
    Paytm(){

        JEditorPane j=new JEditorPane();
        j.setEditable(false);

        try {

            j.setPage("https://paytm.com");

        }catch (Exception e){
            j.setContentType("text/html");
            j.setText("<html> could not load , Error 404 </html>");
        }

        JScrollPane js=new JScrollPane();
        getContentPane().add(js);
        setBounds(200,200,700,500);

    }
    public static void main(String[] args){
        new Paytm().setVisible(true);
    }
}
