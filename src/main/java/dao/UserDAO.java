package dao;

import model.User;
import connection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    MyConnection myConnection = new MyConnection();
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public boolean create(User user) {
        boolean reponse = false;

        String queryInserctUser = "insert into user (name,surname,email,phone, password,acceptTerms,description,profilePhoto,address,configuration) values(?,?,?,?,?,?,?,?,?,?);";
        connection = MyConnection.getConnection();
        try {
            statement = connection.prepareStatement(queryInserctUser);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getPassword());
            statement.setBoolean(6, user.isAcceptTerms());
            statement.setString(7, user.getDescription());
            statement.setString(8, user.getProfilePhoto());
            statement.setInt(9, user.getAddress());
            statement.setInt(10, user.getConfiguration());
            statement.executeUpdate();
            reponse = true;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Usuário: " + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }
        return reponse;
    }

    public List<User> read() {
        List users = new ArrayList();
        connection = MyConnection.getConnection();
        String querySelectUser = "select * from user";

        try {
            statement = connection.prepareStatement(querySelectUser);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getInt("idUser"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setAcceptTerms(resultSet.getBoolean("acceptTerms"));
                user.setDescription(resultSet.getString("description"));
                user.setProfilePhoto(resultSet.getString ("profilePhoto"));
                user.setAddress(resultSet.getInt("address"));
                user.setConfiguration(resultSet.getInt("configuration"));
                users.add(user);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }

        return users;
    }

    // public boolean update(User object) {
    // return true;
    // }

    // public boolean delete(int id) {
    // return true;
    // }

}