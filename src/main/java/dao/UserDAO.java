package dao;

import model.User;
import sistema_login.Usuario;
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
        String queryInserctUser = "insert into user (name,surname,email,phone, password,acceptTerms,description,profilePhoto,extension,pathProfilePhoto,configuration) values(?,?,?,?,?,?,?,?,?,?,?);";
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
            statement.setString(9, user.getExtension());
            statement.setString(10, user.getPathProfilePhoto());
            statement.setInt(11, user.getConfiguration());
            statement.executeUpdate();
            reponse = true;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Usuário: " + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }
        return reponse;
    }

    public List<User> listAll() {
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
                user.setProfilePhoto(resultSet.getString("profilePhoto"));
                user.setProfilePhoto(resultSet.getString("extension"));
                user.setProfilePhoto(resultSet.getString("pathProfilePhoto"));
                user.setConfiguration(resultSet.getInt("configuration"));
                users.add(user);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Usuários!..." + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }

        return users;
    }

    public User listForId(int id) {
        connection = MyConnection.getConnection();
        String querySelectUser = "select * from user where idUser = '" + id +"';";
        User user = new User();

        try {
            statement = connection.prepareStatement(querySelectUser);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setIdUser(resultSet.getInt("idUser"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setAcceptTerms(resultSet.getBoolean("acceptTerms"));
                user.setDescription(resultSet.getString("description"));
                user.setProfilePhoto(resultSet.getString("profilePhoto"));
                user.setProfilePhoto(resultSet.getString("extension"));
                user.setProfilePhoto(resultSet.getString("pathProfilePhoto"));
                user.setConfiguration(resultSet.getInt("configuration"));
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Usuários!..." + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }
        return user;
    }
    
    public User listForLogin(String email) {
        connection = MyConnection.getConnection();
        String querySelectUser = "select * from user where email = '" + email +"';";
        User user = new User();

        try {
            statement = connection.prepareStatement(querySelectUser);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setIdUser(resultSet.getInt("idUser"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setAcceptTerms(resultSet.getBoolean("acceptTerms"));
                user.setDescription(resultSet.getString("description"));
                user.setProfilePhoto(resultSet.getString("profilePhoto"));
                user.setProfilePhoto(resultSet.getString("extension"));
                user.setProfilePhoto(resultSet.getString("pathProfilePhoto"));
                user.setConfiguration(resultSet.getInt("configuration"));
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Usuários!..." + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }
        return user;
    }

    public boolean update(User user) {
        boolean reponse = false;
        connection = MyConnection.getConnection();
        String queryUpdateUser = "update user set name=?,surname=?,email=?,phone=?, password=?,acceptTerms=?,description=?,profilePhoto=?,extension=?,pathProfilePhoto=?,configuration=? where idUser=?;";

        try {
            statement = connection.prepareStatement(queryUpdateUser);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getPassword());
            statement.setBoolean(6, user.isAcceptTerms());
            statement.setString(7, user.getDescription());
            statement.setString(8, user.getProfilePhoto());
            statement.setString(9, user.getExtension());
            statement.setString(10, user.getPathProfilePhoto());
            statement.setInt(11, user.getConfiguration());
            statement.setInt(12, user.getIdUser());
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
        String queryDeleteUser = "delete from user where idUser=?";

        try {
            statement = connection.prepareStatement(queryDeleteUser);
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

 
    public User logar(User user) {
        User userLogin = new User();
        String querySelectUser = "select * from user where email=? and password=?;";
        connection = MyConnection.getConnection();
        try {
            statement = connection.prepareStatement(querySelectUser);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userLogin.setEmail(resultSet.getString("email"));
                userLogin.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("OPS... Erro ao tentar logar! " + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }
        return userLogin;
    }
}