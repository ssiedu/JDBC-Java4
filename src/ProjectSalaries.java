
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProjectSalaries {
    public static void main(String args[]) throws Exception {

        int s1=0,s2=0,s3=0;
        String sql="select pcode,sal from emp";
        Connection con=Util.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            String pc=rs.getString(1);
            if(pc.equals("p111")){
                s1=s1+rs.getInt(2);
            }else if(pc.equals("p112")){
                s2=s2+rs.getInt(2);
            }else if(pc.equals("p113")){
                s3=s3+rs.getInt(2);
            }
        }
        
        System.out.println("P111 \t"+s1);
        System.out.println("P112 \t"+s2);
        System.out.println("P113 \t"+s3);
        
        
        
        con.close();    
    }
}
