<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <title>JDB - Login</title>
    <%@include file="head.jsp" %>
</head>

<body>

    <div class="bg-dark p-4 pb-3">
        <%@include file="header_logout.jsp" %>
            <div class="form-cabecalho-display">
                <div class="d-flex justify-content-between">
                    <a class="btn btn-secondary  me-2  mb-3 form-cabecalho-2" data-bs-toggle="dropdown" href="#">Categ...</a>
                    <form class="d-flex form-cabecalho-2 mb-3" role="search">
                        <input class="form-control form-cabecalho-2 me-2" type="search" placeholder="Pesquisar..." aria-label="Search" />
                        <button class="btn btn-primary form-cabecalho-2" type="submit">
                            <span class="material-symbols-outlined fs-3">search</span>
                        </button>
                    </form>
                    <ul class="dropdown-menu dropdown-menu-dark">
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list">Inicio</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=0">Política</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=1">Business</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=2">Internacional</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=3">Esportes</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=4">Saúde</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=5">Tecnologia</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=6">Entretenimento</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=7">Estilo</a></li>
                        <li class="dropdown-item btn py-2 text-light"><a href="publication?action=list&category=8">Gastronomia</a></li>
                    </ul>
                </div>
            </div>
    </div>
    <div class="container" style="max-width: 500px;">
        <div class="max-width-login mx-auto">

            <p id="msg" class="mt-3 fs-3 ${css} text-center" style="display: none;">${msg}</p>

            <form action="user" method="post">
                <input type="hidden" name="action" value="login">
                <div class="d-flex max-width-login border border-3 rounded-2 row align-items-center mt-5 p-4 mx-auto">

                    <h3 class="p-0 mb-4 text-center">Login Jornal do Brasil</h3>

                    <label class="form-label p-0" for="txtEmail">Usuário</label>
                    <input id="txtEmail" name="txtEmail" type="email" class="form-control p-2 shadow-sm border border-1">


                    <label class="form-label p-0 mt-3" for="txtPassword">Senha</label>
                    <input id="txtPassword" name="txtPassword" type="password" class="form-control p-2 shadow-sm border border-1">

                    <div class="d-flex mt-4 align-items-center justify-content-between flex-wrap">
                        <div class="d-flex align-items-center">
                            <input name="txtRemember" id="txtRemember" class="form-check-input p-2 me-2 my-0 shadow-sm" type="checkbox">
                            <label class="form-label p-0 m-0" for="txtRemember">Lembre de mim</label>
                        </div>
                        <a href="#" class="text-decoration-none">Esqueceu a senha?</a>
                    </div>
                    <button type="submit" class="btn btn-primary mt-4 px-5">Entrar</button>
                    <p class="text-center m-0 mt-3">Não tem uma conta?&nbsp;&nbsp;<a href="create_account.jsp" class="text-decoration-none">Inscreva-se</a></p>
                </div>
            </form>




        </div>
    </div>
    <script src="assets/js/search.js"></script>
    <script src="assets/js/verify.js"></script>
</body>

</html>