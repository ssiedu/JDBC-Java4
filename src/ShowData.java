
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowData {

    public static void main(String[] args) throws Exception {

        //fetching the employees earning more than 30k
        String sql = "select eno,ename from emp";
        Connection con = Util.connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        //iterating the ResultSet
        while (rs.next()) {
            for (int i = 1; i <= 2; i++) {
                System.out.println(rs.getString(i));
            }
            System.out.println("___________________");
        }

        /*
        while(rs.next()){
            String s1=rs.getString("eno");
            String s2=rs.getString("ename");
            int s3=rs.getInt("sal");
            int bonus=s3*10/100;
            System.out.println(s1+","+s2+","+s3+","+bonus);
        }
         */
        con.close();
    }
}
