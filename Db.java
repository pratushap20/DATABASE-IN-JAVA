import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Db {
    Connection c;
    Statement s;

    public Db() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_mgmt", "root", "");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
