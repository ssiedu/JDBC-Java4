
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class ResultSetUpdations {
    public static void main(String[] args) throws Exception {
        Connection con=Util.connect();
        //Statement stmt=con.createStatement();
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
        System.out.println("Enter New Salary : ");
        int newsal=sc.nextInt();
        System.out.println("Changing Data ");
        rs.absolute(n);
        rs.updateInt(3, newsal);
        rs.updateRow();
        System.out.println("New Result Set");
        rs.beforeFirst();
        while(rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
        }
        
        con.close();
    }
}
