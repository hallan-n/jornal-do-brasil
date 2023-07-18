
package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import config.Env;
import model.Publication;
import services.Authenticator;
import services.FileServer;
import services.JpegConverter;
import dao.PublicationDAO;
import dao.UserDAO;

@MultipartConfig
@WebServlet(urlPatterns = { "/publication" })
public class PublicationController extends HttpServlet {
	Authenticator auth = new Authenticator();
	private String openView;
	private PublicationDAO publicationDAO = new PublicationDAO();
	private String[] categories = new String[] { "Política", "Business", "Internacional", "Esportes", "Saúde",
			"Tecnologia", "Entretenimento", "Estilo", "Gastronomia" };

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Authenticator auth = new Authenticator();
		String category = request.getParameter("category");
		String action = request.getParameter("action");
		String contain = request.getParameter("contain");
		HttpSession sessao = request.getSession();
		UserDAO userDAO = new UserDAO();

		request.setAttribute("user", userDAO.listForLogin((String) sessao.getAttribute("email")));
		if (action.equals("list") && category == null && contain == null) {
			if (sessao.getAttribute("email") == null) {
				openView = "index_logout.jsp";
			} else {
				openView = "index.jsp";
			}
			request.setAttribute("publications", publicationDAO.listAll());
			request.setAttribute("id", userDAO.listForLogin((String) sessao.getAttribute("email")).getIdUser());
		} else if (action.equals("list") && category != null && contain == null) {
			if (sessao.getAttribute("email") == null) {
				openView = "index_logout.jsp";
			} else {
				openView = "index.jsp";
			}
			request.setAttribute("publications",
					publicationDAO.listForCategory(categories[Integer.parseInt(category)]));
			request.setAttribute("id", userDAO.listForLogin((String) sessao.getAttribute("email")).getIdUser());
		} else if (action.equals("listall")) {
			if (sessao.getAttribute("email") == null) {
				openView = "index_logout.jsp";
			} else {
				openView = "all_publications.jsp";
			}
			request.setAttribute("publications", publicationDAO.listForAuthor(auth.getUserData(request, response).getIdUser()));
		} else if (action.equals("list") && contain != null && category == null) {
			if (sessao.getAttribute("email") == null) {
				openView = "index_logout.jsp";
			} else {
				openView = "index.jsp";
			}
			request.setAttribute("publications", publicationDAO.listIfContain(contain));
			request.setAttribute("id", userDAO.listForLogin((String) sessao.getAttribute("email")).getIdUser());

		} else if (action.equals("delete")) {
			if (sessao.getAttribute("email") == null) {
				openView = "index_logout.jsp";
			} else {
				deletePublication(request, response);
			}
		} else if (action.equals("open")) {
			openPublication(request, response);
		} else if (action.equals("edit")) {
			if (sessao.getAttribute("email") == null) {
				openView = "index_logout.jsp";
			} else {
				editPublication(request, response);
			}
		} else if (action.equals("create")) {
			if (sessao.getAttribute("email") == null) {
				openView = "index_logout.jsp";
			} else {
				openView = "create_publication.jsp";
				auth.setUserData(request, response);
			}
		}
		RequestDispatcher view = request.getRequestDispatcher(openView);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

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
		request.setAttribute("publications", publicationDAO.listAll());

		// env
		Env env = new Env();

		// file server publication
		FileServer fileServer = new FileServer();
		fileServer.setFileName(env.uuid);
		fileServer.setExtension("html");
		fileServer.setPath("storage\\publications");
		fileServer.writeFile(request.getParameter("txtTextArea"));

		// publication
		Publication publication = new Publication();
		publication.setTitle(request.getParameter("txtTitle"));
		publication.setCategory(categories[Integer.parseInt(request.getParameter("txtCategory"))]);
		publication.setDescription(request.getParameter("txtDescription"));
		publication.setFileName(fileServer.getFileName());
		publication.setExtension(fileServer.getExtension());
		publication.setPathFileName(fileServer.getPathRelative());
		Date datePublication = new Date();
		publication.setDate(datePublication);

		// Author
		HttpSession sessao = request.getSession();
		UserDAO userDAO = new UserDAO();
		String user = sessao.getAttribute("email").toString();
		publication.setAuthor(userDAO.listForLogin(user).getIdUser());

		// file server thumb
		JpegConverter jpegConverter = new JpegConverter();
		jpegConverter.saveImage(request, response, env.uuid, "thumb", "storage\\thumb");

		fileServer.setPath("storage\\thumb");
		fileServer.setExtension(jpegConverter.getExtension());
		publication.setThumb(env.uuid);
		publication.setPathThumb(fileServer.getPathRelative());

		publicationDAO.create(publication);
		auth.setUserData(request, response);
	}

	private void editPublicationPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		openView = "index.jsp";
		request.setAttribute("publications", publicationDAO.listAll());

		// file server publication
		FileServer fileServer = new FileServer();
		fileServer.setFileName(request.getParameter("txtID"));
		fileServer.setExtension("html");
		fileServer.setPath("storage\\publications");
		fileServer.writeFile(request.getParameter("txtTextAreaT"));

		// publication
		Publication publication = new Publication();
		publication.setIdPubli(Integer.parseInt(request.getParameter("txtID")));
		publication.setTitle(request.getParameter("txtTitleT"));
		publication.setCategory(categories[Integer.parseInt(request.getParameter("txtCategoryT"))]);
		publication.setDescription(request.getParameter("txtDescriptionT"));
		publication.setFileName(fileServer.getFileName());
		publication.setExtension(fileServer.getExtension());
		publication.setPathFileName(fileServer.getPathRelative());
		Date datePublication = new Date();
		publication.setDate(datePublication);

		// Author
		HttpSession sessao = request.getSession();
		UserDAO userDAO = new UserDAO();
		String user = sessao.getAttribute("email").toString();
		publication.setAuthor(userDAO.listForLogin(user).getIdUser());
		try {

		} catch (Exception e) {

		}
		// file server thumb
		JpegConverter jpegConverter = new JpegConverter();
		jpegConverter.saveImage(request, response, request.getParameter("txtID"), "thumb", "storage\\thumb");

		fileServer.setPath("storage\\thumb");
		fileServer.setExtension(jpegConverter.getExtension());
		publication.setThumb(request.getParameter("txtID"));
		publication.setPathThumb(fileServer.getPathRelative());
		publicationDAO.update(publication);
		auth.setUserData(request, response);
	}

	// GET

	private void editPublication(HttpServletRequest request, HttpServletResponse response) {

		openView = "edit_publication.jsp";
		FileServer fileServer = new FileServer();
		JpegConverter jpegConverter = new JpegConverter();

		fileServer.setPath("storage\\publications");
		fileServer.setExtension("html");
		fileServer.setFileName(request.getParameter("id"));

		request.setAttribute("publicationEdit", publicationDAO.listForName(request.getParameter("id")));
		request.setAttribute("contentPubli", fileServer.readFile(fileServer.getPathWithFileName()));
		request.setAttribute("thumbValue", jpegConverter.readFile(fileServer.getPathWithFileName()));
		auth.setUserData(request, response);
	}

	private void deletePublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] extensions = new String[] { "apng", "gif", "ico", "cur", "jpg", "jpeg", "jfif", "pjpeg", "pjp", "png",
				"svg" };
		FileServer fileServer = new FileServer();

		// Delete publication
		fileServer.setFileName(request.getParameter("filename"));
		fileServer.setExtension("html");
		fileServer.setPath("storage\\publications");
		fileServer.deleteFile(fileServer.getPathWithFileName());

		// Delete thumb
		fileServer.setPath("storage\\thumb");
		for (String st : extensions) {
			fileServer.setExtension(st);
			fileServer.deleteFile(fileServer.getPathWithFileName());
		}
		publicationDAO.deleteForFileName(fileServer.getFileName());
		openView = "index.jsp";
		request.setAttribute("publications", publicationDAO.listAll());
		auth.setUserData(request, response);
	}

	private void openPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileServer fileServer = new FileServer();
		fileServer.setPath("storage\\publications");
		fileServer.setExtension("html");
		fileServer.setFileName(request.getParameter("id"));
		String open = fileServer.readFile(fileServer.getPathWithFileName());
		request.setAttribute("openPubli", open);
		auth.setUserData(request, response);
	}
	public static void main(String[] args) {
		PublicationDAO dao = new PublicationDAO();
		System.out.println();
		for (Publication p : dao.listForAuthor(23)) {
			System.out.println(p.getCategory());
			System.out.println(p.getDescription());
			System.out.println(p.getTitle());
		}
		
	}
}