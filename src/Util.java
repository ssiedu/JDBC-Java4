import java.sql.*;

public class Util {
    public static Connection connect(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data4", "root", "root");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }
}
