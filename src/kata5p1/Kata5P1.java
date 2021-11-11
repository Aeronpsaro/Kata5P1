package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Kata5P1 {

    public static void main(String[] args) {
        
        Connection db = null;
        String url = "jdbc:sqlite:KATA5.db";
        try {
            db = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        /*String sql = "SELECT * FROM PEOPLE";
        
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
        }*/
        
        /*String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " Id integer PRIMARY KEY AUTOINCREMENT, \n"
                + " Mail TEXT NOT NULL);";
        try {
            Statement stmt = db.createStatement();
            stmt.execute(sql);
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
        }*/
        
        List<String> mails = MailListReader.read("email.txt");
        String sql = "INSERT INTO EMAIL(Mail) VALUES (?)";
        
        for (String mail: mails) {
            try {
                PreparedStatement pstmt = db.prepareStatement(sql);
                pstmt.setString(1, mail);
                pstmt.executeUpdate();
            }catch (SQLException ex) {
                    System.out.println("" + ex.getMessage());
            }
        }
        if (db != null) {
            try {
                db.close();
            } catch (SQLException ex) {
                System.out.println("" + ex.getMessage());
            }
        }
    }
}
