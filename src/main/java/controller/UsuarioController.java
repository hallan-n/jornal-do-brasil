package controller;

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
            statement.setString(0, usuario.getNome());
            statement.setString(0, usuario.getSobreNome());
            statement.setString(0, usuario.getEmail());
            statement.setString(0, usuario.getTelefone());
            statement.setString(0, usuario.getSenha());
            statement.setBoolean(0, usuario.isAceitaTermos());
            statement.setString(0, usuario.getFotoPerfil());
            statement.setObject(0, usuario.getEndereco());
            statement.setObject(0, usuario.getConfiguracao());
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
