import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DispData {

    public static void main(String[] args) throws Exception {

        String sql = "select * from emp";
        Connection con = Util.connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        
        /*
        rs.last();
        int n=rs.getRow();
        System.out.println(n);
        */
        
        System.out.println(rs.isBeforeFirst());
        System.out.println(rs.isAfterLast());
        
        while(rs.next()){
        System.out.println(rs.getString("eno"));
        System.out.println(rs.getString("ename"));
        System.out.println(rs.getString("sal"));
        //System.out.println(rs.getString(4));
        System.out.println("_________________");
        }
        
        
        
        con.close();
    }
}
