
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetInsertion {
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
        
        System.out.println("Enter ECode : ");
        int v1=sc.nextInt();
        System.out.println("Enter EName : ");
        String v2=sc.next();
        System.out.println("Enter Sal   : ");
        int v3=sc.nextInt();
        
        System.out.println("Inserting A New Row .....!!");
        
        rs.moveToInsertRow();
        
        rs.updateInt(1, v1);
        rs.updateString(2, v2);
        rs.updateInt(3, v3);
        rs.insertRow();
        System.out.println("New ResultSet : ");
        rs.beforeFirst();
        while(rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
        }
        
        
        con.close();
    }    
}
