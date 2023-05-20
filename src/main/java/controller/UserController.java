package controller;

import dao.UserDAO;
import model.User;

public class UserController {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        User user = new User();

        user.setName("Hállan");
        user.setSurname("Neves");
        user.setEmail("hallan@neves.com");
        user.setPhone("98822-3839");
        user.setPassword("123456");
        user.setAcceptTerms(true);
        user.setDescription("Descrição...");
        user.setProfilePhoto("./macaco.jpeg");
        user.setConfiguration(1);
        user.setAddress(1);
        userDAO.create(user);
    }
}
