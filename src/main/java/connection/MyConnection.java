package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.Env;

public class MyConnection {
    public static Connection getConnection() {
        try {
            Class.forName(Env.db_DRIVER);
            return DriverManager.getConnection(Env.db_URL, Env.db_USER, Env.db_PASSWORD);
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
