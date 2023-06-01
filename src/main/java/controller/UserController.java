package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private String action;
	private UserDAO userDAO = new UserDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("user");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("teste");
		action = request.getParameter("action");
		if (action.equals("create")) {
			createUser(request, response);
		} else if (action.equals("edit")) {
			updateUser(request, response);
		} else if (action.equals("delete")) {
			deleteUser(request, response);
		} else if (action.equals("listAll")) {
			listAllUser(request, response);
		} else if (action.equals("listForId")) {
			listUserForId(request, response);
		}
	}

	public void createUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setName(request.getParameter(""));
		user.setSurname(request.getParameter(""));
		user.setEmail(request.getParameter(""));
		user.setPhone(request.getParameter(""));
		user.setPassword(request.getParameter(""));
		boolean acceptTerms = false;
		if (request.getParameter("") == "on") {
			acceptTerms = true;
		}
		user.setAcceptTerms(acceptTerms);

		if (userDAO.create(user)) {
			System.out.println("User Criado");
		}
		RequestDispatcher visualizar = request.getRequestDispatcher("index.jsp");
		visualizar.forward(request, response);

	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response) {

	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) {

	}

	public void listAllUser(HttpServletRequest request, HttpServletResponse response) {

	}

	public void listUserForId(HttpServletRequest request, HttpServletResponse response) {

	}
}
