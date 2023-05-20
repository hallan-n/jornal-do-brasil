package dao;
import model.User;
import connection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    MyConnection myConnection = new MyConnection();
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public boolean create(User user) {
        boolean reponse = false;


        String queryInserctUser = "insert into user(name,surname,email,phone,password,acceptTerms,description,profilePhoto,address,configuration) values(?,?,?,?,?,?,?,?,?,?)";
        
        // '330', 'Casa', 'Novo Horizonte', 'Serra', 'Espírito Santo','29163340'
        connection = MyConnection.getConnection();
        try {
            statement = connection.prepareStatement(queryInserctUser);
            statement.setString(1,user.getName());
            statement.setString(2,user.getSurname());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPhone());
            statement.setString(5,user.getPassword());
            statement.setBoolean(6,user.isAcceptTerms());
            statement.setString(7,user.getDescription());
            statement.setObject(8,user.getAddress());
            statement.setString(9,user.getProfilePhoto());
            statement.setObject(9,user.getConfiguration());
            statement.executeUpdate();
            System.out.println("Cadastrado");
            
            reponse = true;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Usuário: " + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }
        return reponse;
    }




    // public List<Object> read() {
    //     return new ArrayList<Object>();
    // }

    // public boolean update(User object) {
    //     return true;
    // }

    // public boolean delete(int id) {
    //     return true;
    // }

}