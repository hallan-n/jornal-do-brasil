
<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("email") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@include file="head.jsp" %>
    <title>JDB - Perfil</title>
</head>

<body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

    <div class="bg-dark p-4 pb-3">
        <header id="header">
            <%@include file="header.jsp" %>
        </header>
    </div>
    <div class="container">
        <div class="mx-auto mt-5 p-5" style="max-width: 1300px;">
            <div class="border border-3 align-items-center p-5 rounded-3 row">
                <div class="col-3">
                    <div>
                        <img class="rounded-circle" src="assets/images/perfil.jpg" alt="..." width="100%">
                    </div>
                    <div class="d-grid mt-3">
                        <button class="btn btn-primary">Editar</button>
                    </div>
                </div>
               
                <div class="col-8 ms-5">
                    <div>
                        <div>
                            <p class="p-0 m-0"><span><strong>Nome: &nbsp;</strong></span>Hállan Guilherme Santos das Neves</p>
                        </div>
                        <hr class="my-2">
                        <div>
                            <p class="p-0 m-0"><span><strong>Email: &nbsp;</strong></span>hallanneves01@gmail.com</p>
                        </div>
                        <hr class="my-2">
                        <div>
                            <p class="p-0 m-0"><span><strong>Telefone: &nbsp;</strong></span>27 98822-3839</p>
                        </div>
                        <hr class="my-2">
                        <div>
                            <p class="p-0 m-0"><span><strong>Descrição: &nbsp;</strong></span>is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to mak</p>
                        </div>
                    </div>
                </div>
     
            </div>
            <div class="d-flex justify-content-end mt-3">
                <button class="btn btn-primary px-4">Salvar</button>
            </div>
        </div>
    </div>




    <script src="assets/js/search.js"></script>
    <script src="assets/js/verify.js"></script>
</body>

</html>