import java.sql.*;

public class RaiseSalary {
    public static void main(String[] args) throws Exception {
        Connection con=Util.connect();
        String sql="update emp set sal=sal+1000";
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate(sql);
        System.out.println(n+" rows modieifed");
        con.close();
    
    }
}
