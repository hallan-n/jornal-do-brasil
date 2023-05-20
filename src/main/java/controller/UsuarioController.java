package controller;

import model.User;
import model.Address;
import model.Configuration;

import dao.UsuarioDAO;

public class UsuarioController {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Endereco endereco = new Endereco(123,"casa", "Novo Horizonte", "Serra", "ES", 29163340);

        // Configuracao configuracao = new Configuracao(true,true,true,true,true,true,"dark");

        // Usuario usuario = new Usuario("Hállan","Neves","hallan@hallan.com","27988223839","123456", true,"./macaco.jpeg",endereco,configuracao);
        
        User usuario = new User();
        usuario.setNome("pixa");
        usuarioDAO.create(usuario);

    }

}