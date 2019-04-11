import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProjectSalariesGB {
    public static void main(String args[]) throws Exception {
        String sql="select pcode,sum(sal) from emp group by pcode";
        Connection con=Util.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1)+"\t"+rs.getString(2));
        }
        con.close();    
    }
}
