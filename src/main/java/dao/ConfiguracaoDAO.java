package dao;

import model.Configuration;
import connection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConfiguracaoDAO {
    MyConnection myConnection = new MyConnection();
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public boolean create(Configuration config) {
        boolean reponse = false;

        String queryInserctConfig = "insert into configuration(notification,sound,showProfilePhoto,showdescription,showNumber,showEmail,theme) values(?,?,?,?,?,?,?);";
        connection = MyConnection.getConnection();
        try {
            statement = connection.prepareStatement(queryInserctConfig);
            statement.setBoolean(1, config.isNotification());
            statement.setBoolean(2, config.isSound());
            statement.setBoolean(3, config.isShowProfilePhoto());
            statement.setBoolean(4, config.isShowdescription());
            statement.setBoolean(5, config.isShowNumber());
            statement.setBoolean(6, config.isShowEmail());
            statement.setString(7, config.getTheme());
            statement.executeUpdate();
        
            reponse = true;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Usuário: " + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }
        return reponse;
    }

    public List<Configuration> read() {
        List configurations = new ArrayList();
        connection = MyConnection.getConnection();
        String querySelectUser = "select * from configuration";

        try {
            statement = connection.prepareStatement(querySelectUser);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Configuration configuration = new Configuration();
                configuration.setIdConfig(resultSet.getInt("idConfig"));
                configuration.setNotification(resultSet.getBoolean("notification"));
                configuration.setSound(resultSet.getBoolean("sound"));
                configuration.setShowProfilePhoto(resultSet.getBoolean("showProfilePhoto"));
                configuration.setShowdescription(resultSet.getBoolean("showdescription"));
                configuration.setShowNumber(resultSet.getBoolean("showNumber"));
                configuration.setShowEmail(resultSet.getBoolean("showEmail"));
                configuration.setTheme(resultSet.getString("theme"));

                configurations.add(configuration);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }

        return configurations;
    }

    public boolean update(Configuration configuration) {
        boolean reponse = false;
        connection = MyConnection.getConnection();
        String queryUpdateConfiguration = "update configuration set notification=?, sound=?, showProfilePhoto=?, showdescription=?, showNumber=?, showEmail=?, theme=? where idConfig=?;";

        try {
            statement = connection.prepareStatement(queryUpdateConfiguration);
            statement.setBoolean(1,configuration.isNotification());
            statement.setBoolean(2, configuration.isSound());
            statement.setBoolean(3, configuration.isShowProfilePhoto());
            statement.setBoolean(4, configuration.isShowdescription());
            statement.setBoolean(5, configuration.isShowNumber());
            statement.setBoolean(6, configuration.isShowEmail());
            statement.setString(7, configuration.getTheme());
            statement.setInt(8, configuration.getIdConfig());



            statement.executeUpdate();
            reponse = true;

        } catch (SQLException e) {
            System.out.println("Opss.. Erro ao atualizar Aluno" + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }

        return reponse;
    }

    public boolean deleteForId(int id) {
        boolean response = false;
        connection = MyConnection.getConnection();
        String queryDeleteConfig = "delete from configuration where idConfig=?";

        try {
            statement = connection.prepareStatement(queryDeleteConfig);
            statement.setInt(1, id);
            statement.executeUpdate();
            response = true;

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao tentar excluir usuário" + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }

        return response;
    }

}