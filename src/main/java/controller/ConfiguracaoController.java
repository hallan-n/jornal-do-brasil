package controller;

import dao.ConfiguracaoDAO;
import model.Configuration;

public class ConfiguracaoController {
    public static void main(String[] args) {

        ConfiguracaoDAO configuracaoDAO = new ConfiguracaoDAO();

        // Configuration configuration = new Configuration(true,true,true,true,true,true,"Dark");
        // configuracaoDAO.create(configuration);
        
        // Configuration configuration = new Configuration();
        // configuration.setIdConfig(2);
        // configuration.setNotification(false);
        // configuration.setSound(false);
        // configuration.setShowProfilePhoto(false);
        // configuration.setShowdescription(false);
        // configuration.setShowNumber(false);
        // configuration.setShowEmail(false);
        // configuration.setTheme("Dark");
        // configuracaoDAO.update(configuration);
        
        // configuracaoDAO.deleteForId(4);
        
        // for (Configuration i : configuracaoDAO.read()) {
        //     System.out.print(i.getIdConfig()+" | "+i.isNotification()+" | "+i.isSound()+" | "+i.isShowProfilePhoto()+" | "+i.isShowdescription()+" | "+i.isShowNumber()+" | "+i.isShowEmail()+" | "+i.getTheme()+"\n");
        // }
    }
}
