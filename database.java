import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {
    public static void main(String args[]){
        String url="jdbc:mysql://localhost:3306/namdb";
        String username="root";
        String password="root";
        try{
            Connection connection= DriverManager.getConnection(url,username,password);
            String sql = "INSERT INTO customer(firstname,lastname) Values(?, ?)";
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setString(1,"oooo");
            statement.setString(2,"pppp");
            int rows = statement.executeUpdate();
            if(rows > 0)
            {
                System.out.println("A row has been inserted .");
            }
      //     statement.close();
        //    connection.close();
        }catch (SQLException e){
            System.out.println("oops,error!");
            e.printStackTrace();
        }
    }
}
