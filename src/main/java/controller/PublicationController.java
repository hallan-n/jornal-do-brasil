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
public class PublicationController extends HttpServlet {

	private PublicationDAO publicationDAO = new PublicationDAO();
	private String[] categories = new String[] { "Política", "Business", "Internacional", "Esportes", "Saúde",
			"Tecnologia",
			"Entretenimento", "Estilo", "Gastronomia" };

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		String action = request.getParameter("action");

		if (action.equals("list") && category == null) {
			request.setAttribute("publications", publicationDAO.listAll());

		} else if (action.equals("list") && category != null) {
			request.setAttribute("publications",
					publicationDAO.listForCategory(categories[Integer.parseInt(category)]));
		} else if (action.equals("delete")) {
			deletePublication(request, response);
		} else if (action.equals("update")) {
			updatePublication(request, response);
		}else if (action.equals("open")) {
			openPublication(request, response);
		}
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("create")) {
			createPublication(request, response);
		} else if (action.equals("update")) {
			updatePublication(request, response);
		}
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	// POST
	private void createPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Env env = new Env();
		FileServer fileServer = new FileServer();
		fileServer.setFileName(env.uuid);
		fileServer.setExtension("jsp");
		fileServer.setPath("storage\\publications");

		Publication publication = new Publication();
		publication.setTitle(request.getParameter("txtTitle"));
		publication.setCategory(categories[Integer.parseInt(request.getParameter("txtCategory"))]);
		publication.setDescription(request.getParameter("txtDescription"));
		publication.setFileName(fileServer.getFileName());
		publication.setExtension(fileServer.getExtension());
		publication.setPath(fileServer.getPathRelative());
		publication.setAuthor(1);
		Date datePublication = new Date();
		publication.setDate(datePublication);
		if (publicationDAO.create(publication)) {
			System.out.println("Criado");
			fileServer.writeFile(request.getParameter("txtTextArea"));
		}
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	private void updatePublication(HttpServletRequest request, HttpServletResponse response) {

		FileServer fileServer = new FileServer();
		Publication publication = new Publication();

		publication.setTitle(request.getParameter("txtTitle"));
		publication.setCategory(categories[Integer.parseInt(request.getParameter("txtCategory"))]);
		publication.setDescription(request.getParameter("txtDescription"));
		publication.setFileName(fileServer.getFileName());
		publication.setExtension(fileServer.getExtension());
		publication.setPath(fileServer.getPathRelative());
		publication.setAuthor(1);
	}

	// GET
	private void deletePublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileServer fileServer = new FileServer();
		fileServer.setFileName(request.getParameter("filename"));
		fileServer.setExtension("html");
		fileServer.setPath("storage\\publications");

		if (publicationDAO.deleteForFileName(fileServer.getFileName())) {
			System.out.println("Excluido");
			fileServer.deleteFile(fileServer.getPathWithFileName());
		}
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	private void openPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String open = "storage/publications/" + request.getParameter("id") + ".jsp";
		RequestDispatcher view = request.getRequestDispatcher(open);
		view.forward(request, response);
	}

}