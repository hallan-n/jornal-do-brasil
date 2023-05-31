package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publication;
import services.FileServer;
import dao.PublicationDAO;

@WebServlet("/testeController")
public class Teste extends HttpServlet {
    private String action;
    private PublicationDAO publicationDAO = new PublicationDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("testeController");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("teste");
        action = request.getParameter("action");
        if (action.equals("create")) {
            createPublication(request, response);
        }
    }

    private void createPublication(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FileServer fileServer = new FileServer();
        fileServer.setPath("storage/publications");
        fileServer.setExtension("html");

        Date datePublication = new Date();
        Publication publication = new Publication();
        publication.setTitle(request.getParameter("txtTitle"));
        publication.setCategory(request.getParameter("txtCategory"));
        publication.setPath(fileServer.getPath() + datePublication.getTime() + publication.getTitle());
        publication.setAuthor(1);
        publication.setDate(datePublication);
        fileServer.setFileName(datePublication.getTime() + publication.getTitle());

        if (publicationDAO.create(publication)) {
            fileServer.writeFile(request.getParameter("txtTextArea"));
            System.out.println("teste");
        }
    }

}