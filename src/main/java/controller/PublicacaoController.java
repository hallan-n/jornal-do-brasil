package controller;
import java.util.Date;

import dao.PublicacaoDAO;
import model.Publication;

public class PublicacaoController {

    public static void main(String[] args) {
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
        Date data = new Date();

        
        Publication publication = new Publication("Faz o L", "Esportes", "./caminho", 1, data);
        
        
        
    

        publicacaoDAO.create(publication);
    }
}
