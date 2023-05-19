package controller;

import model.Usuario;
import model.Endereco;
import model.Configuracao;

import dao.UsuarioDAO;

public class UsuarioController {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Endereco endereco = new Endereco(123,"casa", "Novo Horizonte", "Serra", "ES", 29163340);

        Configuracao configuracao = new Configuracao(true,true,true,true,true,true,"dark");

        Usuario usuario = new Usuario("Hállan","Neves","hallan@hallan.com","27988223839","123456", true,"./macaco.jpeg",endereco,configuracao);

        usuarioDAO.create(usuario);

    }

}