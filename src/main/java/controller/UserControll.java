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

@WebServlet(urlPatterns = { "/user" })
public class UserControll extends HttpServlet {
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("user");

        // if (request.getParameter("action").equals("list")) {
        //     request.setAttribute("publications", userDAO.read());
        // }
        //  else if (request.getParameter("action").equals("listForId")) {
        //     int idAluno = Integer.parseInt(request.getParameter("id"));
        //     request.setAttribute("aluno", userDAO.read(idAluno));
        //     abrir = editar;
        // }
        // RequestDispatcher visualizar = request.getRequestDispatcher();
        // visualizar.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("action").equals("create")) {
            createUser(request, response);
        } else if (request.getParameter("action").equals("update")) {
            updateUser(request, response);
        } else if (request.getParameter("action").equals("listAll")) {
            listAllUser(request, response);
        } else if (request.getParameter("action").equals("listForId")) {
            listUserForId(request, response);
        } else if (request.getParameter("action").equals("delete")) {
            deleteUser(request, response);
        }

    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("txtName"));
        user.setSurname(request.getParameter("txtSurname"));
        user.setEmail(request.getParameter("txtEmail"));
        user.setPhone(request.getParameter("txtPhone"));
        user.setPassword(request.getParameter("txtPassword"));
        user.setAcceptTerms(request.getParameter("txtAcceptTerms").equals("on"));
        if (userDAO.create(user)) {
            System.out.println("Usuário criado");
        }
        RequestDispatcher visualizar = request.getRequestDispatcher("index.jsp");
        visualizar.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void listAllUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void listUserForId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}