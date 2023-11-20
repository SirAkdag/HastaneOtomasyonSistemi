package Model;

import Helper.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Bashekim  extends Users{
    private static DBConnection conn = new DBConnection();
    static Connection con = conn.connDB();
    static Statement st;

    static {
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static PreparedStatement preparedStatement = null;

    public Bashekim(int id, String tc_no, String password, String name, String type) throws SQLException {
        super(tc_no, password, name, type);
    }

    public Bashekim() throws SQLException {}

    public static boolean deleteDoktor(String id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean addDoktor(String tc_no, String password, String name) {
        String query = "INSERT INTO users" +"(tc_no, password, name, \"type\") VALUES" + "(?,?,?,?)";
        boolean key = false;
        try {
            st = con.createStatement();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,tc_no);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,"doktor");
            preparedStatement.executeUpdate();
            key=true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (key)
            return true;
        else
            return false;
    }
}
