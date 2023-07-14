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
import services.FileServer;
import services.JpegConverter;

@WebServlet(urlPatterns = { "/user" })
public class UserController extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    private String openView;
    FileServer fileServer = new FileServer();
    PublicationDAO publicationDAO = new PublicationDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("logout")) {
            logoutUser(request, response);
        } else if (action.equals("profile")) {
            openView = "profile.jsp";
            setUserData(request, response);
        } else if (action.equals("edit")) {
            openView = "edit_profile.jsp";
            setUserData(request, response);
        }
        RequestDispatcher view = request.getRequestDispatcher(openView);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if (action.equals("create")) {
            createUser(request, response);
        } else if (action.equals("login")) {
            userLogin(request, response);
        } else if (action.equals("edit")) {
            openView = "edit_profile.jsp";
            updateUser(request, response);
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
        getUserData(request, response);
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

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = getUserData(request, response);
        user.setName(request.getParameter("txtName"));
        user.setSurname(request.getParameter("txtSurname"));

        if (!user.getEmail().equals(request.getParameter("txtEmail"))) {
            openView = "login.jsp";
        }else{
            openView = "profile.jsp";
        }
        user.setEmail(request.getParameter("txtEmail"));
        user.setPhone(request.getParameter("txtPhone"));
        user.setPassword(request.getParameter("txtPassword"));
        user.setDescription(request.getParameter("txtDescription"));

        // file server thumb
		JpegConverter jpegConverter = new JpegConverter();
		jpegConverter.saveImage(request, response, request.getParameter("txtID"), "thumb");

		fileServer.setPath("storage\\profile");
		fileServer.setExtension(jpegConverter.getExtension());

        user.setProfilePhoto("");
        user.setExtension("");
        user.setPathProfilePhoto("");











        if (userDAO.update(user)) {
            request.setAttribute("msg", "Dados atualizados com sucesso!");
            setUserData(request, response);
        } else {
            request.setAttribute("msg", "Email já cadastrado!");
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
                setAuth(request, response, user);
            }
        } catch (Exception e) {
            openView = "login.jsp";
            request.setAttribute("msg", "Login ou senha incorretos");
            request.setAttribute("css", "text-danger");
        }
        request.setAttribute("publications", publicationDAO.listAll());
        setUserData(request, response);
    }

    private void setUserData(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        request.setAttribute("user", userDAO.listForLogin((String) session.getAttribute("email")));
    }

    private User getUserData(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        return userDAO.listForLogin((String) session.getAttribute("email"));
    }

    private void setAuth(HttpServletRequest request, HttpServletResponse response, User user) {
        HttpSession session = request.getSession();
        session.setAttribute("email", user.getEmail());
    }

    public static void main(String[] args) {
        User u = new User();
        u.setAcceptTerms(true);
        u.setConfiguration(0);
        u.setDescription("asd");
        u.setEmail("asd");
        u.setExtension("asd");
        u.setName("Hállan");
        u.setPassword("asdasd");
        u.setPathProfilePhoto("asd");
        u.setPhone("123");
        u.setProfilePhoto("asd");
        u.setSurname("Tásds");
        UserDAO dao = new UserDAO();
        dao.create(u);
    }
}