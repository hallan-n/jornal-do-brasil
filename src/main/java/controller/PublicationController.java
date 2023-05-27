package controller;
import java.util.Date;
import java.util.List;
import dao.PublicationDAO;
import model.Publication;
import services.FileServer;

public class PublicationController {
    
    public static void main(String[] args) {
        FileServer fileServer = new FileServer();
        fileServer.setPath("\\src\\main\\java\\storage\\");
        fileServer.setFileName("Teste");
        fileServer.setExtension(".html");
        fileServer.writeFile("teste");


    }
}
