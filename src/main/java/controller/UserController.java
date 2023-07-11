package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PublicationDAO;
import dao.UserDAO;
import model.User;

@WebServlet(urlPatterns = { "/user" })
public class UserController extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    private String openView;
    PublicationDAO publicationDAO = new PublicationDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("logout")) {
            logoutUser(request, response);
        } else if (action.equals("profile")) {
            openView = "profile.jsp";
            HttpSession session = request.getSession();
            request.setAttribute("user", userDAO.listForLogin((String) session.getAttribute("email")));
        }
        RequestDispatcher view = request.getRequestDispatcher(openView);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("create")) {
            createUser(request, response);
        } else if (action.equals("login")) {
            userLogin(request, response);
        }
        RequestDispatcher view = request.getRequestDispatcher(openView);
        view.forward(request, response);

    }

    // GET
    private void logoutUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("email", null);
        openView = "index.jsp";
        request.setAttribute("publications", publicationDAO.listAll());
    }

    // POST
    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        boolean acceptTerms = false;
        user.setName(request.getParameter("txtName"));
        user.setSurname(request.getParameter("txtSurname"));
        user.setEmail(request.getParameter("txtEmail"));
        user.setPhone(request.getParameter("txtPhone"));
        user.setPassword(request.getParameter("txtPassword"));
        if (request.getParameter("txtAcceptTerms").equals("on")) {
            acceptTerms = true;
        }
        user.setAcceptTerms(acceptTerms);
        if (userDAO.create(user)) {
            request.setAttribute("msg", "Login criado com sucesso!");
            request.setAttribute("css", "text-success");
            openView = "login.jsp";
        } else {
            request.setAttribute("msg", "Email já cadastrado!");
            openView = "create_account.jsp";
        }
        request.setAttribute("publications", publicationDAO.listAll());

    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        User user = userDAO.listForLogin(email);
        try {
            if (user != null && user.getPassword().equals(password) && user.getEmail().equals(email)) {
                openView = "index.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("email", user.getEmail());
                request.setAttribute("user", userDAO.listForLogin((String) session.getAttribute("email")));
            }
        } catch (Exception e) {
            openView = "login.jsp";
            request.setAttribute("msg", "Login ou senha incorretos");
            request.setAttribute("css", "text-danger");
        }
        request.setAttribute("publications", publicationDAO.listAll());
    }
}