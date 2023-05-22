package controller;

import dao.UserDAO;
import model.User;

public class UserController {
    public static void main(String[] args) {

        // UserDAO userDAO = new UserDAO();

        // CREATE
        // User user = new User("Hállan", "Neves", "hallan@neves.com", "98822-3839", "123456", true, "Descrição...",
        //         "./macaco.jpeg", 1,
        //         1);
        // userDAO.create(user);

        // READ
        // for (User i : userDAO.read()) {
        //     System.out.print(
        //         i.getIdUser() + " | " + i.getName() + " | "
        //         + i.getSurname() + " | " + i.getEmail() + " | "
        //         + i.getPhone() + " | " + i.getPassword() + " | "
        //         + i.isAcceptTerms() + " | " + i.getDescription() + " | "
        //         + i.getProfilePhoto() + " | " + i.getConfiguration() + " | "
        //         + i.getAddress() + "\n");
        // }

        // // UPDADE
        // User user2 = new User("Hállan", "Neves", "hallan@neves.com", "98822-3839", "123456", true, "Descrição...", "./macaco.jpeg", 1, 1);
        // user2.setIdUser(2);
        // userDAO.update(user2);

        // DELETE

        // userDAO.deleteForId(8);
    }
}
