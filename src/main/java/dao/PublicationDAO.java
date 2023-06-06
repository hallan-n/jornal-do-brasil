package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.Publication;
import connection.MyConnection;

public class PublicationDAO {
    MyConnection myConnection = new MyConnection();
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public boolean create(Publication publication) {
        boolean reponse = false;

        String queryInserctPublication = "insert into publication (title,category,description,path,author, date) values(?,?,?,?,?,?);";
        connection = MyConnection.getConnection();
        try {
            statement = connection.prepareStatement(queryInserctPublication);
            statement.setString(1, publication.getTitle());
            statement.setString(2, publication.getCategory());
            statement.setString(3, publication.getDescription());
            statement.setString(4, publication.getPath());
            statement.setInt(5, publication.getAuthor());
            Date d = new Date(publication.getDate().getTime());
            statement.setDate(6, d);
            statement.executeUpdate();
            reponse = true;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar criar publicação: " + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }
        return reponse;
    }
    public List<Publication> listAll() {
        List publications = new ArrayList();
        connection = MyConnection.getConnection();
        String querySelectPublication = "SELECT * FROM db_jornal_do_brasil.publication ORDER BY idPubli DESC;";

        try {
            statement = connection.prepareStatement(querySelectPublication);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publication publication = new Publication();
                publication.setIdPubli(resultSet.getInt("idPubli"));
                publication.setTitle(resultSet.getString("title"));
                publication.setCategory(resultSet.getString("category"));
                publication.setDescription(resultSet.getString("description"));
                publication.setPath(resultSet.getString("path"));
                publication.setAuthor(resultSet.getInt("author"));
                publication.setDate(resultSet.getDate("date"));

                publications.add(publication);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }
        
        return publications;
    }
    public List<Publication> listForCategory(String category) {
        List publications = new ArrayList();
        connection = MyConnection.getConnection();
        String querySelectPublication = "SELECT * FROM db_jornal_do_brasil.publication WHERE category = '" + category + "' ORDER BY idPubli DESC;";

        try {
            statement = connection.prepareStatement(querySelectPublication);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publication publication = new Publication();
                publication.setIdPubli(resultSet.getInt("idPubli"));
                publication.setTitle(resultSet.getString("title"));
                publication.setCategory(resultSet.getString("category"));
                publication.setDescription(resultSet.getString("description"));
                publication.setPath(resultSet.getString("path"));
                publication.setAuthor(resultSet.getInt("author"));
                publication.setDate(resultSet.getDate("date"));

                publications.add(publication);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }

        return publications;
    }
    public boolean update(Publication publication) {
        boolean reponse = false;
        connection = MyConnection.getConnection();
        String queryUpdatePublication = "update publication set title=?, category=?, description=?, path=?, author=?, date=? where idPubli=?;";

        try {
            statement = connection.prepareStatement(queryUpdatePublication);

            statement.setString(1, publication.getTitle());
            statement.setString(2, publication.getCategory());
            statement.setString(3, publication.getDescription());
            statement.setString(4, publication.getPath());
            statement.setInt(5, publication.getAuthor());
            Date d = new Date(publication.getDate().getTime());
            statement.setDate(6, d);
            statement.setInt(7, publication.getIdPubli());
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
        String queryDeletePublication = "delete from publication where idPubli=?";

        try {
            statement = connection.prepareStatement(queryDeletePublication);
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