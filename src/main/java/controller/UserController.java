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

    private String action;
    private String abrir;
    private final String cadastrar = "cadastrar_aluno.jsp";
    private final String editar = "editar_aluno.jsp";
    private final String listar = "listar_alunos.jsp";
    private final String sucesso = "sucesso.jsp";
    private final String erro = "erro.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        action = request.getParameter("action");
        UserDAO userDAO = new UserDAO();
        
        if (action.equals("listar")) {
            abrir = listar;
            request.setAttribute("alunos", userDAO.read());
            
        } else if (action.equals("editar")) {
            int idAluno = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("aluno", action.findId(idAluno));
            abrir = editar;
        }
        
        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        
        visualizar.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        action = request.getParameter("action");
        if (action.equals("cadastrar")) {
            Boolean acceptTerms = false;
            User user = new User();
            user.setName(request.getParameter("txtName"));
            user.setSurname(request.getParameter("txtSurname"));
            user.setEmail(request.getParameter("txtEmail"));
            user.setPhone(request.getParameter("txtPhone"));
            user.setPassword(request.getParameter("txtPassword"));
            if(request.getParameter("txtAcceptTerms")=="on"){
                acceptTerms=true;
            }
            user.setAcceptTerms(acceptTerms);
            UserDAO userDAO = new UserDAO();


            if (userDAO.create(user)) {
                abrir = sucesso;
                request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
            }
        } else if (action.equals("editar")) {

            Aluno alu = new Aluno();

            alu.setIdAluno(Integer.parseInt(request.getParameter("txtId")));
            alu.setNome(request.getParameter("txtNome"));
            alu.setEmail(request.getParameter("txtEmail"));
            alu.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
            alu.setTelefone(request.getParameter("txtTelefone"));

            AlunoDAO dao = new AlunoDAO();

            if (dao.update(alu)) {
                abrir = listar;
                request.setAttribute("alunos", dao.read());
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao atualizar Aluno!");

            }

            RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
            visualizar.forward(request, response);

        }
    }

}
