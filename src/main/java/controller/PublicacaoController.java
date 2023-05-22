package controller;

import java.util.Date;
import java.util.List;

import dao.PublicacaoDAO;
import model.Publication;

public class PublicacaoController {

    public static void main(String[] args) {
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
        Date data = new Date();

        
        // Publication publication = new Publication("Faz o B", "Esportes", "./caminho", 1, data);
        // publicacaoDAO.create(publication);
        
        // publicacaoDAO.deleteForId(6);
        
        // Publication publication = new Publication();
        // publication.setTitle("FAZ O B");
        // publication.setPath("./asdasd");
        // publication.setIdPubli(1);
        // publication.setDate(data);
        // publication.setCategory("Esportes");
        // publication.setAuthor(1);
        // publicacaoDAO.update(publication);
        
    
        for (Publication i : publicacaoDAO.read()) {
            System.out.print(i.getIdPubli() + " | " + i.getTitle()+ " | " + i.getCategory()+ " | " +i.getPath()+ " | " +i.getAuthor()+ " | " +i.getDate()+ "\n");
        }
        
        


    }
}
