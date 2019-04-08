import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class DataEntry {

    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ECode : ");
        int v1=sc.nextInt();
        System.out.println("Enter EName : ");
        String v2=sc.next();
        System.out.println("Enter Salary : ");
        int v3=sc.nextInt();
        String sql="insert into emp values(?,?,?)";
        Connection con=Util.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, v1);
        ps.setString(2, v2);
        ps.setInt(3, v3);
        int n=ps.executeUpdate();
        System.out.println(n+ " row added");
        con.close();
    }
}
