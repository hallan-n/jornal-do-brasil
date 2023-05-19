package controller.usuario;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController{

    MyConnection myConnection = new MyConnection();
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;



    public boolean create(Usuario usuario) {
        boolean resposta = false;
        String inserirUsuario = "insert into usuario(nome, sobrenome, email, telefone, senha, aceitaTermos, fotoPerfil, endereco, configuracao) values(?,?,?,?,?,?,?,?,?)";
        connection = myConnection.getConnection();
        try {
            statement = connection.prepareStatement(inserirUsuario);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSobreNome());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getTelefone());
            statement.setString(5, usuario.getSenha());
            statement.setBoolean(6, usuario.isAceitaTermos());
            statement.setString(7, usuario.getFotoPerfil());
            statement.setObject(8, usuario.getEndereco());
            statement.setObject(9, usuario.getConfiguracao());
            statement.executeUpdate();
            resposta = true;

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Usuário: " + e);
        }finally{
            MyConnection.closeConnection(connection, statement);
        }
        return resposta;
    }


    public List<Object> read() {
        return new ArrayList();
    }

    public boolean update(Usuario object) {
        return true;
    }

    public boolean delete(int id) {
        return true;
    }

}
