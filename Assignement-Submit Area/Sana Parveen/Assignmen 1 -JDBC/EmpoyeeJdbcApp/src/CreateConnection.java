import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static Connection getConnection()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException msg) {
            System.out.println(msg.getMessage());
        }
        String url= "jdbc:mysql://localhost:3306/employee";
        try {
            Connection conn=DriverManager.getConnection(url,"root","Shivam@88");
            return conn;
        }catch (SQLException msg){
            System.out.println(msg.getMessage());
        }
        return null;
    }

}
