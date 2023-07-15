
<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("email") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@include file="head.jsp" %>
    <title>JDB - Perfil</title>
</head>

<body>

    <div class="bg-dark p-4 pb-3">
        <header id="header">
            <%@include file="header.jsp" %>
        </header>
    </div>
    <div class="container">
        <div class="mx-auto mt-5 p-5" style="max-width: 800px;">
            <p id="msg" class="mt-3 fs-3 text-success text-center" style="display: none;">${msg}</p>
            <div class="border border-3 align-items-center p-5 rounded-3 d-flex flex-wrap gap-5 justify-content-center">
                <div style="min-height: 100px">
                    <a class="position-relative" href="user?action=edit" role="button">
                        <img class="rounded-circle" src="${user.pathProfilePhoto}" alt="..." width="300px" height="300px" style="filter: brightness(50%);">
                        <span class="material-symbols-outlined position-absolute fs-3 top-0 start-50 translate-middle text-light">edit_square</span>
                    </a>
                </div>
                <div>
                    <div>
                        <div>
                            <p class="p-0 m-0"><span><strong>Nome: &nbsp;</strong></span>${user.name}</p>
                            <hr class="my-2">
                        </div>
                        <div>
                            <p class="p-0 m-0"><span><strong>Sobrenome: &nbsp;</strong></span>${user.name}</p>
                            <hr class="my-2">
                        </div>
                        <div>
                            <p class="p-0 m-0"><span><strong>Email: &nbsp;</strong></span>${user.email}</p>
                            <hr class="my-2">
                        </div>
                        <div>
                            <p class="p-0 m-0"><span><strong>Telefone: &nbsp;</strong></span>${user.phone}</p>
                            <hr class="my-2">
                        </div>
                        <div>
                            <p class="p-0 m-0"><span><strong>Descrição: &nbsp;</strong></span>${user.description}</p>
                        </div>
                    </div>
                </div> 
            </div>
            <div class="d-flex justify-content-end mt-3">
                <a class="btn btn-primary px-4" href="user?action=edit">Editar</a>
            </div>
        </div>
    </div>




    <script src="assets/js/search.js"></script>
    <script src="assets/js/verify.js"></script>
</body>

</html>