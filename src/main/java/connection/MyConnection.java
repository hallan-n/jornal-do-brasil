package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.Env;

public class MyConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        Env env = new Env();
        try {
            Class.forName(env.db_DRIVER);
            return DriverManager.getConnection(env.db_URL, env.db_USER, env.db_PASSWORD);
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
