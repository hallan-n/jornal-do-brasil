package controller;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.MyConnection;



public interface Icrud {


    
}











public class UsuarioController {
    public UsuarioController(){

        MyConnection myConnection = new MyConnection();
        Connection con;
        PreparedStatement stmt;
        ResultSet result;
        
    }


    public boolean create(Usuario usuario) {
        boolean resposta = false;
        String sql = "insert into professor(nome, area, telefone, email, formacao) values(?,?,?,?,?)";
        con = MyConnection.getConnection();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(1, usuario.getFotoPerfil());
            stmt.setString(1, usuario.getNome());
            stmt.setString(1, usuario.getSenha());
            stmt.setString(1, usuario.getSobreNome());
            stmt.setString(1, usuario.getTelefone());          
            stmt.executeUpdate();

            resposta = true;

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir professor" + e);
        } finally {
            MyConnection.closeConnection(con, stmt);
        }

        return resposta;
    }

    public List<Professor> read() {

        List professores = new ArrayList();
        con = MyConnection.getConnection();
        String sql = "select * from professor";

        try {
            stmt = con.prepareCall(sql);
            result = stmt.executeQuery();

            while (result.next()) {
                Professor professor = new Professor();
                professor.setIdProfessor(result.getInt("idProfessor"));
                professor.setNome(result.getString("nome"));
                professor.setArea(result.getString("area"));
                professor.setTelefone(result.getString("telefone"));
                professor.setEmail(result.getString("email"));
                professor.setFormacao(result.getString("formacao"));

                professores.add(professor);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Professors!..." + e);
        } finally {
            MyConnection.closeConnection(con, stmt, result);
        }

        return professores;
    }

    public boolean update(Usuario usuario) {
        boolean resposta = false;
        con = MyConnection.getConnection();
        String sql = "update professor set nome=?, area=?, telefone=?, email=?, formacao=? where idProfessor=?";

        try {
            stmt = con.prepareCall(sql);
            result = stmt.executeQuery();

            while (result.next()) {
                stmt = con.prepareStatement(sql);
                stmt.setString(1, professor.getNome());
                stmt.setString(2, professor.getArea());
                stmt.setString(3, professor.getTelefone());
                stmt.setString(4, professor.getEmail());
                stmt.setString(5, professor.getFormacao());
                resposta = true;
            }
        } catch (SQLException e) {
            System.out.println("Opss... Erro ao atualizar Professor" + e);
        } finally {
            MyConnection.closeConnection(con, stmt, result);
        }

        return resposta;
    }

    public boolean delete(int id) {
        return true;
    }

}
