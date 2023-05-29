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

@WebServlet("/user")
public class UserController extends HttpServlet {
    // Variaveis globais
    // acao cadastrar editar abrir erro sucesso listar
    
    private String action;
    private String openPage;
    private final String cadastrar = "cadastrar_aluno.jsp";
    private final String editar = "editar_aluno.jsp";
    private final String list = "listar_alunos.jsp";
    private final String success = "sucesso.jsp";
    private final String error = "erro.jsp";
    private UserDAO userDAO = new UserDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        action = request.getParameter("action");


        if (action.equals("register")) {
            registerUser(request, response);
        } else if (action.equals("edit")) {
            editUser(request, response);   
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) {
        boolean acceptTerms = false;
        User user = new User();
        user.setName(request.getParameter("txtName"));
        user.setSurname(request.getParameter("txtSurname"));
        user.setEmail(request.getParameter("txtEmail"));
        user.setPhone(request.getParameter("txtPhone"));
        user.setPassword(request.getParameter("txtPassword"));
        if (request.getParameter("txtAcceptTerms") == "on") {
            acceptTerms = true;
        }
        user.setAcceptTerms(acceptTerms);

        if (userDAO.create(user)) {
            openPage = success;
            request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
        } else {
            openPage = error;
            request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
        }
    }


    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        boolean acceptTerms = false;
        User user = new User();
        user.setIdUser(Integer.parseInt(request.getParameter("txtIdUser")));
        user.setName(request.getParameter("txtName"));
        user.setSurname(request.getParameter("txtSurname"));
        user.setEmail(request.getParameter("txtEmail"));
        user.setPhone(request.getParameter("txtPhone"));
        user.setPassword(request.getParameter("txtPassword"));
        if (request.getParameter("txtAcceptTerms") == "on") {
            acceptTerms = true;
        }
        user.setAcceptTerms(acceptTerms);
        
        if (userDAO.update(user)) {
            openPage = list;
            request.setAttribute("users", userDAO.read());
        } else {
            openPage = error;
            request.setAttribute("msg", "Ops... Erro ao atualizar Aluno!");
        }
        RequestDispatcher visualizar = request.getRequestDispatcher(openPage);
        visualizar.forward(request, response);
    }
}
