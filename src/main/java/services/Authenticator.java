package services;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDAO;
import model.User;



public class Authenticator {
    public static void setUserData(HttpServletRequest request, HttpServletResponse response) {
        UserDAO userDAO =  new UserDAO();
        HttpSession session = request.getSession();
        request.setAttribute("user", userDAO.listForLogin((String) session.getAttribute("email")));
    }
    
    public User getUserData(HttpServletRequest request, HttpServletResponse response) {
        UserDAO userDAO =  new UserDAO();
        HttpSession session = request.getSession();
        return userDAO.listForLogin((String) session.getAttribute("email"));
    }
    
    public void setAuth(HttpServletRequest request, HttpServletResponse response, User user) {
        UserDAO userDAO =  new UserDAO();
        HttpSession session = request.getSession();
        session.setAttribute("email", user.getEmail());
    }
}