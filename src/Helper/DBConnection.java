package Helper;
import java.sql.*;

public class DBConnection {
    Connection c = null;
    String jdbcURL = "jdbc:postgresql://localhost:5432/hospital";
    String username = "postgres";
    String password = "Dmin1udes";

    public DBConnection() {}

    public Connection connDB() {
        try {
        this.c = DriverManager.getConnection(jdbcURL,username,password);
        return c;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;

    }

}
