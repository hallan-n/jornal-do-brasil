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



    public boolean create(Usuario object) {
        boolean retorno = false;
        String inserctUser = "insert into usuario(nome, email, telefone, idade) values(?,?,?,?)";










        return true;
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
