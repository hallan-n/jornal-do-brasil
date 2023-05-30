package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.FileServer;


@WebServlet("/user")
public class UserController extends HttpServlet {
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
		out.println("user");
	}
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	public static void main(String[] args) {
        FileServer fileServer = new FileServer("storage","teste","html");

        fileServer.writeFile("teste");
    }
}
