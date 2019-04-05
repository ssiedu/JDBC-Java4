import java.sql.*;


public class TableCreation {
    public static void main(String[] args) throws Exception {

        Connection con=Util.connect();
        String sql="create table dummy (col1 char, col2 char)";
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate(sql);
        System.out.println(n);
        con.close();
        
    }
}
