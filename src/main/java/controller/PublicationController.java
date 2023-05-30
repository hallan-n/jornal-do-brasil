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

import model.Publication;
import dao.PublicationDAO;

// acao abrir cadastrar editar listar sucesso erro
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
		if (action.equals("register")) {
			createPublication(request, response);
		} else if (action.equals("edit")) {
			editPublication(request, response);
		}

	}

	private void createPublication(HttpServletRequest request, HttpServletResponse response) {

		Publication publication = new Publication();
		publication.setTitle(request.getParameter("txtTitle"));
		publication.setCategory(request.getParameter("txtNome"));
		publication.setPath(request.getParameter("txtNome"));
		publication.setAuthor(Integer.parseInt(request.getParameter("txtIdade")));
		Date d = new Date();
		publication.setDate(d);

		if (publicationDAO.create(publication)) {
			open = success;
			request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
		} else {
			open = error;
			request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
		}
	}

	private void editPublication(HttpServletRequest request, HttpServletResponse response) {
	}
}