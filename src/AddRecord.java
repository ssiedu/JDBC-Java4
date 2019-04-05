
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class AddRecord {
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded Successfully");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/data4", "root", "root");
        System.out.println("Connected Successfully");
        
        String sql="insert into emp values(113,'ccc',30000)";
        
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate(sql);//sending sql to DB
        
        con.close();
        
        System.out.println(n+ " RECORD ADDED");
        
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
