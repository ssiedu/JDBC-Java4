
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetDeletion {
    public static void main(String[] args) throws Exception {
        Connection con=Util.connect();
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from emp");
        System.out.println("____________________________________");
        while(rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
        }
        System.out.println("____________________________________");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Row No. : ");
        int n=sc.nextInt();
        
        rs.absolute(n);
        rs.deleteRow();
        System.out.println("ResultSet After Deletion");
        
        rs.beforeFirst();
        while(rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
        }        
        
        
        
        con.close();
    }
}
