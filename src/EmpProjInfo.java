
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmpProjInfo {
    public static void main(String[] args) throws Exception {
        Connection con=Util.connect();
        //wish to display ename,ptitle
        String sql="select ename,ptitle from emp,projects where emp.pcode=projects.pcode";
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1)+"\t"+rs.getString(2));
        }
        con.close();
    }
}
