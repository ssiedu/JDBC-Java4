import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class SalaryIncrement {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ECode : ");
        int v1=sc.nextInt();
        System.out.println("Enter Increment Amount : ");
        int v2=sc.nextInt();
        String sql="update emp set sal=sal+? where eno=?";
        Connection con=Util.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, v2);
        ps.setInt(2, v1);
        int n=ps.executeUpdate();
        System.out.println(n+" row modieifed");
        con.close();
    }
}
