package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) {
        
        Connection db = null;
        String url = "jdbc:sqlite:KATA5.db";
        try {
            db = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        String sql = "SELECT * FROM PEOPLE";
        
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t"
                        + rs.getString("Name") + "\t"
                        + rs.getString("Apellidos") + "\t"
                        + rs.getString("Departamento") + "\t");
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        } finally {
            if (db != null) {
            try {
                db.close();
            } catch (SQLException ex) {
                System.out.println("" + ex.getMessage());
            }
            }
        }
    }
    
}
