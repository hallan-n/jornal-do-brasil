
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@include file="head.jsp" %>
    <title>JDB - Criar conta</title>
</head>

<body>

    <div class="bg-dark p-4 pb-3">
        <%@include file="header_logout.jsp" %>
    </div>
    <div>
        <div class="container max-width-container">
            <div>
                <div class="row g-0 pt-3 mt-5 border border-3 rounded-2">
                    <div class="col-md-6 mb-md-0 p-md-4">
                        <h3 class="text-center w-75 mx-auto">Criar conta no Jornal do Bostil</h3>

                        <div class="d-flex justify-content-center form-cabecalho-1">
                            <img src="assets/images/ilustração-formulario.jpg" class="w-75 form-cabecalho-1 mt-5">
                        </div>
                    </div>

                    <div class="col-md-6 p-4 ps-md-0">
                        <form action="user" method="post" onsubmit="return passvalidate()">
                            <input type="hidden" name="action" value="create">
                            <div class="d-flex flex-column">
                                <input id="txtName" name="txtName" required type="text" class="form-control p-2 mt-2 shadow-sm border border-1" placeholder="Nome" maxlength="45" >
                                <input id="txtSurname" name="txtSurname" required type="text" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Sobrenome" maxlength="45" >
                                <p id="msg" class="text-danger mt-2 m-0" style="display: none;">${msg}</p>
                                <input id="txtEmail" name="txtEmail" required type="email" class="form-control p-2 mt-2 shadow-sm border border-1" placeholder="Email" maxlength="100" >
                                <input id="txtPhone" name="txtPhone" required type="tel" class="form-control p-2 mt-2 shadow-sm border border-1" placeholder="Telefone" maxlength="11" >
                                <input id="txtPassword" name="txtPassword" required type="password" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Senha" maxlength="45" >
                                <input id="txtPassword2" name="txtPassword2" required type="password" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Repetir senha" maxlength="45">

                                <button type="submit" class="btn btn-primary px-4 mt-2">Registrar</button>
                                <div class="d-flex justify-content-between mt-4 flex-wrap">
                                    <div class="d-flex mb-2">
                                        <input name="txtAcceptTerms" id="txtAcceptTerms" required class="form-check-input p-2 me-2 m-0 shadow-sm" type="checkbox">
                                        <label class="form-label p-0 m-0" for="txtAcceptTerms">Aceitar termos</label>
                                    </div>
                                    <a href="login.jsp" class="text-decoration-none mb-2">Ja sou cadastrado</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="assets/js/verify.js"></script>
    <script src="assets/js/search.js"></script>
</body>

</html>