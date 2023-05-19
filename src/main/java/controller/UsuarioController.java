package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
public class UsuarioController extends HttpServlet {

    // Variaveis globais
    private String acao, abrir;
    private final String cadastrar = "cadastrar_aluno.jsp";
    private final String editar = "cadastrar_aluno.jsp";
    private final String listar = "listar_alunos.jsp";
    private final String sucesso = "sucesso.jsp";
    private final String erro = "erro.jsp";
    private final static String a = "asd";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
        acao = request.getParameter("acao");
        
        if (acao.equals("listar")) {
            
            AlunoDAO dao = new AlunoDAO();
            abrir = listar;
            request.setAttribute("alunos", dao.read());
            
        }
        
        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        visualizar.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        acao = request.getParameter("acao");
        if (acao.equals("cadastrar")) {
            Aluno aluno = new Aluno();
            aluno.setNome(request.getParameter("txtNome"));
            aluno.setEmail(request.getParameter("txtEmail"));
            aluno.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
            aluno.setTelefone(request.getParameter("txtTelefone"));
            AlunoDAO dao = new AlunoDAO();
            if (dao.create(aluno)) {
                abrir = sucesso;
                request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
            }
        }
        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        visualizar.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
