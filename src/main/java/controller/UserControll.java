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
        out.println("user controll 2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        user.setName(request.getParameter("txtName"));
        user.setSurname(request.getParameter("txtSurname"));
        user.setEmail(request.getParameter("txtEmail"));
        user.setPhone(request.getParameter("txtPhone"));
        user.setPassword(request.getParameter("txtPassword"));
        boolean acceptTerms = false;
        if (request.getParameter("txtAcceptTerms").equals("on")) {
            acceptTerms = true;
        }
        user.setAcceptTerms(acceptTerms);
        UserDAO userDAO = new UserDAO();
        userDAO.create(user);

        RequestDispatcher visualizar = request.getRequestDispatcher("index.jsp");
        visualizar.forward(request, response);
        // String action = request.getParameter("action");
        // if (action.equals("create")) {
        // createUser(request, response);
        // }
        // else if (action.equals("edit")) {
        // updateUser(request, response);
        // }
    }

    public static void main(String[] args) {

        // user.setName("asd");
        // user.setSurname("asd");
        // user.setEmail("asd");
        // user.setPhone("asd");
        // user.setPassword("asd");
        // user.setAcceptTerms(true);
        // user.setDescription("asd");
        // user.setProfilePhoto("asd");
        // user.setAddress(0);
        // user.setConfiguration(0);

    }

    // private void createUser(HttpServletRequest request, HttpServletResponse
    // response) throws ServletException, IOException {
    // User user = new User();
    // user.setName(request.getParameter("txtName"));
    // user.setSurname(request.getParameter("txtSurname"));
    // user.setEmail(request.getParameter("txtEmail"));
    // user.setPhone(request.getParameter("txtPhone"));
    // user.setPassword(request.getParameter("txtPassword"));
    // boolean acceptTerms = false;
    // if (request.getParameter("txtAcceptTerms") == "on") {
    // acceptTerms = true;
    // }
    // user.setAcceptTerms(acceptTerms);
    // if (userDAO.create(user)) {
    // System.out.println("User Criado");
    // }
    // }
}