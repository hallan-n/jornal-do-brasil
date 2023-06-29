package controller;

import java.util.Date;

import dao.PublicationDAO;
import model.Publication;
import services.FileServer;

public class Teste {
    public static void main(String[] args) {
        // PublicationDAO dao = new PublicationDAO();
        // Publication p = new Publication();
        // p.setTitle("titulo");
        // p.setCategory("Internacional");
        // p.setDescription("Descrição");
        // p.setFileName("FileName");
        // p.setExtension(".html");
        // p.setPathFileName("PathFileName");
        // p.setThumb("Thumb");
        // p.setPathThumb("PathThumb");
        // p.setAuthor(0);
        // Date date = new Date();
        // p.setDate(date);

        // dao.create(p);
        FileServer fileServer = new FileServer();
        fileServer.setFileName("teste");
        fileServer.setExtension("html");
        fileServer.setPath("storage\\publications");
        fileServer.writeFile("teste");

    }

}