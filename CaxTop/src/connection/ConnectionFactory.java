package connection;

import java.sql.*;

public class ConnectionFactory {
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbcaxtop";
    private static final String USER = "root";
    private static final String PASS = "admin";

    public static Connection getConnction(){
        try {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error db connection", e);
        }
    }

    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con,stmt);
        try {
            if(rs != null){
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
