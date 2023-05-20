package controller;

import dao.UserDAO;
import model.User;
import model.Address;
import model.Configuration;

public class UserController {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        
        Address address = new Address("330", "Casa", "Novo Horizonte", "Serra", "Espírito Santo", "29163340");
        
        Configuration configuration = new Configuration(true, true, true, true, true, true, "Dark");


        User user = new User("Hállan","Neves","hallan@neves.com","27988223839","123456",true,"Teste teste","./macaco.jpeg",1,0);

        userDAO.create(user);
        if(userDAO.create(user)){
            System.out.println("Cadastrou");
        }else{
            System.out.println("N cadastrou");
        }
    }

}