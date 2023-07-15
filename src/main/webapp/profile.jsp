
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
            <p id="msg" class="mt-3 fs-3 ${css} text-center" style="display: none;">${msg}</p>
            <div class="border border-3 align-items-center p-5 rounded-3 d-flex flex-wrap gap-5 justify-content-center">
                <div>
                    <img class="profileDefault rounded-circle" src="${user.pathProfilePhoto}" alt="..." width="300px" height="300px">
                </div>
                <div style="max-width: 90%;">
                    <div>
                        <div>
                            <p class="p-0 m-0"><strong>Nome: &nbsp;</strong>${user.name}</p>
                            <hr class="my-2">
                        </div>
                        <div>
                            <p class="p-0 m-0"><strong>Sobrenome: &nbsp;</strong>${user.surname}</p>
                            <hr class="my-2">
                        </div>
                        <div>
                            <p class="p-0 m-0"><strong>Email: &nbsp;</strong>${user.email}</p>
                            <hr class="my-2">
                        </div>
                        <div>
                            <p class="p-0 m-0"><strong>Telefone: &nbsp;</strong>${user.phone}</p>
                            <hr class="my-2">
                        </div>
                        <div>
                            <p class="p-0 m-0" style="word-wrap: break-word;"><strong>Descrição: &nbsp;</strong>${user.description}</p>
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
    <script src="assets/js/search.js"></script>
    <script src="assets/js/verify.js"></script>
</body>

</html>