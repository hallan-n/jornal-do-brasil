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

@WebServlet("/publication")
public class PublicationController extends HttpServlet {
	private String action;
	private PublicationDAO publicationDAO = new PublicationDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Publication");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("teste");
		action = request.getParameter("action");
		if (action.equals("create")) {
			createPublication(request, response);
		} else if (action.equals("edit")) {
			updatePublication(request, response);
		}

	}

	private void createPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] categories = new String[] { "Política", "Business", "Internacional", "Esportes", "Saúde", "Tecnologia",
				"Entretenimento", "Estilo", "Gastronomia" };
		FileServer fileServer = new FileServer();

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
			request.setAttribute("msg", "Uhull... Publicaçãocriada com sucesso!");
			fileServer.writeFile(request.getParameter("txtTextArea"));
		}
		RequestDispatcher visualizar = request.getRequestDispatcher("index.jsp");
		visualizar.forward(request, response);
	}

	private void deletePublication(HttpServletRequest request, HttpServletResponse response) {
	}

	private void updatePublication(HttpServletRequest request, HttpServletResponse response) {
	}

	private void listAllPublication(HttpServletRequest request, HttpServletResponse response) {

	}

	private void listPublicationForCategory(HttpServletRequest request, HttpServletResponse response) {
	}
}