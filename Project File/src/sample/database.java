package sample;
import java.sql.*;


public class database {

    public void registration(String user,String pass,String e,String d,String p,String q,String key) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raju\\Desktop\\security\\out\\production\\File_lock\\sample\\File_lock.db");

            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS login (username VARCHAR, password VARCHAR, rsa_e VARCHAR, rsa_d VARCHAR, rsa_p VARCHAR, rsa_q VARCHAR, Ciper_key)");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `login` (username , password , rsa_e , rsa_d , rsa_p, rsa_q , Ciper_key ) VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1, user );
            pstmt.setString(2, pass);
            pstmt.setString(3, e);
            pstmt.setString(4, d);
            pstmt.setString(5,p );
            pstmt.setString(6,q );
            pstmt.setString(7, key);
            pstmt.executeUpdate();
            statement.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
        }
    }


    public boolean loginCheck(String user,String pass){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raju\\Desktop\\security\\out\\production\\File_lock\\sample\\File_lock.db");
            Statement statement = conn.createStatement();

            ResultSet rs    = statement.executeQuery("SELECT COUNT(username) AS count FROM login WHERE username LIKE '" +user+"' AND password LIKE '"+pass+"'");


            if (rs.getInt("count") > 0){
                statement.close();
                conn.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return false;
    }

    public String get_E_database(String user) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raju\\Desktop\\security\\out\\production\\File_lock\\sample\\File_lock.db");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT rsa_e FROM login WHERE username LIKE '" +user+"'");
        return rs.getString("rsa_e");
    }

    public String get_D_database(String user) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raju\\Desktop\\security\\out\\production\\File_lock\\sample\\File_lock.db");
        Statement statement = conn.createStatement();
        ResultSet rs    = statement.executeQuery("SELECT rsa_d FROM login WHERE username LIKE '" +user+"'");
        return rs.getString("rsa_d");
    }

    public String get_P_database(String user) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raju\\Desktop\\security\\out\\production\\File_lock\\sample\\File_lock.db");
        Statement statement = conn.createStatement();
        ResultSet rs    = statement.executeQuery("SELECT rsa_p FROM login WHERE username LIKE '" +user+"'");
        return rs.getString("rsa_p");
    }

    public String get_Q_database(String user) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raju\\Desktop\\security\\out\\production\\File_lock\\sample\\File_lock.db");
        Statement statement = conn.createStatement();
        ResultSet rs    = statement.executeQuery("SELECT rsa_q FROM login WHERE username LIKE '" +user+"'");
        return rs.getString("rsa_q");
    }
    public String get_key_database(String user) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raju\\Desktop\\security\\out\\production\\File_lock\\sample\\File_lock.db");
        Statement statement = conn.createStatement();
        ResultSet rs    = statement.executeQuery("SELECT Ciper_key FROM login WHERE username LIKE '" +user+"'");
        return rs.getString("Ciper_key");
    }
}