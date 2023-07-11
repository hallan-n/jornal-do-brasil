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

        String queryInserctPublication = "insert into publication (title,category,description,fileName,extension,pathFileName,thumb,pathThumb,author,date) values(?,?,?,?,?,?,?,?,?,?);";

        connection = MyConnection.getConnection();
        try {
            statement = connection.prepareStatement(queryInserctPublication);
            statement.setString(1, publication.getTitle());
            statement.setString(2, publication.getCategory());
            statement.setString(3, publication.getDescription());
            statement.setString(4, publication.getFileName());
            statement.setString(5, publication.getExtension());
            statement.setString(6, publication.getPathFileName());
            statement.setString(7, publication.getThumb());
            statement.setString(8, publication.getPathThumb());
            statement.setInt(9, publication.getAuthor());
            Date d = new Date(publication.getDate().getTime());
            statement.setDate(10, d);
            statement.executeUpdate();
            reponse = true;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar criar publicação: " + e.getMessage());
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
                publication.setFileName(resultSet.getString("fileName"));
                publication.setExtension(resultSet.getString("extension"));
                publication.setPathFileName(resultSet.getString("pathFileName"));
                publication.setThumb(resultSet.getString("thumb"));
                publication.setPathThumb(resultSet.getString("pathThumb"));
                publication.setAuthor(resultSet.getInt("author"));
                publication.setDate(resultSet.getDate("date"));

                publications.add(publication);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar publicações!..." + e.getMessage());
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }

        return publications;
    }

    public List<Publication> listForCategory(String category) {
        List publications = new ArrayList();
        connection = MyConnection.getConnection();
        String querySelectPublication = "SELECT * FROM db_jornal_do_brasil.publication WHERE category = '" + category
                + "' ORDER BY idPubli DESC;";

        try {
            statement = connection.prepareStatement(querySelectPublication);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publication publication = new Publication();
                publication.setIdPubli(resultSet.getInt("idPubli"));
                publication.setTitle(resultSet.getString("title"));
                publication.setCategory(resultSet.getString("category"));
                publication.setDescription(resultSet.getString("description"));
                publication.setFileName(resultSet.getString("fileName"));
                publication.setExtension(resultSet.getString("extension"));
                publication.setPathFileName(resultSet.getString("pathFileName"));
                publication.setThumb(resultSet.getString("thumb"));
                publication.setPathThumb(resultSet.getString("pathThumb"));
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

    public Publication listForName(String fileName) {

        connection = MyConnection.getConnection();
        String querySelectPublication = "SELECT * FROM db_jornal_do_brasil.publication where fileName = '" + fileName
                + "';";
        Publication publication = new Publication();
        try {
            statement = connection.prepareStatement(querySelectPublication);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                publication.setIdPubli(resultSet.getInt("idPubli"));
                publication.setTitle(resultSet.getString("title"));
                publication.setCategory(resultSet.getString("category"));
                publication.setDescription(resultSet.getString("description"));
                publication.setFileName(resultSet.getString("fileName"));
                publication.setExtension(resultSet.getString("extension"));
                publication.setPathFileName(resultSet.getString("pathFileName"));
                publication.setThumb(resultSet.getString("thumb"));
                publication.setPathThumb(resultSet.getString("pathThumb"));
                publication.setAuthor(resultSet.getInt("author"));
                publication.setDate(resultSet.getDate("date"));
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }
        return publication;
    }

    public boolean update(Publication publication) {
        boolean reponse = false;
        connection = MyConnection.getConnection();
        String queryUpdatePublication = "update publication set title=?, category=?, description=?, fileName=?, extension=?, pathFileName=?, thumb=?, pathThumb=?, author=?, date=? where idPubli=?;";
        try {
            statement = connection.prepareStatement(queryUpdatePublication);

            statement.setString(1, publication.getTitle());
            statement.setString(2, publication.getCategory());
            statement.setString(3, publication.getDescription());
            statement.setString(4, publication.getFileName());
            statement.setString(5, publication.getExtension());
            statement.setString(6, publication.getPathFileName());
            statement.setString(7, publication.getThumb());
            statement.setString(8, publication.getPathThumb());
            statement.setInt(9, publication.getAuthor());
            Date d = new Date(publication.getDate().getTime());
            statement.setDate(10, d);
            statement.setInt(11, publication.getIdPubli());

            statement.executeUpdate();
            reponse = true;

        } catch (SQLException e) {
            System.out.println("Opss.. Erro ao atualizar Aluno" + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }

        return reponse;
    }

    public boolean deleteForFileName(String fileName) {
        boolean response = false;
        connection = MyConnection.getConnection();
        String queryDeletePublication = "delete from publication where fileName=?";

        try {
            statement = connection.prepareStatement(queryDeletePublication);
            statement.setString(1, fileName);
            statement.executeUpdate();
            response = true;

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao tentar excluir usuário" + e);
        } finally {
            MyConnection.closeConnection(connection, statement);
        }

        return response;
    }

    public List<Publication> listIfContain(String term) {
        List publications = new ArrayList();
        connection = MyConnection.getConnection();
        String querySelectPublication = "SELECT * FROM publication " + "WHERE title LIKE '%" + term + "%' " + "OR category LIKE '%" + term + "%' " + "OR description LIKE '%" + term + "%';";

        try {
            statement = connection.prepareStatement(querySelectPublication);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publication publication = new Publication();
                publication.setIdPubli(resultSet.getInt("idPubli"));
                publication.setTitle(resultSet.getString("title"));
                publication.setCategory(resultSet.getString("category"));
                publication.setDescription(resultSet.getString("description"));
                publication.setFileName(resultSet.getString("fileName"));
                publication.setExtension(resultSet.getString("extension"));
                publication.setPathFileName(resultSet.getString("pathFileName"));
                publication.setThumb(resultSet.getString("thumb"));
                publication.setPathThumb(resultSet.getString("pathThumb"));
                publication.setAuthor(resultSet.getInt("author"));
                publication.setDate(resultSet.getDate("date"));

                publications.add(publication);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar publicações!..." + e.getMessage());
        } finally {
            MyConnection.closeConnection(connection, statement, resultSet);
        }

        return publications;
    }
}