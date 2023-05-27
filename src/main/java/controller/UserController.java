package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

public class UserController extends HttpServlet {
    // Variaveis globais
    private String acao, abrir;
    private final String cadastrar = "cadastrar_aluno.jsp";
    private final String editar = "editar_aluno.jsp";
    private final String listar = "listar_alunos.jsp";
    private final String sucesso = "sucesso.jsp";
    private final String erro = "erro.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    // @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {

    //     acao = request.getParameter("acao");
    //     UserDAO userDAO = new UserDAO();

    //     if (acao.equals("listar")) {
    //         abrir = listar;
    //         request.setAttribute("alunos", userDAO.read());
    //     } else if (acao.equals("editar")) {
    //         int idAluno = Integer.parseInt(request.getParameter("id"));
    //         request.setAttribute("aluno", userDAO.findId(idAluno));
    //         abrir = editar;
    //     }
    //     RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
    //     visualizar.forward(request, response);
    // }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean acceptTerms = false;
        acao = request.getParameter("acao");
        if (acao.equals("cadastrar")) {
            User user = new User();
            user.setName(request.getParameter("txtNome"));
            user.setSurname(request.getParameter("txtNome"));
            user.setEmail(request.getParameter("txtNome"));
            user.setPhone(request.getParameter("txtNome"));
            user.setPassword(request.getParameter("txtNome"));
            if(request.getParameter("txtNome")=="on"){
                acceptTerms = true;
            }
            user.setAcceptTerms(acceptTerms);
            








            aluno.setNome(request.getParameter("txtNome"));
            aluno.setEmail(request.getParameter("txtEmail"));
            aluno.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
            aluno.setTelefone(request.getParameter("txtTelefone"));

            AlunoDAO userDAO = new AlunoDAO();

            if (userDAO.create(aluno)) {
                abrir = sucesso;
                request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
            }
        } else if (acao.equals("editar")) {

            Aluno alu = new Aluno();

            alu.setIdAluno(Integer.parseInt(request.getParameter("txtId")));
            alu.setNome(request.getParameter("txtNome"));
            alu.setEmail(request.getParameter("txtEmail"));
            alu.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
            alu.setTelefone(request.getParameter("txtTelefone"));

            AlunoDAO userDAO = new AlunoDAO();

            if (userDAO.update(alu)) {
                abrir = listar;
                request.setAttribute("alunos", userDAO.read());
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao atualizar Aluno!");

            }

            RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
            visualizar.forward(request, response);

        }
    }

}
