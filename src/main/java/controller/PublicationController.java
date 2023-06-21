
package controller;

import java.io.IOException;
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
	private String openView;
	private PublicationDAO publicationDAO = new PublicationDAO();
	private String[] categories = new String[] { "Política", "Business", "Internacional", "Esportes", "Saúde",
			"Tecnologia", "Entretenimento", "Estilo", "Gastronomia" };

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category = request.getParameter("category");
		String action = request.getParameter("action");

		if (action.equals("list") && category != null) {
			openView = "index.jsp";
			request.setAttribute("publications",
					publicationDAO.listForCategory(categories[Integer.parseInt(category)]));
		} else if (action.equals("list")) {
			openView = "index.jsp";
			request.setAttribute("publications", publicationDAO.listAll());
		} else if (action.equals("delete")) {
			deletePublication(request, response);
		} else if (action.equals("open")) {
			openPublication(request, response);
		} else if (action.equals("edit")) {
			editPublication(request, response);
		}
		RequestDispatcher view = request.getRequestDispatcher(openView);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("create")) {
			createPublication(request, response);
		} else if (action.equals("edit")) {
			editPublicationPost(request, response);
		}

		RequestDispatcher view = request.getRequestDispatcher(openView);
		view.forward(request, response);
	}

	// POST
	private void createPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		openView = "index.jsp";
		Env env = new Env();
		FileServer fileServer = new FileServer();
		fileServer.setFileName(env.uuid);
		fileServer.setExtension("html");
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
			fileServer.writeFile(request.getParameter("txtTextArea"));
		}

	}

	private void editPublicationPost(HttpServletRequest request, HttpServletResponse response) {
		openView = "index.jsp";

		FileServer fileServer = new FileServer();
		fileServer.setFileName(request.getParameter("uuidTitle"));
		fileServer.setExtension("html");
		fileServer.setPath("storage\\publications");
		fileServer.writeFile(request.getParameter("txtTextAreaT"));

		// Publication publication = new Publication();
		// publication.setTitle(request.getParameter("txtTitleT"));
		// publication.setCategory(categories[Integer.parseInt(request.getParameter("txtCategoryT"))]);
		// publication.setDescription(request.getParameter("txtDescriptionT"));
		// publication.setFileName(fileServer.getFileName());
		// publication.setExtension(fileServer.getExtension());
		// publication.setPath(fileServer.getPathRelative());
		// publication.setAuthor(1);
		// Date datePublication = new Date();
		// publication.setDate(datePublication);
		// if (publicationDAO.create(publication)) {
		// fileServer.writeFile(request.getParameter("txtTextAreaT"));
		// }
	}

	// GET
	private void editPublication(HttpServletRequest request, HttpServletResponse response) {

		openView = "edit_publication.jsp";
		FileServer fileServer = new FileServer();
		fileServer.setPath("storage\\publications");
		fileServer.setExtension("html");
		fileServer.setFileName(request.getParameter("id"));
		request.setAttribute("publicationEdit",
				publicationDAO.listForName(request.getParameter("id")));
		request.setAttribute("contentPubli", fileServer.readFile(fileServer.getPathWithFileName()));
		request.setAttribute("uuid", request.getParameter("id"));
	}

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
	}

	private void openPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileServer fileServer = new FileServer();
		fileServer.setPath("storage\\publications");
		fileServer.setExtension("html");
		fileServer.setFileName(request.getParameter("id"));
		String open = fileServer.readFile(fileServer.getPathWithFileName());
		request.setAttribute("openPubli", open);
	}
}