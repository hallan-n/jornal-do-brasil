package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet(urlPatterns = { "/user" })
public class UserController extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    private String openView;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");    
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

    // POST
    // GET
    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        openView = "index.jsp";
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
        userDAO.create(user);
    }

    // private void updateUser(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // }

    // private void listAllUser(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // }

    // private void listUserForId(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");

        User user = userDAO.listForLogin(email);

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", user.getEmail());
            openView = "index.jsp";
        } else {
            request.setAttribute("msg", "Erro ao tentar fazer login");
            openView = "settings.jsp";
        }

    }
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User u = new User();

        u.setName("Hállan");
        u.setSurname("Neves");
        u.setEmail("hallan@neves.com");
        u.setPhone("123456789");
        u.setPassword("12qwaszx");
        u.setAcceptTerms(true);
        u.setDescription("asd");
        u.setProfilePhoto("asd");
        u.setExtension("asd");
        u.setPathProfilePhoto("asd");
        u.setConfiguration(0);

        dao.create(u);

    }

}