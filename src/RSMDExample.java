
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class RSMDExample {
    public static void main(String args[]) throws Exception {
        
        Connection con=Util.connect();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Table To View : ");
        String tname=sc.next();
        String sql="select * from "+tname;
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        ResultSetMetaData rsmd=rs.getMetaData();
        int n=rsmd.getColumnCount();
        System.out.println("______________________________________");
        for(int i=1; i<=n; i++){
            System.out.print(rsmd.getColumnName(i)+"\t");
        }
        System.out.println("");
        System.out.println("______________________________________");
        while(rs.next()){
            for(int i=1; i<=n; i++){
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println("");
        }
        System.out.println("______________________________________");
        con.close();
    }
}
