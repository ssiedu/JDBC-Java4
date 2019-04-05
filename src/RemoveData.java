import java.sql.*;

public class RemoveData {
    public static void main(String[] args) throws Exception {

        String sql="delete from emp where sal>=30000";
        
        Connection con=Util.connect();
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate(sql);
        System.out.println(n+" rows removed");
        con.close();
        
    }
}
