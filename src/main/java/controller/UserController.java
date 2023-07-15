package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import config.Env;
import dao.PublicationDAO;
import dao.UserDAO;
import model.User;
import services.FileServer;
import services.JpegConverter;

@MultipartConfig
@WebServlet(urlPatterns = { "/user" })
public class UserController extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    private String openView;

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

        Env env = new Env();

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
        // file server thumb
        if (request.getPart("profile").getSize() > 0) {
            JpegConverter jpegConverter = new JpegConverter();
            jpegConverter.saveImage(request, response, env.uuid, "profile", "storage\\profile");            
            // file server publication
            FileServer fileServer = new FileServer();
            fileServer.setFileName(env.uuid);
            fileServer.setPath("storage\\profile");
            fileServer.setExtension(jpegConverter.getExtension());    
            user.setProfilePhoto(env.uuid);
            user.setExtension(jpegConverter.getExtension());
            user.setPathProfilePhoto(fileServer.getPathRelative());
        }

        user.setConfiguration(0);
         // file server thumb   
        if (userDAO.create(user)) {
            setUserData(request, response);
            request.setAttribute("msg", "Login criado com sucesso!");
            request.setAttribute("css", "text-success");
            openView = "login.jsp";
        } else {
            request.setAttribute("msg", "Email já cadastrado!");
            openView = "create_account.jsp";
        }
        request.setAttribute("publications", publicationDAO.listAll());

    }

    // FALTA FAZER
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = getUserData(request, response);
        user.setName(request.getParameter("txtName"));
        user.setSurname(request.getParameter("txtSurname"));

        if (!user.getEmail().equals(request.getParameter("txtEmail"))) {
            openView = "login.jsp";
        } else {
            openView = "profile.jsp";
        }
        user.setEmail(request.getParameter("txtEmail"));
        user.setPhone(request.getParameter("txtPhone"));
        user.setPassword(request.getParameter("txtPassword"));
        user.setDescription(request.getParameter("txtDescription"));

        // file server thumb

        if (request.getPart("profile").getSize() <= 0) {
            user.setProfilePhoto(getUserData(request, response).getProfilePhoto());
            user.setExtension(getUserData(request, response).getExtension());
            user.setPathProfilePhoto(getUserData(request, response).getPathProfilePhoto());           

        } else {
            System.out.println(request.getPart("profile").getSize());
            // Delete old profile photo
            FileServer fileServer = new FileServer();
            fileServer.setPath("storage\\profile");
            fileServer.setFileName(getUserData(request, response).getProfilePhoto());
            fileServer.setExtension(getUserData(request, response).getExtension());
            fileServer.deleteFile(fileServer.getPathWithFileName());

            JpegConverter jpegConverter = new JpegConverter();
            jpegConverter.saveImage(request, response, getUserData(request, response).getProfilePhoto(), "profile",
                    "storage\\profile");
            user.setProfilePhoto(getUserData(request, response).getProfilePhoto());
            user.setExtension(jpegConverter.getExtension());
            fileServer.setPath("storage\\profile");
            fileServer.setFileName(getUserData(request, response).getProfilePhoto());
            fileServer.setExtension(jpegConverter.getExtension());
            user.setPathProfilePhoto(fileServer.getPathRelative());
        }

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
        // u.setName("Hállan");
        // u.setSurname("Tásds");
        // u.setEmail("asd");
        // u.setPhone("123");
        // u.setPassword("asdasd");
        // u.setAcceptTerms(true);
        // u.setDescription("asd");
        // u.setProfilePhoto("asd");
        // u.setExtension("asd");
        // u.setPathProfilePhoto("asd");
        // u.setConfiguration(0);
        UserDAO dao = new UserDAO();
        System.out.println(dao.listForLogin("hallan@neves.com").getEmail());

    }
}