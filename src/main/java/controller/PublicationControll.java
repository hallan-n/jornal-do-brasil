package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Env;
import model.Publication;
import services.FileServer;
import dao.PublicationDAO;

@WebServlet(urlPatterns = { "/publication" })
public class PublicationControll extends HttpServlet {
	private FileServer fileServer = new FileServer();
	private PublicationDAO publicationDAO = new PublicationDAO();
	private String[] categories = new String[] { "Política", "Business", "Internacional", "Esportes", "Saúde", "Tecnologia",
				"Entretenimento", "Estilo", "Gastronomia"};
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		// out.println("Publication teste");
		int category = Integer.parseInt(request.getParameter("category"));
		String action = request.getParameter("action");
		if (action.equals("list")) {
            request.setAttribute("publications", publicationDAO.listAll());
			
        }else if (action.equals("list")) {
            request.setAttribute("publications", publicationDAO.listForCategory(categories[category]));
			
		}else if (request.getParameter("action").equals("list")) {
			deletePublication(request, response);
		} 



		RequestDispatcher visualizar = request.getRequestDispatcher("index.jsp");
		visualizar.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		if (request.getParameter("action").equals("create")) {
			createPublication(request, response);
		} else if (request.getParameter("action").equals("update")) {
			updatePublication(request, response);
		} 
		RequestDispatcher visualizar = request.getRequestDispatcher("index.jsp");
		visualizar.forward(request, response);
	}

	// POST
	private void createPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Env env = new Env();
		fileServer.setFileName(env.uuid);
		fileServer.setExtension("html");
		fileServer.setPath("storage\\publications");
		Publication publication = new Publication();
		publication.setTitle(request.getParameter("txtTitle"));
		publication.setCategory(categories[Integer.parseInt(request.getParameter("txtCategory"))]);
		publication.setPath(fileServer.getPathWithFileName());
		publication.setAuthor(1);
		Date datePublication = new Date();
		publication.setDate(datePublication);
		if (publicationDAO.create(publication)) {
			System.out.println("Criado");
			fileServer.writeFile(request.getParameter("txtTextArea"));
		}
		RequestDispatcher visualizar = request.getRequestDispatcher("index.jsp");
		visualizar.forward(request, response);
	}
	
	public void updatePublication(HttpServletRequest request, HttpServletResponse response) {}

	// GET
	public void listPublicationForCategory(HttpServletRequest request, HttpServletResponse response) {}

	public void deletePublication(HttpServletRequest request, HttpServletResponse response) {}

	public void listAllPublication(HttpServletRequest request, HttpServletResponse response) {}
}