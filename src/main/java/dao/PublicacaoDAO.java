package dao;
import model.Publication;
import connection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Date;


public class PublicacaoDAO {
    MyConnection myConnection = new MyConnection();
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;


    public boolean create(Publication publication) {
        boolean reponse = false;

        String queryInserctPublication = "insert into publication (title,category,path,author, date) values(?,?,?,?,?);";
        connection = MyConnection.getConnection();
        try {
            statement = connection.prepareStatement(queryInserctPublication);
            statement.setString(1, publication.getTitle());
            statement.setString(2, publication.getCategory());
            statement.setString(3, publication.getPath());
            statement.setInt(4, publication.getAuthor());
            Date d = new Date(publication.getDate().getTime());
            statement.setDate(5, d);
            statement.executeUpdate();
            reponse = true;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Usuário: " + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }
        return reponse;
    }


    // public List<Publication> read() {
    //     List users = new ArrayList();
    //     connection = MyConnection.getConnection();
    //     String querySelectUser = "select * from user";

    //     try {
    //         statement = connection.prepareStatement(querySelectUser);
    //         resultSet = statement.executeQuery();
    //         while (resultSet.next()) {
    //             User user = new User();
    //             user.setIdUser(resultSet.getInt("idUser"));
    //             users.add(user);
    //         }

    //     } catch (SQLException e) {
    //         System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
    //     } finally {
    //         MyConnection.closeConnection(connection, statement, resultSet);
    //     }

    //     return users;
    // }

    // public boolean update(Publication user) {
    //     boolean reponse = false;
    //     connection = MyConnection.getConnection();
    //     String queryUpdateUser = "update user set name=?,surname=?,email=?,phone=?,password=?,acceptTerms=?,description=?,profilePhoto=?,address=?,configuration=? where idUser=?;";

    //     try {
    //         statement = connection.prepareStatement(queryUpdateUser);
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

}