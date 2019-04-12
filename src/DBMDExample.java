
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DBMDExample {
    public static void main(String args[]) throws Exception {
        Connection con=Util.connect();
        DatabaseMetaData dbmd=con.getMetaData();
        
        String s1=dbmd.getDatabaseProductName();
        String s2=dbmd.getDatabaseProductVersion();
        String s3=dbmd.getDriverName();
        String s4=dbmd.getDriverVersion();
        ResultSet rs=dbmd.getTables(null, null, null, null);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        
        System.out.println("TABLES AVAILABLE : ");
        while(rs.next()){
            String name=rs.getString("TABLE_NAME");
            System.out.println(name);
        }
        
        con.close();
        
    }
}
