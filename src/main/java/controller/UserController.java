package controller;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import model.User;

public class UserController {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        User user = new User("Hállan", "Neves", "hallan@neves.com", "98822-3839", "123456", true, "Descrição...",
                "./macaco.jpeg", 1,
                1);
        userDAO.create(user);

        for (User i : userDAO.read()) {
            System.out.print(
                    i.getIdUser() + " | " + i.getName() + " | "
                            + i.getSurname() + " | " + i.getEmail() + " | "
                            + i.getPhone() + " | " + i.getPassword() + " | "
                            + i.isAcceptTerms() + " | " + i.getDescription() + " | "
                            + i.getProfilePhoto() + " | " + i.getConfiguration() + " | "
                            + i.getAddress());
        }

    }
}
