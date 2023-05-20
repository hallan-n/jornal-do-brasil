package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MyConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_jornal_do_brasil";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao tentar estabelecer conexão com o Banco de Dados!" + e);
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao tentar fechar conexão com o Banco de Dados!" + e);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Erro ao tentar fechar Statement!" + e);
            } finally {
                closeConnection(con);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet result) {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro ao tentar fechar ResultSet!" + e);
            } finally {
                closeConnection(con, stmt);
            }
        }
    }
}
