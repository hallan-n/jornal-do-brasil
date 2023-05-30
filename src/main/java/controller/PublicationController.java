package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Publciation");
	}

	
	
	
	
	
	
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
		
	}

	private void editPublication(HttpServletRequest request, HttpServletResponse response) {
		
	}
}