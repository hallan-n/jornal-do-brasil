
package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javax.servlet.RequestDispatcher;

import config.Env;
import model.Publication;
import services.FileServer;
import services.JpegConverter;
import dao.PublicationDAO;

@MultipartConfig
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

		if (action.equals("list") && category == null) {
			openView = "index.jsp";
			request.setAttribute("publications", publicationDAO.listAll());
		} else if (action.equals("list") && category != null) {
			openView = "index.jsp";
			request.setAttribute("publications",
					publicationDAO.listForCategory(categories[Integer.parseInt(category)]));
		} else if (action.equals("delete")) {
			deletePublication(request, response);
		} else if (action.equals("open")) {
			openPublication(request, response);
		} else if (action.equals("edit")) {
			// editPublication(request, response);
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
		}
		else if (action.equals("form")) {
			saveImage(request, response);
		}
		else if (action.equals("edit")) {
		// editPublicationPost(request, response);
		}

		RequestDispatcher view = request.getRequestDispatcher(openView);
		view.forward(request, response);
	}

	// POST
	private void saveImage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String UPLOAD_DIR = "C:\\Source"; // Diretório onde as imagens serão salvas

		// Verifica se a requisição contém um arquivo
		if (request.getParts().isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nenhum arquivo enviado");
			return;
		}

		// Obtém o arquivo do formulário
		Part filePart = request.getPart("file");

		// Extrai o nome do arquivo do cabeçalho do conteúdo
		String fileName = getFileName(filePart);

		// Cria o diretório de destino, se ainda não existir
		File uploadDir = new File(UPLOAD_DIR);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		// Cria o caminho completo do arquivo no diretório de destino
		String filePath = UPLOAD_DIR + File.separator + fileName;

		// Grava o arquivo no servidor
		try (InputStream inputStream = filePart.getInputStream();
				OutputStream outputStream = new FileOutputStream(filePath)) {
			int bytesRead;
			final byte[] buffer = new byte[1024];
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		}

		// Envie uma resposta de sucesso ao cliente
		response.getWriter().println("Arquivo '" + fileName + "' enviado com sucesso!");
	}

	private String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String[] elements = contentDisposition.split(";");
		for (String element : elements) {
			if (element.trim().startsWith("filename")) {
				return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	private void createPublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		openView = "index.jsp";

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
		publication.setAuthor(1);

		// file server thumb
		fileServer.setFileName(env.uuid);
		fileServer.setExtension("html");
		fileServer.setPath("storage\\thumb");
		fileServer.writeFile(request.getParameter("thumbValue"));

		// publication
		publication.setThumb(fileServer.getFileName());
		publication.setPathThumb(fileServer.getPathRelative());
		publicationDAO.create(publication);
	}

	// private void editPublicationPost(HttpServletRequest request,
	// HttpServletResponse response) {
	// openView = "index.jsp";

	// FileServer fileServer = new FileServer();
	// fileServer.setFileName(request.getParameter("uuidTitle"));
	// fileServer.setExtension("html");
	// fileServer.setPath("storage\\publications");

	// Publication publication = new Publication();
	// publication.setTitle(request.getParameter("txtTitleT"));
	// publication.setCategory(categories[Integer.parseInt(request.getParameter("txtCategoryT"))]);
	// publication.setDescription(request.getParameter("txtDescriptionT"));
	// publication.setFileName(fileServer.getFileName());
	// publication.setExtension(fileServer.getExtension());
	// publication.setPath(fileServer.getPathRelative());
	// publication.setAuthor(1);
	// publication.setIdPubli(Integer.parseInt(request.getParameter("txtID")));
	// Date d = new Date();
	// publication.setDate(d);
	// if (publicationDAO.update(publication)) {
	// fileServer.writeFile(request.getParameter("txtTextAreaT"));
	// }
	// }

	// // GET
	// private void editPublication(HttpServletRequest request, HttpServletResponse
	// response) {

	// openView = "edit_publication.jsp";
	// FileServer fileServer = new FileServer();
	// fileServer.setPath("storage\\publications");
	// fileServer.setExtension("html");
	// fileServer.setFileName(request.getParameter("id"));
	// request.setAttribute("publicationEdit",
	// publicationDAO.listForName(request.getParameter("id")));
	// request.setAttribute("contentPubli",
	// fileServer.readFile(fileServer.getPathWithFileName()));
	// request.setAttribute("uuid", request.getParameter("id"));
	// }

	private void deletePublication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileServer fileServer = new FileServer();
		fileServer.setFileName(request.getParameter("filename"));
		fileServer.setExtension("html");
		fileServer.setPath("storage\\publications");
		fileServer.deleteFile(fileServer.getPathWithFileName());
		fileServer.setPath("storage\\thumb");
		fileServer.deleteFile(fileServer.getPathWithFileName());
		publicationDAO.deleteForFileName(fileServer.getFileName());
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