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

@WebServlet("/publication")
public class PublicationController extends HttpServlet {
	private String open;
	private String action;
	private final String create = "cadastrar_aluno.jsp";
	private final String edit = "editar_aluno.jsp";
	private final String list = "listar_alunos.jsp";
	private final String success = "sucesso.jsp";
	private final String error = "erro.jsp";
	private PublicationDAO publicationDAO = new PublicationDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Publciation");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		action = request.getParameter("action");
		if (action.equals("create")) {
			createPublication(request, response);
		} else if (action.equals("edit")) {
			updatePublication(request, response);
		}

	}

	private void createPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileServer fileServer = new FileServer();
		fileServer.setExtension("html");
		fileServer.setPath("storage/publications/");
		fileServer.setFileName("teste");

		Date datePublication = new Date();

		Publication publication = new Publication();
		publication.setTitle(request.getParameter("txtTitle"));
		publication.setCategory(request.getParameter("txtCategory"));
		publication.setPath("storage/publications/" + fileServer.getFileName() + "/" + datePublication.getTime());
		publication.setAuthor(1);
		publication.setDate(datePublication);

		if (publicationDAO.create(publication)) {
			open = success;
			request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
		} else {
			open = error;
			request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
		}
		RequestDispatcher visualizar = request.getRequestDispatcher(open);
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