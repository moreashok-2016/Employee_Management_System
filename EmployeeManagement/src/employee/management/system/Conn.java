package employee.management.system;
import java.sql.*;


public class Conn
{
    Conn()
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/emp", "postgres", "ashoka");
        }catch(Exception e)
        {

        }
    }

}
