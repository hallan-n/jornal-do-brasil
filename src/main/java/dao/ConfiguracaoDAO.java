package dao;
import model.Configuration;
import connection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes

>>>>>>> parent of 3fc1053 (Finish CRUD in COnfiguration.java)

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
<<<<<<< Updated upstream

    // public List<User> read() {
    //     List users = new ArrayList();
    //     connection = MyConnection.getConnection();
    //     String querySelectUser = "select * from user";

    //     try {
    //         statement = connection.prepareStatement(querySelectUser);
    //         resultSet = statement.executeQuery();
    //         while (resultSet.next()) {
    //             User user = new User();
    //             user.setIdUser(resultSet.getInt("idUser"));
    //             user.setName(resultSet.getString("name"));
    //             user.setSurname(resultSet.getString("surname"));
    //             user.setEmail(resultSet.getString("email"));
    //             user.setPhone(resultSet.getString("phone"));
    //             user.setPassword(resultSet.getString("password"));
    //             user.setAcceptTerms(resultSet.getBoolean("acceptTerms"));
    //             user.setDescription(resultSet.getString("description"));
    //             user.setProfilePhoto(resultSet.getString("profilePhoto"));
    //             user.setAddress(resultSet.getInt("address"));
    //             user.setConfiguration(resultSet.getInt("configuration"));
    //             users.add(user);
    //         }

    //     } catch (SQLException e) {
    //         System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement, resultSet);
    //     }

    //     return users;
    // }

    // public boolean update(User user) {
    //     boolean reponse = false;
    //     connection = MyConnection.getConnection();
    //     String queryUpdateUser = "update user set name=?,surname=?,email=?,phone=?,password=?,acceptTerms=?,description=?,profilePhoto=?,address=?,configuration=? where idUser=?;";

    //     try {
    //         statement = connection.prepareStatement(queryUpdateUser);
    //         statement.setString(1, user.getName());
    //         statement.setString(2, user.getSurname());
    //         statement.setString(3, user.getEmail());
    //         statement.setString(4, user.getPhone());
    //         statement.setString(5, user.getPassword());
    //         statement.setBoolean(6, user.isAcceptTerms());
    //         statement.setString(7, user.getDescription());
    //         statement.setString(8, user.getProfilePhoto());
    //         statement.setInt(9, user.getAddress());
    //         statement.setInt(10, user.getConfiguration());
    //         statement.setInt(11, user.getIdUser());
    //         statement.executeUpdate();
    //         reponse = true;

    //     } catch (SQLException e) {
    //         System.out.println("Opss.. Erro ao atualizar Aluno" + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement);
    //     }

    //     return reponse;
    // }

    // public boolean deleteForId(int id) {
    //     boolean response = false;
    //     connection = MyConnection.getConnection();
    //     String queryDeleteUser = "delete from user where idUser=?";

    //     try {
    //         statement = connection.prepareStatement(queryDeleteUser);
    //         statement.setInt(1, id);
    //         statement.executeUpdate();
    //         response = true;

    //     } catch (SQLException e) {
    //         System.out.println("Opss... Erro ao tentar excluir usuário" + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement);
    //     }

    //     return response;
    // }
=======
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> Stashed changes

    // public List<User> read() {
    //     List users = new ArrayList();
    //     connection = MyConnection.getConnection();
    //     String querySelectUser = "select * from user";

    //     try {
    //         statement = connection.prepareStatement(querySelectUser);
    //         resultSet = statement.executeQuery();
    //         while (resultSet.next()) {
    //             User user = new User();
    //             user.setIdUser(resultSet.getInt("idUser"));
    //             user.setName(resultSet.getString("name"));
    //             user.setSurname(resultSet.getString("surname"));
    //             user.setEmail(resultSet.getString("email"));
    //             user.setPhone(resultSet.getString("phone"));
    //             user.setPassword(resultSet.getString("password"));
    //             user.setAcceptTerms(resultSet.getBoolean("acceptTerms"));
    //             user.setDescription(resultSet.getString("description"));
    //             user.setProfilePhoto(resultSet.getString("profilePhoto"));
    //             user.setAddress(resultSet.getInt("address"));
    //             user.setConfiguration(resultSet.getInt("configuration"));
    //             users.add(user);
    //         }

    //     } catch (SQLException e) {
    //         System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement, resultSet);
    //     }

    //     return users;
    // }

    // public boolean update(User user) {
    //     boolean reponse = false;
    //     connection = MyConnection.getConnection();
    //     String queryUpdateUser = "update user set name=?,surname=?,email=?,phone=?,password=?,acceptTerms=?,description=?,profilePhoto=?,address=?,configuration=? where idUser=?;";

    //     try {
    //         statement = connection.prepareStatement(queryUpdateUser);
    //         statement.setString(1, user.getName());
    //         statement.setString(2, user.getSurname());
    //         statement.setString(3, user.getEmail());
    //         statement.setString(4, user.getPhone());
    //         statement.setString(5, user.getPassword());
    //         statement.setBoolean(6, user.isAcceptTerms());
    //         statement.setString(7, user.getDescription());
    //         statement.setString(8, user.getProfilePhoto());
    //         statement.setInt(9, user.getAddress());
    //         statement.setInt(10, user.getConfiguration());
    //         statement.setInt(11, user.getIdUser());
    //         statement.executeUpdate();
    //         reponse = true;

    //     } catch (SQLException e) {
    //         System.out.println("Opss.. Erro ao atualizar Aluno" + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement);
    //     }

    //     return reponse;
    // }

    // public boolean deleteForId(int id) {
    //     boolean response = false;
    //     connection = MyConnection.getConnection();
    //     String queryDeleteUser = "delete from user where idUser=?";

    //     try {
    //         statement = connection.prepareStatement(queryDeleteUser);
    //         statement.setInt(1, id);
    //         statement.executeUpdate();
    //         response = true;

    //     } catch (SQLException e) {
    //         System.out.println("Opss... Erro ao tentar excluir usuário" + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement);
    //     }

    //     return response;
    // }
>>>>>>> parent of 3fc1053 (Finish CRUD in COnfiguration.java)

    // public List<User> read() {
    //     List users = new ArrayList();
    //     connection = MyConnection.getConnection();
    //     String querySelectUser = "select * from user";

    //     try {
    //         statement = connection.prepareStatement(querySelectUser);
    //         resultSet = statement.executeQuery();
    //         while (resultSet.next()) {
    //             User user = new User();
    //             user.setIdUser(resultSet.getInt("idUser"));
    //             user.setName(resultSet.getString("name"));
    //             user.setSurname(resultSet.getString("surname"));
    //             user.setEmail(resultSet.getString("email"));
    //             user.setPhone(resultSet.getString("phone"));
    //             user.setPassword(resultSet.getString("password"));
    //             user.setAcceptTerms(resultSet.getBoolean("acceptTerms"));
    //             user.setDescription(resultSet.getString("description"));
    //             user.setProfilePhoto(resultSet.getString("profilePhoto"));
    //             user.setAddress(resultSet.getInt("address"));
    //             user.setConfiguration(resultSet.getInt("configuration"));
    //             users.add(user);
    //         }

    //     } catch (SQLException e) {
    //         System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement, resultSet);
    //     }

    //     return users;
    // }

    // public boolean update(User user) {
    //     boolean reponse = false;
    //     connection = MyConnection.getConnection();
    //     String queryUpdateUser = "update user set name=?,surname=?,email=?,phone=?,password=?,acceptTerms=?,description=?,profilePhoto=?,address=?,configuration=? where idUser=?;";

    //     try {
    //         statement = connection.prepareStatement(queryUpdateUser);
    //         statement.setString(1, user.getName());
    //         statement.setString(2, user.getSurname());
    //         statement.setString(3, user.getEmail());
    //         statement.setString(4, user.getPhone());
    //         statement.setString(5, user.getPassword());
    //         statement.setBoolean(6, user.isAcceptTerms());
    //         statement.setString(7, user.getDescription());
    //         statement.setString(8, user.getProfilePhoto());
    //         statement.setInt(9, user.getAddress());
    //         statement.setInt(10, user.getConfiguration());
    //         statement.setInt(11, user.getIdUser());
    //         statement.executeUpdate();
    //         reponse = true;

    //     } catch (SQLException e) {
    //         System.out.println("Opss.. Erro ao atualizar Aluno" + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement);
    //     }

    //     return reponse;
    // }

    // public boolean deleteForId(int id) {
    //     boolean response = false;
    //     connection = MyConnection.getConnection();
    //     String queryDeleteUser = "delete from user where idUser=?";

    //     try {
    //         statement = connection.prepareStatement(queryDeleteUser);
    //         statement.setInt(1, id);
    //         statement.executeUpdate();
    //         response = true;

    //     } catch (SQLException e) {
    //         System.out.println("Opss... Erro ao tentar excluir usuário" + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement);
    //     }

    //     return response;
    // }

>>>>>>> parent of 3fc1053 (Finish CRUD in COnfiguration.java)
}