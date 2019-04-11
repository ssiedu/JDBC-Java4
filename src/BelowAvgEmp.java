import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BelowAvgEmp {
    public static void main(String args[]) throws Exception {

        String sql="select * from emp where sal<(select avg(sal) from emp)";
        Connection con=Util.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);

        while(rs.next()){
            System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        }
        
      
        
        
        con.close();    
    }
}
