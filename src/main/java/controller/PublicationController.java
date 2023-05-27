package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublicationDAO;
import model.Publication;
import services.FileServer;

public class PublicationController extends HttpServlet{

    private String acao;
    private String abrir;
    private final String cadastrar = "cadastrar_aluno.jsp";
    private final String editar = "editar_aluno.jsp";
    private final String listar = "listar_alunos.jsp";
    private final String sucesso = "sucesso.jsp";
    private final String erro = "erro.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    // @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {

    //     acao = request.getParameter("acao");
    //     AlunoDAO dao = new AlunoDAO();

    //     if (acao.equals("listar")) {
    //         abrir = listar;
    //         request.setAttribute("alunos", dao.read());
    //     } else if (acao.equals("editar")) {
    //         int idAluno = Integer.parseInt(request.getParameter("id"));
    //         request.setAttribute("aluno", dao.findId(idAluno));
    //         abrir = editar;
    //     }
    //     RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
    //     visualizar.forward(request, response);
    // }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response)
        //     throws ServletException, IOException {

        // acao = request.getParameter("acao");
        // if (acao.equals("cadastrar")) {
        //     Aluno aluno = new Aluno();
        //     aluno.setNome(request.getParameter("txtNome"));
        //     aluno.setEmail(request.getParameter("txtEmail"));
        //     aluno.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
        //     aluno.setTelefone(request.getParameter("txtTelefone"));
        //     AlunoDAO dao = new AlunoDAO();

        //     if (dao.create(aluno)) {
        //         abrir = sucesso;
        //         request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
        //     } else {
        //         abrir = erro;
        //         request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
        //     }
        // } else if (acao.equals("editar")) {

        //     Aluno alu = new Aluno();

        //     alu.setIdAluno(Integer.parseInt(request.getParameter("txtId")));
        //     alu.setNome(request.getParameter("txtNome"));
        //     alu.setEmail(request.getParameter("txtEmail"));
        //     alu.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
        //     alu.setTelefone(request.getParameter("txtTelefone"));

        //     AlunoDAO dao = new AlunoDAO();

        //     if (dao.update(alu)) {
        //         abrir = listar;
        //         request.setAttribute("alunos", dao.read());
        //     } else {
        //         abrir = erro;
        //         request.setAttribute("msg", "Ops... Erro ao atualizar Aluno!");

        //     }

        //     RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        //     visualizar.forward(request, response);

        // }
    // }

    public static void main(String[] args) {
        FileServer fileServer = new FileServer();
        fileServer.setPath("/src/main/java/storage/");
        fileServer.setFileName("Teste");
        fileServer.setExtension(".html");
        fileServer.writeFile("teste");

    }
}
